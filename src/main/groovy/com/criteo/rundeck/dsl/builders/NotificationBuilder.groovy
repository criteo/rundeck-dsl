package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'notification' sections
 */
class NotificationBuilder {

    Closure onfailureClosure

    Closure onstartClosure

    Closure onsuccessClosure

    def onfailure(@DelegatesTo(NotificationDefinitionBuilder) Closure value, boolean overwrite = false) {
        this.onfailureClosure = overwrite ? value : (this.onfailureClosure ?: {}) << value
    }

    def onstart(@DelegatesTo(NotificationDefinitionBuilder) Closure value, boolean overwrite = false) {
        this.onstartClosure = overwrite ? value : (this.onstartClosure ?: {}) << value
    }

    def onsuccess(@DelegatesTo(NotificationDefinitionBuilder) Closure value, boolean overwrite = false) {
        this.onsuccessClosure = overwrite ? value : (this.onsuccessClosure ?: {}) << value
    }

    static def generateXml(NotificationBuilder b) {
        return {
            notification {
                if (b.onfailureClosure) {
                    onfailure {
                        with Shortcuts.generateXml(NotificationDefinitionBuilder, b.onfailureClosure)
                    }
                }
                if (b.onsuccessClosure) {
                    onsuccess {
                        with Shortcuts.generateXml(NotificationDefinitionBuilder, b.onsuccessClosure)
                    }
                }
                if (b.onstartClosure) {
                    onstart {
                        with Shortcuts.generateXml(NotificationDefinitionBuilder, b.onstartClosure)
                    }
                }
            }
        }
    }
}
