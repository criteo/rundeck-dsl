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

}
