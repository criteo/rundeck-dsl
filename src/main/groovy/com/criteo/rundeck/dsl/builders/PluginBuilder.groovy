package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
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

    BuildingClosure configuration = new BuildingClosure(ConfigurationBuilder)

    String type

    @MethodDoc('Sets the parameters for this plugin.')
    def configuration(@DelegatesTo(ConfigurationBuilder) Closure value, boolean overwrite) {
        this.configuration.absorb(value, overwrite)
    }

    def configuration(@DelegatesTo(ConfigurationBuilder) Closure value) {
        this.configuration(value, false)
    }

    @MethodDoc('Sets the type of the plugin.')
    def type(String value) {
        this.type = value
    }

}
