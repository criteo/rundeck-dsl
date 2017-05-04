package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
import com.criteo.rundeck.dsl.model.StepPlugin

/**
 * Builder of 'step-plugin' sections
 */
class StepPluginBuilder extends CommandBuilder {

    def build() {
        StepPlugin s = new StepPlugin()

        s.configuration = this.configuration?.value ? this.configuration.realize().build() : null
        s.type = this.type

        return s
    }

    BuildingClosure configuration = new BuildingClosure(ConfigurationBuilder)

    String type

    @MethodDoc('Sets the parameters for this plugin.')
    def configuration(@DelegatesTo(ConfigurationBuilder) Closure value, boolean overwrite = false) {
        this.configuration.absorb(value, overwrite)
    }

    @MethodDoc('Sets the type of the plugin.')
    def type(String value) {
        this.type = value
    }

}
