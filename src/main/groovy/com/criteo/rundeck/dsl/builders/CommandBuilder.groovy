package com.criteo.rundeck.dsl.builders

/**
 * Common elements of concrete commands builders
 */
abstract class CommandBuilder {

    String description

    Closure errorhandlerClosure

    def description(String value) {
        this.description = value
    }

    def errorhandler(@DelegatesTo(ErrorHandlerBuilder) Closure value, boolean overwrite = false) {
        this.errorhandlerClosure = overwrite ? value : (this.errorhandlerClosure ?: {}) << value
    }

    static def generateXml(CommandBuilder b, Closure more) {
        return {
            if (b.description != null) {
                description(b.description)
            }
            if (b.errorhandlerClosure) {
                with Shortcuts.generateXml(ErrorHandlerBuilder, b.errorhandlerClosure)
            }
            with more
        }
    }
}
