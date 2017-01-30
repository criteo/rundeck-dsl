package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'limitAction' sections
 */
class LoglimitBuilder {

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

    def limit(String value) {
        this.limit = value
    }

    def halt(String status = null) {
        this.action = Actions.HALT
        this.statusOnHalt = status
    }

    def truncate() {
        this.action = Actions.TRUNCATE
    }

}
