package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
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

    // TODO: shouldn't it be an array?
    @MethodDoc('Configures the email to be sent.')
    def email(@DelegatesTo(EmailBuilder) Closure value, boolean overwrite = false) {
        this.email.absorb(value, overwrite)
    }

    // TODO: shouldn't it be an array?
    @MethodDoc('Configures the plugin to be triggered.')
    def plugin(@DelegatesTo(PluginBuilder) Closure value, boolean overwrite = false) {
        this.plugin.absorb(value, overwrite)
    }

    @MethodDoc('Adds URLs to be contacted. See more at http://rundeck.org/docs/manual/jobs.html#webhooks.')
    def webhook(URL... values) {
        this.webhook.addAll(values)
    }

}
