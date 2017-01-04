package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'node-step-plugin' sections
 */
class NodeStepPluginBuilder extends CommandBuilder {

    BuildingClosure configurationClosure = new BuildingClosure(ConfigurationBuilder)

    String type

    NodeStepPluginBuilder() {
    }

    NodeStepPluginBuilder(String type, String description, Closure errorhandlerClosure, entries) {
        this.type = type
        this.description = description
        this.errorhandlerClosure.absorb(errorhandlerClosure, true)
        this.configurationClosure.absorb({
            entries.each { k, v ->
                entry(k, v)
            }
        }, true)
    }

    def configuration(@DelegatesTo(ConfigurationBuilder) Closure value, boolean overwrite = false) {
        this.configurationClosure.absorb(value, overwrite)
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
                if (b.configurationClosure.value) {
                    with Shortcuts.generateXml(b.configurationClosure)
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
            this.configurationClosure.absorb({
                entry('command', value)
            }, true)
        }

    }
}
