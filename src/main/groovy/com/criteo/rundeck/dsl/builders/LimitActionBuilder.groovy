package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.enums.LimitActionValue

/**
 * Builder of 'limitAction' sections
 */
class LimitActionBuilder {

    String statusOnHalt

    LimitActionValue value

    def halt(String status = null) {
        this.value = LimitActionValue.HALT
        this.statusOnHalt = status
    }

    def truncate() {
        this.value = LimitActionValue.TRUNCATE
    }

}
