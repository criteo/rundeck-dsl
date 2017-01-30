package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'month' sections
 */
class MonthBuilder {

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
