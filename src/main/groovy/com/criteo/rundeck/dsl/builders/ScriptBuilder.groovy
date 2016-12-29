package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'script' sections
 */
class ScriptBuilder extends ScriptInvocationBuilder {

    String body

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
        }
    }
}
