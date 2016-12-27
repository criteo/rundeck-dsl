package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'notification-definition' sections
 */
class NotificationDefinitionBuilder {

    Closure emailClosure

    Closure pluginClosure

    def webhook = []

    def email(@DelegatesTo(EmailBuilder) Closure value, boolean overwrite = false) {
        this.emailClosure = overwrite ? value : (this.emailClosure ?: {}) << value
    }

    def plugin(@DelegatesTo(PluginBuilder) Closure value, boolean overwrite = false) {
        this.pluginClosure = overwrite ? value : (this.pluginClosure ?: {}) << value
    }

    def webhook(URL... values) {
        this.webhook.addAll(values)
    }

    static def generateXml(NotificationDefinitionBuilder b) {
        return {
            if (b.emailClosure) {
                with Shortcuts.generateXml(EmailBuilder, b.emailClosure)
            }
            if (b.pluginClosure) {
                with Shortcuts.generateXml(PluginBuilder, b.pluginClosure)
            }
            if (b.webhook) {
                webhook(urls: b.webhook.join(','))
            }
        }
    }
}
