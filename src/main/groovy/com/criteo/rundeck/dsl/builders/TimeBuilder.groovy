package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'time' sections
 */
class TimeBuilder {

    String hour

    String minute

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

    static def generateXml(TimeBuilder b) {
        return {
            time(hour: b.hour, minute: b.minute, seconds: b.seconds)
        }
    }
}
