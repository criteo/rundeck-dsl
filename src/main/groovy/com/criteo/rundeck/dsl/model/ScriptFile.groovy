package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class ScriptFile extends ScriptInvocation {

    def checker() { return null }

    @YamlProperty(name='scriptfile')
    String path
}
