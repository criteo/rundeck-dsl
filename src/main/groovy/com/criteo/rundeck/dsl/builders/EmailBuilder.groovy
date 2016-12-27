package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'email' sections
 */
class EmailBuilder {

    boolean attachLog

    String recipients

    String subject

    def attachLog(boolean value = true) {
        this.attachLog = value
    }

    def recipients(String value) {
        this.recipients = value
    }

    def subject(String value) {
        this.subject = value
    }

    static def generateXml(EmailBuilder b) {
        return {
            def attributes = [:]
            if (b.attachLog) {
                attributes.put('attachLog', b.attachLog)
            }
            if (b.recipients) {
                attributes.put('recipients', b.recipients)
            }
            if (b.subject) {
                attributes.put('subject', b.subject)
            }
            email(attributes)
        }
    }
}
