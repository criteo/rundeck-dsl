package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class Sequence {

    def checker() { return null }

    @YamlProperty
    def commands = []

    @YamlProperty
    Boolean keepgoing

    @YamlProperty
    Strategy strategy
}
