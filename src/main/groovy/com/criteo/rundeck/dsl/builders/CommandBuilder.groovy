package com.criteo.rundeck.dsl.builders

/**
 * Common elements of concrete commands builders
 */
abstract class CommandBuilder {

    @YamlProperty
    String description

    @YamlProperty
    BuildingClosure errorhandler = new BuildingClosure(ErrorHandlerBuilder)

    def description(String value) {
        this.description = value
    }

    def errorhandler(@DelegatesTo(ErrorHandlerBuilder) Closure value, boolean overwrite = false) {
        this.errorhandler.absorb(value, overwrite)
    }

    static def generateXml(CommandBuilder b, Closure more) {
        return {
            if (b.description != null) {
                description(b.description)
            }
            if (b.errorhandler.value) {
                with Shortcuts.generateXml(b.errorhandler)
            }
            with more
        }
    }
}
