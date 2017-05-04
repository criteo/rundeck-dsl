package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
import com.criteo.rundeck.dsl.model.Exec

/**
 * Builder of 'exec' sections
 */
class ExecBuilder extends CommandBuilder {

    def build() {
        Exec e = new Exec()

        e.description = this.description
        e.errorhandler = this.errorhandler?.value ? this.errorhandler.realize().build() : null
        e.command = this.command

        return e
    }

    String command

    // Sets the command to execute (documented in the caller)
    def command(String value) {
        this.command = value
    }

}
