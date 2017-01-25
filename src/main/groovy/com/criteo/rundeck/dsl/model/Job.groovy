package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty
import org.apache.commons.lang3.StringEscapeUtils

class Job {

    def checker() {

        if (this.retry != null && this.retry != '\${option.retry}' && this.retry < 0 )
            throw new Error("Retry value should be an integer or can reference to a job option value ('\${option.retry}')")

        if (this.timeout != null) {
            def validFormat = /\d+|(\d+d)? ?(\d+h)? ?(\d+m)? ?(\d+s)?/
            def match = this.timeout ==~ validFormat
            if (!match.matches())
                throw new Error("""The timeout format is invalid. Value can be a number of second or a series of integer using d (days), h (hours), m (minutes or s (seconds). It was: ${this.timeout}""")
        }

        return null
    }

    @YamlProperty
    String description

    @YamlProperty
    String group

    @YamlProperty
    LogLevel loglevel

    @YamlProperty(merge=true)
    Loglimit loglimit

    @YamlProperty
    Boolean multipleExecutions

    @YamlProperty
    String name

    @YamlProperty
    Nodefilters nodefilters

    @YamlProperty
    Notification notification

    @YamlProperty(merge=true)
    Options options

    @YamlProperty
    Orchestrator orchestrator

    @YamlProperty
    Integer retry

    @YamlProperty
    Schedule schedule

    @YamlProperty
    Sequence sequence

    @YamlProperty
    String timeout

    @YamlProperty
    UUID uuid
}
