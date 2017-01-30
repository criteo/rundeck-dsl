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
}
