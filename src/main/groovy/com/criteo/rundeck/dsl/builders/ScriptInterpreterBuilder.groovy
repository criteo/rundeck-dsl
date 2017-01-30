package com.criteo.rundeck.dsl.builders

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

    def argsQuoted(Boolean value = true) {
        this.argsQuoted = value
    }

    def command(String value) {
        this.command = value
    }

}
