package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'schedule' sections
 */
class ScheduleBuilder {

    @YamlProperty
    String crontab

    @YamlProperty(merge=true)
    BuildingClosure month = new BuildingClosure(MonthBuilder)

    @YamlProperty
    BuildingClosure time = new BuildingClosure(TimeBuilder)

    @YamlProperty
    BuildingClosure weekday = new BuildingClosure(WeekdayBuilder)

    @YamlProperty
    String year

    def crontab(String value) {
        this.crontab = value
    }

    def month(String monthValue, @DelegatesTo(MonthBuilder) Closure value = {}) {
        this.month.absorb({
            delegate.month(monthValue)
            with value
        }, true)
    }

    def time(@DelegatesTo(TimeBuilder) Closure value) {
        this.time.absorb(value, true)
    }

    def weekday(@DelegatesTo(WeekdayBuilder) Closure value) {
        this.weekday.absorb(value, true)
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
                    if (b.month.value) {
                        with Shortcuts.generateXml(b.month)
                    }
                    if (b.time.value) {
                        with Shortcuts.generateXml(b.time)
                    }
                    if (b.weekday.value) {
                        with Shortcuts.generateXml(b.weekday)
                    }
                    if (b.year != null) {
                        year(year: b.year)
                    }
                }
            }
        }
    }
}
