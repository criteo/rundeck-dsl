package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'plugin' sections
 */
class PluginBuilder {

    Closure configurationClosure

    String type

    def configuration(@DelegatesTo(ConfigurationBuilder) Closure value, overwrite = false) {
        this.configurationClosure = overwrite ? value : (this.configurationClosure ?: {}) << value
    }

    def type(String value) {
        this.type = value
    }

    static def generateXml(PluginBuilder b) {
        return {
            def attributes = [:]
            if (b.type != null) {
                attributes.put('type', b.type)
            }
            plugin(attributes) {
                if (b.configurationClosure) {
                    with Shortcuts.generateXml(ConfigurationBuilder, b.configurationClosure)
                }
            }
        }
    }

}
