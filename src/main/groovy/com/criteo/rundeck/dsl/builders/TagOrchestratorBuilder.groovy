package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'tagOrchestrator' sections
 */
class TagOrchestratorBuilder extends OrchestratorBuilder {

    TagOrchestratorBuilder() {
        super('tag-orchestrator')
    }

    def maxPerGroup(Number value) {
        this.configurationClosure.absorb({
            entry('maxPerGroup', value.toString())
        }, false)
    }

    def stopProcessingGroupAfterTooManyFailure(Boolean value = true) {
        this.configurationClosure.absorb({
            entry('stopProcessingGroupAfterTooManyFailure', value.toString())
        }, false)
    }

    def tagsName(String... values) {
        this.configurationClosure.absorb({
            entry('tagsName', values.join(' '))
        }, false)
    }

}
