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

}
