package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
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

    BuildingClosure dispatch = new BuildingClosure(DispatchBuilder)

    String filter

    @MethodDoc('Configures the dispatching to filtered nodes.')
    def dispatch(@DelegatesTo(DispatchBuilder) Closure value, boolean overwrite = false) {
        this.dispatch.absorb(value, overwrite)
    }

    @MethodDoc('Sets the node filter string. See the node filter syntax at http://rundeck.org/docs/manual/node-filters.html.')
    def filter(String value) {
        this.filter = value
    }

}
