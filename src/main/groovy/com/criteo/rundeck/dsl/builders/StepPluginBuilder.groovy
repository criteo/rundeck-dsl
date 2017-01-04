package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'step-plugin' sections
 */
class StepPluginBuilder extends CommandBuilder {

    BuildingClosure configurationClosure = new BuildingClosure(ConfigurationBuilder)

    String type

    def configuration(@DelegatesTo(ConfigurationBuilder) Closure value, boolean overwrite = false) {
        this.configurationClosure.absorb(value, overwrite)
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
                if (b.configurationClosure.value) {
                    with Shortcuts.generateXml(b.configurationClosure)
                }
            }
        }
    }
}
