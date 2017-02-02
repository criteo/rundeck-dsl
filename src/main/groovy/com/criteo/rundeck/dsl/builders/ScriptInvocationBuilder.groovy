package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'script' sections
 */
class ScriptInvocationBuilder extends CommandBuilder {

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
