package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.Actions

/**
 * Builder of 'limitAction' sections
 */
class LoglimitBuilder {


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
