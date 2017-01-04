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

    static def generateXml(WeekdayBuilder b) {
        return {
            def attributes = [:]
            if (b.day != null) {
                attributes.put('day', b.day)
            }
            weekday(attributes)
        }
    }
}
