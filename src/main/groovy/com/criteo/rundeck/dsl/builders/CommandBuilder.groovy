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

}
