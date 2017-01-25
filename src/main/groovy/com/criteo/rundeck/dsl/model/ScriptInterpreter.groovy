package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class ScriptInterpreter {

    def checker() { return null }

    @YamlProperty(name='interpreterArgsQuoted')
    Boolean argsQuoted

    @YamlProperty(name='scriptinterpreter')
    String command
}
