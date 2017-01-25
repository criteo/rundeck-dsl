package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class Nodefilters {

    def checker() { return null }

    @YamlProperty
    Dispatch dispatch

    @YamlProperty
    String filter
}
