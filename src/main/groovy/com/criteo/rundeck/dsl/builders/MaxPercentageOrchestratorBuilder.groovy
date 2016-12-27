package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'maxPercentageOrchestrator' sections
 */
class MaxPercentageOrchestratorBuilder {

    Integer percent

    def percent(Integer value) {
        this.percent = value
    }

    static def generateXml(MaxPercentageOrchestratorBuilder b) {
        return OrchestratorBuilder.generateXml('maxPercentage') {
            percent(b.percent)
        }
    }
}
