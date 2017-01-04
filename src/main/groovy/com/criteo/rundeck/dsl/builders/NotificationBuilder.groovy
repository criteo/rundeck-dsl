package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'notification' sections
 */
class NotificationBuilder {

    BuildingClosure onfailureClosure = new BuildingClosure(NotificationDefinitionBuilder)

    BuildingClosure onstartClosure = new BuildingClosure(NotificationDefinitionBuilder)

    BuildingClosure onsuccessClosure = new BuildingClosure(NotificationDefinitionBuilder)

    def onfailure(@DelegatesTo(NotificationDefinitionBuilder) Closure value, boolean overwrite = false) {
        this.onfailureClosure.absorb(value, overwrite)
    }

    def onstart(@DelegatesTo(NotificationDefinitionBuilder) Closure value, boolean overwrite = false) {
        this.onstartClosure.absorb(value, overwrite)
    }

    def onsuccess(@DelegatesTo(NotificationDefinitionBuilder) Closure value, boolean overwrite = false) {
        this.onsuccessClosure.absorb(value, overwrite)
    }

    static def generateXml(NotificationBuilder b) {
        return {
            notification {
                if (b.onfailureClosure.value) {
                    onfailure {
                        with Shortcuts.generateXml(b.onfailureClosure)
                    }
                }
                if (b.onsuccessClosure.value) {
                    onsuccess {
                        with Shortcuts.generateXml(b.onsuccessClosure)
                    }
                }
                if (b.onstartClosure.value) {
                    onstart {
                        with Shortcuts.generateXml(b.onstartClosure)
                    }
                }
            }
        }
    }
}
