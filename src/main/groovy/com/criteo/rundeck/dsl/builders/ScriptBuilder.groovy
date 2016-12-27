package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'script' sections
 */
class ScriptBuilder extends CommandBuilder {

    String interpreter

    String body

    def interpreter(String value) {
        this.interpreter = value
    }

    def body(String value) {
        this.body = value
    }

    static def generateXml(ScriptBuilder b) {
        return generateXml(b) {
            if (b.interpreter) {
                scriptinterpreter(b.interpreter)
            }
            script {
                mkp.yieldUnescaped("<![CDATA[${b.body}]]>")
            }
        }
    }
}
