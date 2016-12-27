package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.enums.Strategy

/**
 * Builder of 'sequence' sections
 */
class SequenceBuilder extends CommandsBuilder {

    boolean keepgoing

    Strategy strategy

    def keepgoing(boolean value = true) {
        this.keepgoing = value
    }

    def strategy(Strategy value) {
        this.strategy = value
    }

    static def generateXml(SequenceBuilder b) {
        return {
            def attributes = [:]
            if (b.keepgoing) {
                attributes.put('keepgoing', b.keepgoing)
            }
            if (b.strategy) {
                attributes.put('strategy', b.strategy.mnemonic)
            }
            sequence(attributes) {
                b.commands.each { e ->
                    command {
                        with Shortcuts.generateXml(e.builder, e.closure)
                    }
                }
            }
        }
    }
}
