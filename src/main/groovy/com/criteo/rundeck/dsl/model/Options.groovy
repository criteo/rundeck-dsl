package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class Options {

    def checker() { return null }

    @YamlProperty
    def options = []

    Boolean preserveOrder
}
