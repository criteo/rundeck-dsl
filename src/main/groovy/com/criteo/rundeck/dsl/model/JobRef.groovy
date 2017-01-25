package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class JobRef extends Command {

    def checker() { return null }

    @YamlProperty
    def jobref = [ args: null,
                   group: null,
                   name: null,
                   nodeStep: null,
                   nodefilters: null ]
}
