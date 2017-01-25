package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

abstract class Command {

    @YamlProperty
    String description

    @YamlProperty
    ErrorHandler errorhandler

    def checker() { return null }
}
