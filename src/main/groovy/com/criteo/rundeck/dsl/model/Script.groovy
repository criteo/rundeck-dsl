package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class Script extends ScriptInvocation {

    def checker() { return null }

    @YamlProperty(name='script')
    String body

    @YamlProperty
    String fileExtension
}
