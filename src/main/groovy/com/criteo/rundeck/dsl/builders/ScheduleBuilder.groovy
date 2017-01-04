package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'schedule' sections
 */
class ScheduleBuilder {

    String crontab

    BuildingClosure monthClosure = new BuildingClosure(MonthBuilder)

    BuildingClosure timeClosure = new BuildingClosure(TimeBuilder)

    BuildingClosure weekdayClosure = new BuildingClosure(WeekdayBuilder)

    String year

    def crontab(String value) {
        this.crontab = value
    }

    def month(String monthValue, @DelegatesTo(MonthBuilder) Closure value = {}) {
        this.monthClosure.absorb({
            delegate.month(monthValue)
            with value
        }, true)
    }

    def time(@DelegatesTo(TimeBuilder) Closure value) {
        this.timeClosure.absorb(value, true)
    }

    def weekday(@DelegatesTo(WeekdayBuilder) Closure value) {
        this.weekdayClosure.absorb(value, true)
    }

    def year(String value) {
        this.year = value
    }

    static def generateXml(ScheduleBuilder b) {
        return {
            if (b.crontab != null) {
                // TODO: check format
                // TODO: check other fields are null
                schedule('crontab': b.crontab)
            } else {
                schedule {
                    if (b.monthClosure.value) {
                        with Shortcuts.generateXml(b.monthClosure)
                    }
                    if (b.timeClosure.value) {
                        with Shortcuts.generateXml(b.timeClosure)
                    }
                    if (b.weekdayClosure.value) {
                        with Shortcuts.generateXml(b.weekdayClosure)
                    }
                    if (b.year != null) {
                        year(year: b.year)
                    }
                }
            }
        }
    }
}
