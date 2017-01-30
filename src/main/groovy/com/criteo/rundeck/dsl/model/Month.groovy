package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class Month {

    def checker() { return null }

    @YamlProperty
    String month

    @YamlProperty(name="dayofmonth")
    String day
}
