package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc

/**
 * Common elements of concrete commands builders
 */
abstract class CommandBuilder {

    abstract build()

    String description

    BuildingClosure errorhandler = new BuildingClosure(ErrorHandlerBuilder)

    @MethodDoc('''Sets the description of the command for display in Rundeck's UI''')
    def description(String value) {
        this.description = value
    }

    @MethodDoc('Configures the error handler for this command.')
    def errorhandler(@DelegatesTo(ErrorHandlerBuilder) Closure value, boolean overwrite = false) {
        this.errorhandler.absorb(value, overwrite)
    }

}
