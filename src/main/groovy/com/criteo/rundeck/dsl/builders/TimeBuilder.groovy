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
            def attributes = [:]
            if (b.hour != null) {
                attributes.put('hour', b.hour)
            }
            if (b.minute != null) {
                attributes.put('minute', b.minute)
            }
            if (b.seconds != null) {
                attributes.put('seconds', b.seconds)
            }
            time(attributes)
        }
    }
}
