package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'interpreter' sections
 */
class ScriptInterpreterBuilder {

    @YamlProperty(name='interpreterArgsQuoted')
    Boolean argsQuoted

    @YamlProperty(name='scriptinterpreter')
    String command

    def argsQuoted(Boolean value = true) {
        this.argsQuoted = value
    }

    def command(String value) {
        this.command = value
    }

    static def generateXml(ScriptInterpreterBuilder b) {
        return {
            def attributes = [:]
            if (b.argsQuoted) {
                attributes.put('argsquoted', b.argsQuoted)
            }
            scriptinterpreter(attributes, b.command)
        }
    }

}
