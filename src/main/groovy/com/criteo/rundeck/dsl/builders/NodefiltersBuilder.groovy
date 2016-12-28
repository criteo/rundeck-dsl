package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'nodefilters' sections
 */
class NodefiltersBuilder {

    Closure dispatchClosure

    String filter

    def dispatch(@DelegatesTo(DispatchBuilder) Closure value, boolean overwrite = false) {
        this.dispatchClosure = overwrite ? value : (this.dispatchClosure ?: {}) << value
    }

    def filter(String value) {
        this.filter = value
    }

    static def generateXml(NodefiltersBuilder b) {
        return {
            nodefilters {
                if (b.dispatchClosure) {
                    with Shortcuts.generateXml(DispatchBuilder, b.dispatchClosure)
                }
                if (b.filter != null) {
                    filter(b.filter)
                }
            }
        }
    }
}
