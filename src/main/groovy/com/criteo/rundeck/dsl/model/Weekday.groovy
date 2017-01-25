package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class Weekday {

    def checker() { return null }

    @YamlProperty
    String day
}
