package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'script' sections
 */
class ScriptBuilder extends CommandBuilder {

    String args

    String interpreter

    String body

    def args(String value) {
        this.args = value
    }

    def interpreter(String value) {
        this.interpreter = value
    }

    def body(String value) {
        this.body = value
    }

    static def generateXml(ScriptBuilder b) {
        return generateXml(b) {
            if (b.body != null) {
                script {
                    mkp.yieldUnescaped("<![CDATA[${b.body}]]>")
                }
            }
            if (b.args != null) {
                scriptargs(b.args)
            }
            if (b.interpreter != null) {
                scriptinterpreter(b.interpreter)
            }
        }
    }
}
