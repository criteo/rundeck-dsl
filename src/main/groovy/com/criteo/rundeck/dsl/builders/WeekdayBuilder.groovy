package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.Weekday

/**
 * Builder of 'day' sections
 */
class WeekdayBuilder {

    def build() {
        Weekday w = new Weekday()

        w.day = this.day

        return w
    }

    String day

    def day(String value) {
        this.day = value
    }

}
