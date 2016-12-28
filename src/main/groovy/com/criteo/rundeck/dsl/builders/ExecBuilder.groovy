package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'exec' sections
 */
class ExecBuilder extends CommandBuilder {

    String command

    def command(String value) {
        this.command = value
    }

    static def generateXml(ExecBuilder b) {
        return generateXml(b) {
            exec(b.command)
        }
    }

}