package com.criteo.rundeck.dsl.builders

/**
 * Common elements of concrete commands builders
 */
abstract class CommandBuilder {

    String description

    BuildingClosure errorhandlerClosure = new BuildingClosure(ErrorHandlerBuilder)

    def description(String value) {
        this.description = value
    }

    def errorhandler(@DelegatesTo(ErrorHandlerBuilder) Closure value, boolean overwrite = false) {
        this.errorhandlerClosure.absorb(value, overwrite)
    }

    static def generateXml(CommandBuilder b, Closure more) {
        return {
            if (b.description != null) {
                description(b.description)
            }
            if (b.errorhandlerClosure.value) {
                with Shortcuts.generateXml(b.errorhandlerClosure)
            }
            with more
        }
    }
}
