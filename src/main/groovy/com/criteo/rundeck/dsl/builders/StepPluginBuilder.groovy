package com.criteo.rundeck.dsl.builders

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

    def configuration(@DelegatesTo(ConfigurationBuilder) Closure value, boolean overwrite = false) {
        this.configuration.absorb(value, overwrite)
    }

    def type(String value) {
        this.type = value
    }

}
