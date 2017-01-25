package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class ScriptInvocation extends Command {

    def checker() { return null }

    @YamlProperty(name='scriptargs')
    String args

    @YamlProperty(name='scriptinterpreter', merge=true)
    ScriptInterpreter interpreter
}
