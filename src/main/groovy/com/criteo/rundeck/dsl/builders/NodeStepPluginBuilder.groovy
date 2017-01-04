package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'node-step-plugin' sections
 */
class NodeStepPluginBuilder extends CommandBuilder {

    @YamlProperty
    BuildingClosure configuration = new BuildingClosure(ConfigurationBuilder)

    @YamlProperty
    String type

    @YamlProperty
    boolean nodeStep = true

    NodeStepPluginBuilder() {
    }

    NodeStepPluginBuilder(String type, String description, Closure errorhandlerClosure, entries) {
        this.type = type
        this.description = description
        this.errorhandler.absorb(errorhandlerClosure, true)
        this.configuration.absorb({
            entries.each { k, v ->
                entry(k, v)
            }
        }, true)
    }

    def configuration(@DelegatesTo(ConfigurationBuilder) Closure value, boolean overwrite = false) {
        this.configuration.absorb(value, overwrite)
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
                if (b.configuration.value) {
                    with Shortcuts.generateXml(b.configuration)
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
            this.configuration.absorb({
                entry('command', value)
            }, true)
        }

    }
}
