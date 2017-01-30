package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.Strategy

/**
 * Builder of 'sequence' sections
 */
class SequenceBuilder extends CommandsBuilder {

    @YamlProperty
    def commands = []

    @YamlProperty
    Boolean keepgoing

    @YamlProperty
    Strategy strategy

    def keepgoing(Boolean value = true) {
        this.keepgoing = value
    }

    def strategy(Strategy value) {
        this.strategy = value
    }

    def registerCommand(BuildingClosure c) {
        this.commands.add(c)
    }

}
