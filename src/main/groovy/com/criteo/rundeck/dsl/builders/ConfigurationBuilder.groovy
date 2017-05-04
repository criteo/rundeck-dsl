package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
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

    def entries = [:]

    @MethodDoc('Adds a new key/value pair to this configuration')
    def entry(String key, String value) {
        this.entries.put(key, value)
    }

}
