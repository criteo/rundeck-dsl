package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'nodefilters' sections
 */
class NodefiltersBuilder {

    BuildingClosure dispatchClosure = new BuildingClosure(DispatchBuilder)

    String filter

    def dispatch(@DelegatesTo(DispatchBuilder) Closure value, boolean overwrite = false) {
        this.dispatchClosure.absorb(value, overwrite)
    }

    def filter(String value) {
        this.filter = value
    }

    static def generateXml(NodefiltersBuilder b) {
        return {
            nodefilters {
                if (b.dispatchClosure.value) {
                    with Shortcuts.generateXml(b.dispatchClosure)
                }
                if (b.filter != null) {
                    filter(b.filter)
                }
            }
        }
    }
}
