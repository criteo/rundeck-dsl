package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
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

    BuildingClosure command

    Boolean keepgoingOnSuccess

    @MethodDoc('Sets whether the workflow sequence shall continue when the error handler succeeds and when the workflow "keepgoing" is false.')
    def keepgoingOnSuccess(Boolean value) {
        this.keepgoingOnSuccess = value
    }

    def keepgoingOnSuccess() {
        this.keepgoingOnSuccess(true)
    }

    def registerCommand(BuildingClosure c) {
        this.command = c
    }

}
