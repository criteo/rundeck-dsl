package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
import com.criteo.rundeck.dsl.model.MaxPercentageOrchestrator

/**
 * Builder of 'maxPercentageOrchestrator' sections
 */
class MaxPercentageOrchestratorBuilder extends OrchestratorBuilder {

    def build() {
        MaxPercentageOrchestrator o = new MaxPercentageOrchestrator()

        o.configuration = this.configuration?.value ? this.configuration.realize().build() : null
        o.type = this.type

        return o
    }

    MaxPercentageOrchestratorBuilder() {
        super('maxPercentage')
    }

    @MethodDoc('Sets the maximum percentage of nodes to process.')
    def percent(Integer value) {
        this.configuration.absorb({
            entry('percent', value.toString())
        }, true)
    }

}
