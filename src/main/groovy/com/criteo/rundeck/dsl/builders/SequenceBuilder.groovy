package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.Sequence
import com.criteo.rundeck.dsl.model.Strategy

/**
 * Builder of 'sequence' sections
 */
class SequenceBuilder extends CommandsBuilder {

    def build() {
        Sequence s = new Sequence()

        s.commands = this.commands.collect { it.realize().build() }
        s.keepgoing = this.keepgoing
        s.strategy = this.strategy

        return s
    }

    def commands = []

    Boolean keepgoing

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
