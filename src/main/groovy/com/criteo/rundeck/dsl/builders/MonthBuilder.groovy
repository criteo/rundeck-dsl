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

    static def generateXml(MonthBuilder b) {
        return {
            def attributes = [:]
            if (b.day != null) {
                attributes.put('day', b.day)
            }
            if (b.month != null) {
                attributes.put('month', b.month)
            }
            month(attributes)
        }
    }
}
