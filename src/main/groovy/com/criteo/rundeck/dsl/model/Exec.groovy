package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class Exec extends Command {

    def checker() { return null }

    @YamlProperty(name='exec')
    String command
}
