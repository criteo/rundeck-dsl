package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'script' sections
 */
class ScriptInvocationBuilder extends CommandBuilder {

    String args

    String interpreter

    def args(String value) {
        this.args = value
    }

    def interpreter(String value) {
        this.interpreter = value
    }

    static def generateXml(ScriptInvocationBuilder b, Closure more) {
        return CommandBuilder.generateXml(b) {
            with more
            if (b.args != null) {
                scriptargs(b.args)
            }
            if (b.interpreter != null) {
                scriptinterpreter(b.interpreter)
            }
        }
    }
}
