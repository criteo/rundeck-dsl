package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'error-handler' sections
 */
class ErrorHandlerBuilder extends CommandsBuilder {

    boolean keepgoingOnSuccess

    def keepgoingOnSuccess(boolean value = true) {
        this.keepgoingOnSuccess = value
    }

    static def generateXml(ErrorHandlerBuilder b) {
        return {
            errorhandler(keepgoingOnSuccess: Boolean.toString(b.keepgoingOnSuccess)) {
                // FIXME: "The contents of an <errorhandler> are exactly the same as for a command,"
                // FIXME: "except it cannot contain any errorhandler itself."
                b.commands.each { e ->
                    with Shortcuts.generateXml(e.builder, e.closure)
                }
            }
        }
    }

}
