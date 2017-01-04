package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'nodefilters' sections
 */
class NodefiltersBuilder {

    @YamlProperty
    BuildingClosure dispatch = new BuildingClosure(DispatchBuilder)

    @YamlProperty
    String filter

    def dispatch(@DelegatesTo(DispatchBuilder) Closure value, boolean overwrite = false) {
        this.dispatch.absorb(value, overwrite)
    }

    def filter(String value) {
        this.filter = value
    }

    static def generateXml(NodefiltersBuilder b) {
        return {
            nodefilters {
                if (b.dispatch.value) {
                    with Shortcuts.generateXml(b.dispatch)
                }
                if (b.filter != null) {
                    filter(b.filter)
                }
            }
        }
    }
}
