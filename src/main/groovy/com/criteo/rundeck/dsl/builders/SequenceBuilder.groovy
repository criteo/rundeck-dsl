package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
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

    @MethodDoc('Sets whether the sequence should keep going if an error occurs.')
    def keepgoing(Boolean value = true) {
        this.keepgoing = value
    }

    @MethodDoc('Sets the strategy for executing the sequence across a set of nodes.')
    def strategy(Strategy value) {
        this.strategy = value
    }

    def registerCommand(BuildingClosure c) {
        this.commands.add(c)
    }

}
