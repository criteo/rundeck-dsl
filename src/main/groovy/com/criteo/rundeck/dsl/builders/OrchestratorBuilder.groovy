package com.criteo.rundeck.dsl.builders

/**
 * Common helpers for builders of orchestrator sections
 */
abstract class OrchestratorBuilder {

    final String type

    Closure configurationClosure

    OrchestratorBuilder(String type) {
        this.type = type
    }

    static def generateXml(OrchestratorBuilder b) {
        return {
            orchestrator {
                configuration {
                    with Shortcuts.generateXml(ConfigurationBuilder, b.configurationClosure)
                }
                type(b.type)
            }
        }
    }

}
