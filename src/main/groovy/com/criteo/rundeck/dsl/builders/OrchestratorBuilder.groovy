package com.criteo.rundeck.dsl.builders

/**
 * Common helpers for builders of orchestrator sections
 */
class OrchestratorBuilder {

    static def generateXml(String orchestratorType, Closure config) {
        return {
            orchestrator {
                configuration {
                    with config
                }
                type(orchestratorType)
            }
        }
    }
}
