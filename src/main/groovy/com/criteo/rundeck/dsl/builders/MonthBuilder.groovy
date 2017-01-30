package com.criteo.rundeck.dsl.builders

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

    @YamlProperty
    String month

    @YamlProperty(name="dayofmonth")
    String day

    def month(String value) {
        this.month = value
    }

    def day(String value) {
        this.day = value
    }

}
