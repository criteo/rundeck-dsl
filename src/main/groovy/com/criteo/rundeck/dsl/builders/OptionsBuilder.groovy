package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.Options

/**
 * Builder of 'options' sections
 */
class OptionsBuilder {

    def build() {
        Options o = new Options()

        o.options = this.options.collect() { it.realize().build() }
        o.preserveOrder = this.preserveOrder

        return o
    }

    @YamlProperty
    def options = []

    Boolean preserveOrder

    def option(String optionName, @DelegatesTo(OptionBuilder) Closure value = {}) {
        this.options.add(new BuildingClosure(OptionBuilder, {
            name(optionName)
            with value
        }))
    }

    def preserveOrder(Boolean value = true) {
        this.preserveOrder = value
    }

}
