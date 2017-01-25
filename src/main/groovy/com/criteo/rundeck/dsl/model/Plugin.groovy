package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class Plugin {

    def checker() { return null }

    @YamlProperty
    Configuration configuration

    @YamlProperty
    String type
}
