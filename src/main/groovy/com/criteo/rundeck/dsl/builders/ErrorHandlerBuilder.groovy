package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'error-handler' sections
 */
class ErrorHandlerBuilder extends CommandsBuilder {

    Boolean keepgoingOnSuccess

    def keepgoingOnSuccess(Boolean value = true) {
        this.keepgoingOnSuccess = value
    }

    static def generateXml(ErrorHandlerBuilder b) {
        return {
            def attributes = [:]
            if (b.keepgoingOnSuccess != null) {
                attributes.put('keepgoingOnSuccess', Boolean.toString(b.keepgoingOnSuccess))
            }
            errorhandler(attributes) {
                // FIXME: "The contents of an <errorhandler> are exactly the same as for a command,"
                // FIXME: "except it cannot contain any errorhandler itself."
                b.commands.each { e ->
                    with Shortcuts.generateXml(e.builder, e.closure)
                }
            }
        }
    }

}
