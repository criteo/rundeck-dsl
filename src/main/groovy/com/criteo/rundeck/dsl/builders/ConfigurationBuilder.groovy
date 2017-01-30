package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'configuration' sections
 */
class ConfigurationBuilder {

    @YamlProperty(merge=true)
    def entries = [:]

    def entry(String key, String value) {
        this.entries.put(key, value)
    }

}
