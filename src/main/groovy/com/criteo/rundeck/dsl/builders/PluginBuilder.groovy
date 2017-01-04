package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'plugin' sections
 */
class PluginBuilder {

    @YamlProperty
    BuildingClosure configuration = new BuildingClosure(ConfigurationBuilder)

    @YamlProperty
    String type

    def configuration(@DelegatesTo(ConfigurationBuilder) Closure value, overwrite = false) {
        this.configuration.absorb(value, overwrite)
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
                if (b.configuration.value) {
                    with Shortcuts.generateXml(b.configuration)
                }
            }
        }
    }

}
