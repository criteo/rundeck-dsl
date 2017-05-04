package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
import com.criteo.rundeck.dsl.model.Notification

/**
 * Builder of 'notification' sections
 */
class NotificationBuilder {

    def build() {
        Notification n = new Notification()

        n.onfailure = this.onfailure?.value ? this.onfailure.realize().build() : null
        n.onstart = this.onstart?.value ? this.onstart.realize().build() : null
        n.onsuccess = this.onsuccess?.value ? this.onsuccess.realize().build() : null

        return n
    }

    BuildingClosure onfailure = new BuildingClosure(NotificationDefinitionBuilder)

    BuildingClosure onstart = new BuildingClosure(NotificationDefinitionBuilder)

    BuildingClosure onsuccess = new BuildingClosure(NotificationDefinitionBuilder)

    @MethodDoc('Configures a notifier to be triggered in case of failure.')
    def onfailure(@DelegatesTo(NotificationDefinitionBuilder) Closure value, boolean overwrite = false) {
        this.onfailure.absorb(value, overwrite)
    }

    @MethodDoc('Configures a notifier to be triggered when the workflow starts.')
    def onstart(@DelegatesTo(NotificationDefinitionBuilder) Closure value, boolean overwrite = false) {
        this.onstart.absorb(value, overwrite)
    }

    @MethodDoc('Configures a notifier to be triggered in case of success.')
    def onsuccess(@DelegatesTo(NotificationDefinitionBuilder) Closure value, boolean overwrite = false) {
        this.onsuccess.absorb(value, overwrite)
    }

}
