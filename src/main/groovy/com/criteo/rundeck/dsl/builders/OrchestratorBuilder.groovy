package com.criteo.rundeck.dsl.builders

/**
 * Common helpers for builders of orchestrator sections
 */
abstract class OrchestratorBuilder {

    @YamlProperty
    final String type

    @YamlProperty
    BuildingClosure configuration = new BuildingClosure(ConfigurationBuilder)

    OrchestratorBuilder(String type) {
        this.type = type
    }

    static def generateXml(OrchestratorBuilder b) {
        return {
            orchestrator {
                configuration {
                    with Shortcuts.generateXml(b.configuration)
                }
                type(b.type)
            }
        }
    }

}
