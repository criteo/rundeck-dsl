package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
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

    BuildingClosure configuration = new BuildingClosure(ConfigurationBuilder)

    String type

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

    @MethodDoc('Sets the parameters for this plugin.')
    def configuration(@DelegatesTo(ConfigurationBuilder) Closure value, boolean overwrite) {
        this.configuration.absorb(value, overwrite)
    }

    def configuration(@DelegatesTo(ConfigurationBuilder) Closure value) {
        this.configuration(value, false)
    }

    @MethodDoc('Sets the type of the plugin.')
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
