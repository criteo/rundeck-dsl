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

    static def generateXml(ErrorHandlerBuilder b) {
        return {
            def attributes = [:]
            if (b.keepgoingOnSuccess != null) {
                attributes.put('keepgoingOnSuccess', Boolean.toString(b.keepgoingOnSuccess))
            }
            errorhandler(attributes) {
                // FIXME: "The contents of an <errorhandler> are exactly the same as for a command,"
                // FIXME: "except it cannot contain any errorhandler itself."
                if (b.command) {
                    with Shortcuts.generateXml(b.command)
                }
            }
        }
    }

}
