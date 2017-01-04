package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'scriptUrl' sections
 */
class ScriptUrlBuilder extends ScriptInvocationBuilder {

    @YamlProperty(name='scripturl')
    String url

    def url(String value) {
        this.url = value
    }

    static def generateXml(ScriptUrlBuilder b) {
        return generateXml(b) {
            if (b.url != null) {
                scripturl(b.url)
            }
        }
    }
}
