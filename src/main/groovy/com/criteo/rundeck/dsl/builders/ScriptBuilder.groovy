package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.Script

/**
 * Builder of 'script' sections
 */
class ScriptBuilder extends ScriptInvocationBuilder {

    def build() {
        Script s = new Script()

        s.args = this.args
        s.interpreter = this.interpreter?.value ? this.interpreter.realize().build() : null
        s.body = this.body
        s.description = this.description
        s .errorhandler = this.errorhandler?.value ? this.errorhandler.realize().build() : null


        return s
    }

    @YamlProperty(name='script')
    String body

    def body(String value) {
        this.body = value
    }

}
