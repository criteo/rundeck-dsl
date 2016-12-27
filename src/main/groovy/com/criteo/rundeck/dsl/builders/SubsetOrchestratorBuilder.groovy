package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'subsetOrchestrator' sections
 */
class SubsetOrchestratorBuilder {

    Integer count

    def count(Integer value) {
        this.count = value
    }

    static def generateXml(SubsetOrchestratorBuilder b) {
        return OrchestratorBuilder.generateXml('subset') {
            count(b.count)
        }
    }
}
