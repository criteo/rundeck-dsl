package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'notification' sections
 */
class NotificationBuilder {

    BuildingClosure onfailure = new BuildingClosure(NotificationDefinitionBuilder)

    BuildingClosure onstart = new BuildingClosure(NotificationDefinitionBuilder)

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

    static def generateXml(NotificationBuilder b) {
        return {
            notification {
                if (b.onfailure.value) {
                    onfailure {
                        with Shortcuts.generateXml(b.onfailure)
                    }
                }
                if (b.onsuccess.value) {
                    onsuccess {
                        with Shortcuts.generateXml(b.onsuccess)
                    }
                }
                if (b.onstart.value) {
                    onstart {
                        with Shortcuts.generateXml(b.onstart)
                    }
                }
            }
        }
    }
}
