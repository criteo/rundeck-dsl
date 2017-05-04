package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
import com.criteo.rundeck.dsl.model.Schedule

/**
 * Builder of 'schedule' sections
 */
class ScheduleBuilder {

    def build() {
        Schedule s = new Schedule()

        s.crontab = this.crontab
        s.month = this.month?.value ? this.month.realize().build() : null
        s.time = this.time?.value ? this.time.realize().build() : null
        s.weekday = this.weekday?.value ? this.weekday.realize().build() : null
        s.year = this.year

        return s
    }

    String crontab

    BuildingClosure month = new BuildingClosure(MonthBuilder)

    BuildingClosure time = new BuildingClosure(TimeBuilder)

    BuildingClosure weekday = new BuildingClosure(WeekdayBuilder)

    String year

    @MethodDoc('Sets this schedule with a crontab formatted string') // TODO: add a link to the details of the syntax
    def crontab(String value) {
        this.crontab = value
    }

    @MethodDoc('Sets the months for this schedule') // TODO: take array as argument, take enumeration for months
    def month(String monthValue, @DelegatesTo(MonthBuilder) Closure value = {}) {
        this.month.absorb({
            delegate.month(monthValue)
            with value
        }, true)
    }

    @MethodDoc('Sets the time for this schedule')
    def time(@DelegatesTo(TimeBuilder) Closure value) {
        this.time.absorb(value, true)
    }

    @MethodDoc('Sets the weekdays for this schedule')
    def weekday(@DelegatesTo(WeekdayBuilder) Closure value) {
        this.weekday.absorb(value, true)
    }

    @MethodDoc('Sets the years for this schedule')
    def year(String value) {
        this.year = value
    }

}
