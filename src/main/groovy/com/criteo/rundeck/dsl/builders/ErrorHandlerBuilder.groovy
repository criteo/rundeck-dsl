package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'error-handler' sections
 */
class ErrorHandlerBuilder extends CommandsBuilder {

    @YamlProperty(merge=true)
    BuildingClosure command

    @YamlProperty
    Boolean keepgoingOnSuccess

    def keepgoingOnSuccess(Boolean value = true) {
        this.keepgoingOnSuccess = value
    }

    def registerCommand(BuildingClosure c) {
        this.command = c
    }

}
