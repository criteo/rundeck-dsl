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
            if (b.interpreter != null) {
                scriptinterpreter(b.interpreter)
            }
            if (b.body != null) {
                script {
                    mkp.yieldUnescaped("<![CDATA[${b.body}]]>")
                }
            }
        }
    }
}
