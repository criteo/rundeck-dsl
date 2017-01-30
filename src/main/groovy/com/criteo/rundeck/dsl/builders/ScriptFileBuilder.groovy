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

}
