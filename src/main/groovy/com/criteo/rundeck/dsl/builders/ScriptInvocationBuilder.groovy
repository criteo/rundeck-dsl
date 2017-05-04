package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
import com.criteo.rundeck.dsl.model.ScriptInvocation

/**
 * Builder of 'script' sections
 */
class ScriptInvocationBuilder extends CommandBuilder {

    def build() {
        ScriptInvocation s = new ScriptInvocation()

        s.args = this.args
        s.interpreter = this.interpreter?.value ? this.interpreter.realize().build() : null
        s.description = this.description
        s.errorhandler = this.errorhandler?.value ? this.errorhandler.realize().build() : null

        return s
    }

    String args

    BuildingClosure interpreter = new BuildingClosure(ScriptInterpreterBuilder)

    @MethodDoc('Sets the arguments to pass to the script.')
    def args(String value) {
        this.args = value
    }

    @MethodDoc('Configures an interpreter to use to execute the script.')
    def interpreter(String interpreterCommand, @DelegatesTo(ScriptInterpreterBuilder) Closure value = {}, boolean overwrite = false) {
        value = { command(interpreterCommand) } << value
        this.interpreter.absorb(value, overwrite)
    }

}
