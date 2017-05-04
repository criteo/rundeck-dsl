package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
import com.criteo.rundeck.dsl.model.Month

/**
 * Builder of 'month' sections
 */
class MonthBuilder {

    def build() {
        Month m = new Month()

        m.month = this.month
        m.day = this.day

        return m
    }

    String month

    String day

    // Sets the months when to trigger the execution (documented in the caller)
    def month(String value) {
        this.month = value
    }

    @MethodDoc('Sets the days when to trigger the execution.')
    def day(String value) {
        this.day = value
    }

}
