package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'day' sections
 */
class WeekdayBuilder {

    @YamlProperty
    String day

    def day(String value) {
        this.day = value
    }

}
