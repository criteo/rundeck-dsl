package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.Time

/**
 * Builder of 'time' sections
 */
class TimeBuilder {

    def build() {
        Time t = new Time()

        t.hour = this.hour
        t.minute = this.minute
        t.seconds = this.seconds

        return t
    }

    String hour

    String minute

    String seconds

    def hour(String value) {
        this.hour = value
    }

    def minute(String value) {
        this.minute = value
    }

    def seconds(String value) {
        this.seconds = value
    }

}
