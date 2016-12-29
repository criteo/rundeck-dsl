package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'limitAction' sections
 */
class LoglimitBuilder {

    enum Actions {
        HALT,
        TRUNCATE
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

    static def generateXml(LoglimitBuilder b) {
        return {
            if (b.limit != null) {
                loglimit(b.limit)
            }
            if (b.action != null) {
                loglimitAction(b.action.toString().toLowerCase())
            }
            if (b.statusOnHalt != null) {
                loglimitStatus(b.statusOnHalt)
            }
        }
    }
}
