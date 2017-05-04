package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
import com.criteo.rundeck.dsl.model.SubsetOrchestrator

/**
 * Builder of 'subsetOrchestrator' sections
 */
class SubsetOrchestratorBuilder extends OrchestratorBuilder {

    def build() {
        SubsetOrchestrator o = new SubsetOrchestrator()

        o.configuration = this.configuration?.value ? this.configuration.realize().build() : null
        o.type = this.type

        return o
    }

    SubsetOrchestratorBuilder() {
        super('subset')
    }

    @MethodDoc('Sets the maximum number of nodes to process.')
    def count(Integer value) {
        this.configuration.absorb({
            entry('count', value.toString())
        }, true)
    }

}
