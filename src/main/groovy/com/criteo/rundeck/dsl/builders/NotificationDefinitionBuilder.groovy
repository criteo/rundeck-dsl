package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'notification-definition' sections
 */
class NotificationDefinitionBuilder {

    @YamlProperty
    BuildingClosure email = new BuildingClosure(EmailBuilder)

    @YamlProperty
    BuildingClosure plugin = new BuildingClosure(PluginBuilder)

    @YamlProperty
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

}
