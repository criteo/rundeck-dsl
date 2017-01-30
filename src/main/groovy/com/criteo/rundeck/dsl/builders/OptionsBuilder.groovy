package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'options' sections
 */
class OptionsBuilder {

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
