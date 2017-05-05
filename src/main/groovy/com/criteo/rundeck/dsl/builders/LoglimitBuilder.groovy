package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
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

    @MethodDoc('Sets the logging limit for this job.')
    def limit(String value) {
        this.limit = value
    }

    @MethodDoc('Makes the job halts with the specified status when the log limit is reached.')
    def halt(String status) {
        this.action = Actions.HALT
        this.statusOnHalt = status
    }

    def halt() {
        this.halt(null)
    }

    @MethodDoc('Stops keeping output.')
    def truncate() {
        this.action = Actions.TRUNCATE
    }

}
