package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
import com.criteo.rundeck.dsl.model.ScriptInterpreter

/**
 * Builder of 'interpreter' sections
 */
class ScriptInterpreterBuilder {

    def build() {
        ScriptInterpreter s = new ScriptInterpreter()

        s.argsQuoted = this.argsQuoted
        s.command = this.command

        return s
    }

    Boolean argsQuoted

    String command

    @MethodDoc('Sets whether the script and arguments should be quoted when passed to the interpreter.')
    def argsQuoted(Boolean value) {
        this.argsQuoted = value
    }

    def argsQuoted() {
        this.argsQuoted(true)
    }

    @MethodDoc('Sets an interpreter line for the script (the script and args will be passed to it).')
    def command(String value) {
        this.command = value
    }

}
