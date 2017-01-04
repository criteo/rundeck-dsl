package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'notification-definition' sections
 */
class NotificationDefinitionBuilder {

    BuildingClosure email = new BuildingClosure(EmailBuilder)

    BuildingClosure plugin = new BuildingClosure(PluginBuilder)

    def webhook = []

    def email(@DelegatesTo(EmailBuilder) Closure value, boolean overwrite = false) {
        this.email.absorb(value, overwrite)
    }

    def plugin(@DelegatesTo(PluginBuilder) Closure value, boolean overwrite = false) {
        this.plugin.absorb(value, overwrite)
    }

    def webhook(URL... values) {
        this.webhook.addAll(values)
    }

    static def generateXml(NotificationDefinitionBuilder b) {
        return {
            if (b.email.value) {
                with Shortcuts.generateXml(b.email)
            }
            if (b.plugin.value) {
                with Shortcuts.generateXml(b.plugin)
            }
            if (b.webhook) {
                webhook(urls: b.webhook.join(','))
            }
        }
    }
}
