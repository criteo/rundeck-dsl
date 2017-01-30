package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.NodeStepPlugin

/**
 * Builder of 'node-step-plugin' sections
 */
class NodeStepPluginBuilder extends CommandBuilder {

    def build() {
        NodeStepPlugin n = new NodeStepPlugin()

        n.description = this.description
        n.errorhandler = this.errorhandler?.value ? this.errorhandler.realize().build() : null
        n.configuration = this.configuration?.value ? this.configuration.realize().build() : null
        n.type = this.type
        n.nodeStep = this.nodeStep

        return n
    }

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
