package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class Configuration {

    def checker() { return null }

    @YamlProperty(merge=true)
    def entries = [:]

    def entry(String key, String value) {
        this.entries.put(key, value)
    }
}
