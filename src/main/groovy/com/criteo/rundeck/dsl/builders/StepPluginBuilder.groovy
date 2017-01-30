package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'step-plugin' sections
 */
class StepPluginBuilder extends CommandBuilder {

    @YamlProperty
    BuildingClosure configuration = new BuildingClosure(ConfigurationBuilder)

    @YamlProperty
    String type

    def configuration(@DelegatesTo(ConfigurationBuilder) Closure value, boolean overwrite = false) {
        this.configuration.absorb(value, overwrite)
    }

    def type(String value) {
        this.type = value
    }

}
