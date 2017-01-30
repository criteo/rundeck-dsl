package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.TagOrchestrator

/**
 * Builder of 'tagOrchestrator' sections
 */
class TagOrchestratorBuilder extends OrchestratorBuilder {

    def build() {
        TagOrchestrator o = new TagOrchestrator()

        o.configuration = this.configuration?.value ? this.configuration.realize().build() : null
        o.type = this.type

        return o
    }

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
