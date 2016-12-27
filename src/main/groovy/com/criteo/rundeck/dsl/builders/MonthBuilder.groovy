package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'month' sections
 */
class MonthBuilder {

    String month

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
            if (b.day) {
                attributes.put('day', b.day)
            }
            if (b.month) {
                attributes.put('month', b.month)
            }
            month(attributes)
        }
    }
}
