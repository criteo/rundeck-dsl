package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'options' sections
 */
class OptionsBuilder {

    def optionClosures = []

    boolean preserveOrder

    def option(String optionName, @DelegatesTo(OptionBuilder) Closure value = {}) {
        this.optionClosures.add({
            name(optionName)
            with value
        })
    }

    def preserveOrder(boolean value = true) {
        this.preserveOrder = value
    }

    static def generateXml(OptionsBuilder b) {
        return {
            options(preserveOrder: Boolean.toString(b.preserveOrder)) {
                b.optionClosures.each { optionClosure ->
                    with Shortcuts.generateXml(OptionBuilder, optionClosure)
                }
            }
        }
    }
}
