package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'email' sections
 */
class EmailBuilder {

    @YamlProperty
    Boolean attachLog

    @YamlProperty
    String recipients

    @YamlProperty
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
