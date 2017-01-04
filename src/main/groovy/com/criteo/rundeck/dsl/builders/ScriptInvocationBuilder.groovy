package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'script' sections
 */
class ScriptInvocationBuilder extends CommandBuilder {

    String args

    BuildingClosure interpreter = new BuildingClosure(ScriptInterpreterBuilder)

    def args(String value) {
        this.args = value
    }

    def interpreter(String interpreterCommand, @DelegatesTo(ScriptInterpreterBuilder) Closure value = {}, boolean overwrite = false) {
        value = { command(interpreterCommand) } << value
        this.interpreter.absorb(value, overwrite)
    }

    static def generateXml(ScriptInvocationBuilder b, Closure more) {
        return CommandBuilder.generateXml(b) {
            with more
            if (b.args != null) {
                scriptargs(b.args)
            }
            if (b.interpreter.value) {
                with Shortcuts.generateXml(b.interpreter)
            }
        }
    }
}
