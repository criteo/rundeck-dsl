package com.criteo.rundeck.dsl.builders

/**
 * Common helpers for builders of orchestrator sections
 */
abstract class OrchestratorBuilder {

    abstract build()

    final String type

    BuildingClosure configuration = new BuildingClosure(ConfigurationBuilder)

    OrchestratorBuilder(String type) {
        this.type = type
    }
}
