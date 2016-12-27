package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'schedule' sections
 */
class ScheduleBuilder {

    String crontab

    Closure monthClosure

    Closure timeClosure

    Closure weekdayClosure

    String year

    def crontab(String value) {
        this.crontab = value
    }

    def month(String monthValue, @DelegatesTo(MonthBuilder) Closure value = {}) {
        this.monthClosure = {
            delegate.month(monthValue)
            with value
        }
    }

    def time(@DelegatesTo(TimeBuilder) Closure value) {
        this.timeClosure = value
    }

    def weekday(@DelegatesTo(WeekdayBuilder) Closure value) {
        this.weekdayClosure = value
    }

    def year(String value) {
        this.year = value
    }

    static def generateXml(ScheduleBuilder b) {
        return {
            if (b.crontab) {
                // TODO: check format
                // TODO: check other fields are null
                schedule('crontab': b.crontab)
            } else {
                schedule {
                    if (b.monthClosure) {
                        with Shortcuts.generateXml(MonthBuilder, b.monthClosure)
                    }
                    if (b.timeClosure) {
                        with Shortcuts.generateXml(TimeBuilder, b.timeClosure)
                    }
                    if (b.weekdayClosure) {
                        with Shortcuts.generateXml(WeekdayBuilder, b.weekdayClosure)
                    }
                    if (b.year) {
                        year(year: b.year)
                    }
                }
            }
        }
    }
}
