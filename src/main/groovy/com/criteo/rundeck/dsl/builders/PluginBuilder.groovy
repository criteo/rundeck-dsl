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

}
