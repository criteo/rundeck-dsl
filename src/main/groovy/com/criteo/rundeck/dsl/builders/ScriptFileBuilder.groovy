package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'scriptFile' sections
 */
class ScriptFileBuilder extends ScriptInvocationBuilder {

    @YamlProperty(name='scriptfile')
    String path

    def path(String value) {
        this.path = value
    }

    static def generateXml(ScriptFileBuilder b) {
        return generateXml(b) {
            if (b.path != null) {
                scriptfile(b.path)
            }
        }
    }
}
