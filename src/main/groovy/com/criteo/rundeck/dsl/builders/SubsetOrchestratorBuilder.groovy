package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'subsetOrchestrator' sections
 */
class SubsetOrchestratorBuilder extends OrchestratorBuilder {

    SubsetOrchestratorBuilder() {
        super('subset')
    }

    def count(Integer value) {
        this.configuration.absorb({
            entry('count', value.toString())
        }, true)
    }

}
