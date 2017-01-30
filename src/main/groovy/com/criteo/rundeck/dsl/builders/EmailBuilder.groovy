package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.Email

/**
 * Builder of 'email' sections
 */
class EmailBuilder {

    def build() {
        Email e = new Email()

        e.attachLog = this.attachLog
        e.recipients = this.recipients
        e.subject = this.subject

        return e
    }

    Boolean attachLog

    String recipients

    String subject

    def attachLog(Boolean value = true) {
        this.attachLog = value
    }

    def recipients(String value) {
        this.recipients = value
    }

    def subject(String value) {
        this.subject = value
    }
}
