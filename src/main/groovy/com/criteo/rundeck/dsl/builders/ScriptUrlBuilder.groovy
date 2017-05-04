package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
import com.criteo.rundeck.dsl.model.ScriptUrl

/**
 * Builder of 'scriptUrl' sections
 */
class ScriptUrlBuilder extends ScriptInvocationBuilder {

    def build() {
        ScriptUrl s = new ScriptUrl()

        s.args = this.args
        s.interpreter = this.interpreter?.value ? this.interpreter.realize().build() : null
        s.description = this.description
        s.errorhandler = this.errorhandler?.value ? this.errorhandler.realize().build() : null
        s.url = this.url

        return s
    }

    String url

    // Sets the URL where to find the script file (documented in the caller)
    def url(String value) {
        this.url = value
    }

}
