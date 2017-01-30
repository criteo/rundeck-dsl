package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.Actions
import com.criteo.rundeck.dsl.model.Loglimit

/**
 * Builder of 'limitAction' sections
 */
class LoglimitBuilder {

    def build() {
        Loglimit l = new Loglimit()

        l.action = this.action
        l.limit = this.limit
        l.statusOnHalt = this.statusOnHalt

        return l
    }

    Actions action

    String limit

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
