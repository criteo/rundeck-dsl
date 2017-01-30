package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.ScriptFile

/**
 * Builder of 'scriptFile' sections
 */
class ScriptFileBuilder extends ScriptInvocationBuilder {

    def build() {
        ScriptFile s = new ScriptFile()

        s.args = this.args
        s.interpreter = this.interpreter?.value ? this.interpreter.realize().build() : null
        s.description = this.description
        s.errorhandler = this.errorhandler?.value ? this.errorhandler.realize().build() : null
        s.path = this.path

        return s
    }

    @YamlProperty(name='scriptfile')
    String path

    def path(String value) {
        this.path = value
    }

}
