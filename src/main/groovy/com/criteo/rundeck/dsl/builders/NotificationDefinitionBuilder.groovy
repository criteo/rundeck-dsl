package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'notification-definition' sections
 */
class NotificationDefinitionBuilder {

    BuildingClosure emailClosure = new BuildingClosure(EmailBuilder)

    BuildingClosure pluginClosure = new BuildingClosure(PluginBuilder)

    def webhook = []

    def email(@DelegatesTo(EmailBuilder) Closure value, boolean overwrite = false) {
        this.emailClosure.absorb(value, overwrite)
    }

    def plugin(@DelegatesTo(PluginBuilder) Closure value, boolean overwrite = false) {
        this.pluginClosure.absorb(value, overwrite)
    }

    def webhook(URL... values) {
        this.webhook.addAll(values)
    }

    static def generateXml(NotificationDefinitionBuilder b) {
        return {
            if (b.emailClosure.value) {
                with Shortcuts.generateXml(b.emailClosure)
            }
            if (b.pluginClosure.value) {
                with Shortcuts.generateXml(b.pluginClosure)
            }
            if (b.webhook) {
                webhook(urls: b.webhook.join(','))
            }
        }
    }
}
