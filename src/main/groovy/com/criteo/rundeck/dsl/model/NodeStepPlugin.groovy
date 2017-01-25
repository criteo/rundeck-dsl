package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class NodeStepPlugin extends Command {

    def checker() { return null }

    @YamlProperty
    Configuration configuration

    @YamlProperty
    String type

    @YamlProperty
    boolean nodeStep = true
}
