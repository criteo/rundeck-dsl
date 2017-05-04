package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
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

    @MethodDoc('Sets the hour when to trigger the execution.')
    def hour(String value) {
        this.hour = value
    }

    @MethodDoc('Sets the minute when to trigger the execution.')
    def minute(String value) {
        this.minute = value
    }

    @MethodDoc('Sets the seconds when to trigger the execution.')
    def seconds(String value) {
        this.seconds = value
    }

}
