package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

import com.criteo.rundeck.dsl.model.Actions

class Loglimit {

    def checker() { return null }

    @YamlProperty(name='loglimitAction')
    Actions action

    @YamlProperty(name='loglimit')
    String limit

    @YamlProperty(name='loglimitStatus')
    String statusOnHalt
}
