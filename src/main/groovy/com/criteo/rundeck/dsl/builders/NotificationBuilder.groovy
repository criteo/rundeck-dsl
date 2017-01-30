package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'notification' sections
 */
class NotificationBuilder {

    @YamlProperty
    BuildingClosure onfailure = new BuildingClosure(NotificationDefinitionBuilder)

    @YamlProperty
    BuildingClosure onstart = new BuildingClosure(NotificationDefinitionBuilder)

    @YamlProperty
    BuildingClosure onsuccess = new BuildingClosure(NotificationDefinitionBuilder)

    def onfailure(@DelegatesTo(NotificationDefinitionBuilder) Closure value, boolean overwrite = false) {
        this.onfailure.absorb(value, overwrite)
    }

    def onstart(@DelegatesTo(NotificationDefinitionBuilder) Closure value, boolean overwrite = false) {
        this.onstart.absorb(value, overwrite)
    }

    def onsuccess(@DelegatesTo(NotificationDefinitionBuilder) Closure value, boolean overwrite = false) {
        this.onsuccess.absorb(value, overwrite)
    }

}
