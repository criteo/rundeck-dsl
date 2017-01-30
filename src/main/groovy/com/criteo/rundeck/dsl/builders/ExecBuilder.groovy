package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'exec' sections
 */
class ExecBuilder extends CommandBuilder {

    @YamlProperty(name='exec')
    String command

    def command(String value) {
        this.command = value
    }

}
