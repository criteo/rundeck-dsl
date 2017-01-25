package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class Loglimit {

    def checker() { return null }

    enum Actions {
        HALT,
        TRUNCATE

        String toString() {
            this.name().toLowerCase()
        }
    }

    @YamlProperty(name='loglimitAction')
    Actions action

    @YamlProperty(name='loglimit')
    String limit

    @YamlProperty(name='loglimitStatus')
    String statusOnHalt
}
