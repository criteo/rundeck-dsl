package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'subsetOrchestrator' sections
 */
class SubsetOrchestratorBuilder extends OrchestratorBuilder {

    SubsetOrchestratorBuilder() {
        super('subset')
    }

    def count(Integer value) {
        this.configurationClosure = {
            entry('count', value.toString())
        }
    }

}
