package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'tagOrchestrator' sections
 */
class TagOrchestratorBuilder extends OrchestratorBuilder {

    TagOrchestratorBuilder() {
        super('tag-orchestrator')
    }

    def maxPerGroup(Number value) {
        this.configurationClosure = (this.configurationClosure ?: {}) << {
            entry('maxPerGroup', value.toString())
        }
    }

    def stopProcessingGroupAfterTooManyFailure(Boolean value = true) {
        this.configurationClosure = (this.configurationClosure ?: {}) << {
            entry('stopProcessingGroupAfterTooManyFailure', value.toString())
        }
    }

    def tagsName(String... values) {
        this.configurationClosure = (this.configurationClosure ?: {}) << {
            entry('tagsName', values.join(' '))
        }
    }

}
