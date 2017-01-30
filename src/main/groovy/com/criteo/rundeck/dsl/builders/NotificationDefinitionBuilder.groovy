package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.NotificationDefinition

/**
 * Builder of 'notification-definition' sections
 */
class NotificationDefinitionBuilder {

    def build() {
        NotificationDefinition n = new NotificationDefinition()

        n.email = this.email?.value ? this.email.realize().build() : null
        n.plugin = this.plugin?.value ? this.plugin.realize().build() : null
        n.webhook = this.webhook

        return n
    }

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

}
