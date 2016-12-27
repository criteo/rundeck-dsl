package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'day' sections
 */
class WeekdayBuilder {

    String day

    def day(String value) {
        this.day = value
    }

    static def generateXml(WeekdayBuilder b) {
        return {
            weekday(day: b.day)
        }
    }
}
