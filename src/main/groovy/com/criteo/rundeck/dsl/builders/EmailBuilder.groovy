package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'email' sections
 */
class EmailBuilder {

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

    static def generateXml(EmailBuilder b) {
        return {
            def attributes = [:]
            if (b.attachLog != null) {
                attributes.put('attachLog', Boolean.toString(b.attachLog))
            }
            if (b.recipients != null) {
                attributes.put('recipients', b.recipients)
            }
            if (b.subject != null) {
                attributes.put('subject', b.subject)
            }
            email(attributes)
        }
    }
}
