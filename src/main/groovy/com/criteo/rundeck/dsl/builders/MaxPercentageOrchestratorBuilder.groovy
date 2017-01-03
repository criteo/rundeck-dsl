package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'maxPercentageOrchestrator' sections
 */
class MaxPercentageOrchestratorBuilder extends OrchestratorBuilder {

    MaxPercentageOrchestratorBuilder() {
        super('maxPercentage')
    }

    def percent(Integer value) {
        this.configurationClosure = {
            entry('percent', value.toString())
        }
    }

}
