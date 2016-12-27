package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'context' sections
 */
class ContextBuilder {

    Closure optionsClosure

    def options(@DelegatesTo(OptionsBuilder) Closure value, boolean overwrite = false) {
        this.optionsClosure = overwrite ? value : (this.optionsClosure ?: {}) << value
    }

    static def generateXml(ContextBuilder b) {
        return {
            context {
                if (b.optionsClosure) {
                    with Shortcuts.generateXml(OptionsBuilder, b.optionsClosure)
                }
            }
        }
    }
}
