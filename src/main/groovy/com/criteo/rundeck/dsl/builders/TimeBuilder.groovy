package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'time' sections
 */
class TimeBuilder {

    @YamlProperty
    String hour

    @YamlProperty
    String minute

    @YamlProperty
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
