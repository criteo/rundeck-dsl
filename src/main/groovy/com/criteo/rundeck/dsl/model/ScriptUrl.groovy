package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class ScriptUrl extends ScriptInvocation {

    def checker() { return null }

    @YamlProperty(name='scripturl')
    String url
}
