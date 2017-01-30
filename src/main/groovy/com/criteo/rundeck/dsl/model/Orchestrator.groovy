package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

abstract class Orchestrator {

    def checker() { return null }

    @YamlProperty
    String type

    @YamlProperty
    Configuration configuration
}
