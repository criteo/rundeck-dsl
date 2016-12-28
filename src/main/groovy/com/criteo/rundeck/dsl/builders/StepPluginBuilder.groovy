package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'step-plugin' sections
 */
class StepPluginBuilder extends CommandBuilder {

    Closure configurationClosure

    String type

    def configuration(@DelegatesTo(ConfigurationBuilder) Closure value, boolean overwrite = false) {
        this.configurationClosure = overwrite ? value : (this.configurationClosure ?: {}) << value
    }

    def type(String value) {
        this.type = value
    }

    static def generateXml(StepPluginBuilder b) {
        return generateXml(b) {
            def attributes = [:]
            if (b.type != null) {
                attributes.put('type', b.type)
            }
            delegate.'step-plugin'(attributes) {
                if (b.configurationClosure) {
                    with Shortcuts.generateXml(ConfigurationBuilder, b.configurationClosure)
                }
            }
        }
    }
}
