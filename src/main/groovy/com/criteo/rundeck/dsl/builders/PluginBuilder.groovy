package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.Plugin

/**
 * Builder of 'plugin' sections
 */
class PluginBuilder {

    def build() {
        Plugin p = new Plugin()

        p.configuration = this.configuration?.value ? this.configuration.realize().build() : null
        p.type = this.type

        return p
    }

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
