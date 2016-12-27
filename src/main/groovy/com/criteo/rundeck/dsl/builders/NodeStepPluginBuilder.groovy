package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'node-step-plugin' sections
 */
class NodeStepPluginBuilder extends CommandBuilder {

    Closure configurationClosure

    String type

    def configuration(@DelegatesTo(ConfigurationBuilder) Closure value, boolean overwrite = false) {
        this.configurationClosure = overwrite ? value : (this.configurationClosure ?: {}) << value
    }

    def type(String value) {
        this.type = value
    }

    static def generateXml(NodeStepPluginBuilder b) {
        return generateXml(b) {
            delegate.'node-step-plugin'(type: b.type) {
                if (b.configurationClosure) {
                    with Shortcuts.generateXml(ConfigurationBuilder, b.configurationClosure)
                }
            }
        }
    }

    //
    // Specializations

    static private def generateXmlForSpecialization(String specType,
                                                    String specDescription,
                                                    Closure specErrorHandlerClosure,
                                                    entries) {
        return Shortcuts.generateXml(NodeStepPluginBuilder, {
            if (specDescription) {
                description(specDescription)
            }
            if (specErrorHandlerClosure) {
                errorhandler(specErrorHandlerClosure)
            }
            type(specType)
            configuration {
                entries.each { k, v ->
                    entry(k, v)
                }
            }
        })
    }

    static class LocalExecBuilder extends CommandBuilder {

        String command

        def command(String value) {
            this.command = value
        }

        static def generateXml(LocalExecBuilder b) {
            NodeStepPluginBuilder.generateXmlForSpecialization('localexec', b.description, b.errorhandlerClosure, [
                'command': b.command
            ])
        }
    }
}
