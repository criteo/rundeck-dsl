package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
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

    @MethodDoc('Sets whether the log shall be attached to this email.')
    def attachLog(Boolean value = true) {
        this.attachLog = value
    }

    @MethodDoc('Sets the comma-separated list of recipients for this email.')
    def recipients(String value) {
        this.recipients = value
    }

    @MethodDoc('Sets the subject of this email.')
    def subject(String value) {
        this.subject = value
    }
}
