package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
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

    // TODO: introduce an enumeration and have "day" accept a list of members instead

    @MethodDoc('Sets the days of the week when to trigger the execution.')
    def day(String value) {
        this.day = value
    }

}
