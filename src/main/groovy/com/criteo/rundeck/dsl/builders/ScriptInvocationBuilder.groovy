package com.criteo.rundeck.dsl.builders

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

    @YamlProperty(name='scriptargs')
    String args

    @YamlProperty(name='scriptinterpreter', merge=true)
    BuildingClosure interpreter = new BuildingClosure(ScriptInterpreterBuilder)

    def args(String value) {
        this.args = value
    }

    def interpreter(String interpreterCommand, @DelegatesTo(ScriptInterpreterBuilder) Closure value = {}, boolean overwrite = false) {
        value = { command(interpreterCommand) } << value
        this.interpreter.absorb(value, overwrite)
    }

}
