package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'node-step-plugin' sections
 */
class NodeStepPluginBuilder extends CommandBuilder {

    Closure configurationClosure

    String type

    NodeStepPluginBuilder() {
    }

    NodeStepPluginBuilder(String type, String description, Closure errorhandlerClosure, entries) {
        this.type = type
        this.description = description
        this.errorhandlerClosure = errorhandlerClosure
        this.configurationClosure = {
            entries.each { k, v ->
                entry(k, v)
            }
        }
    }

    def configuration(@DelegatesTo(ConfigurationBuilder) Closure value, boolean overwrite = false) {
        this.configurationClosure = overwrite ? value : (this.configurationClosure ?: {}) << value
    }

    def type(String value) {
        this.type = value
    }

    static def generateXml(NodeStepPluginBuilder b) {
        return generateXml(b) {
            def attributes = [:]
            if (b.type != null) {
                attributes.put('type', b.type)
            }
            delegate.'node-step-plugin'(attributes) {
                if (b.configurationClosure) {
                    with Shortcuts.generateXml(ConfigurationBuilder, b.configurationClosure)
                }
            }
        }
    }

    //
    // Specializations

    static class LocalExecBuilder extends NodeStepPluginBuilder {

        String command

        LocalExecBuilder() {
            this.type = 'localexec'
        }

        def command(String value) {
            this.configurationClosure = {
                entry('command', value)
            }
        }

    }
}
