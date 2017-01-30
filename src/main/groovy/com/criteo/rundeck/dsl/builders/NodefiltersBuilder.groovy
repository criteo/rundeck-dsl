package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.Nodefilters

/**
 * Builder of 'nodefilters' sections
 */
class NodefiltersBuilder {

    def build() {
        Nodefilters n = new Nodefilters()

        n.dispatch = this.dispatch?.value ? this.dispatch.realize().build() : null
        n.filter = this.filter

        return n
    }

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
