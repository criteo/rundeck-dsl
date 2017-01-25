package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class Time {

    def checker() { return null }

    @YamlProperty
    String hour

    @YamlProperty
    String minute

    @YamlProperty
    String seconds
}
