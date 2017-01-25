package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class ErrorHandler {

    def checker() { return null }

    @YamlProperty(merge=true)
    Command command

    @YamlProperty
    Boolean keepgoingOnSuccess
}
