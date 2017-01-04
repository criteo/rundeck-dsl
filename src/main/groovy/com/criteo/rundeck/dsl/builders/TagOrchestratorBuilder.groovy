package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'tagOrchestrator' sections
 */
class TagOrchestratorBuilder extends OrchestratorBuilder {

    TagOrchestratorBuilder() {
        super('tag-orchestrator')
    }

    def maxPerGroup(Number value) {
        this.configuration.absorb({
            entry('maxPerGroup', value.toString())
        }, false)
    }

    def stopProcessingGroupAfterTooManyFailure(Boolean value = true) {
        this.configuration.absorb({
            entry('stopProcessingGroupAfterTooManyFailure', value.toString())
        }, false)
    }

    def tagsName(String... values) {
        this.configuration.absorb({
            entry('tagsName', values.join(' '))
        }, false)
    }

}
