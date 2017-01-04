package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.enums.Strategy

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

    static def generateXml(SequenceBuilder b) {
        return {
            def attributes = [:]
            if (b.keepgoing != null) {
                attributes.put('keepgoing', b.keepgoing)
            }
            if (b.strategy) {
                attributes.put('strategy', b.strategy.toString())
            }
            sequence(attributes) {
                b.commands.each { BuildingClosure e ->
                    command {
                        with Shortcuts.generateXml(e)
                    }
                }
            }
        }
    }
}
