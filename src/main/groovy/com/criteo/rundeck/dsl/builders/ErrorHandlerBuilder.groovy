package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.ErrorHandler

/**
 * Builder of 'error-handler' sections
 */
class ErrorHandlerBuilder extends CommandsBuilder {

    def build() {
        ErrorHandler e = new ErrorHandler()

        e.command = this.command?.value ? this.command.realize().build() : null
        e.keepgoingOnSuccess = this.keepgoingOnSuccess

        return e
    }

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
