package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.Configuration

/**
 * Builder of 'configuration' sections
 */
class ConfigurationBuilder {

    def build() {
        Configuration c = new Configuration()

        c.entries = this.entries

        return c
    }

    @YamlProperty(merge=true)
    def entries = [:]

    def entry(String key, String value) {
        this.entries.put(key, value)
    }

}
