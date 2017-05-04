package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
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

    @MethodDoc('Sets the concurrency level inside each group. Value between 0 and 1 used as a ratio of nodes that can run the job simultaneously.')
    def maxPerGroup(Number value) {
        this.configuration.absorb({
            entry('maxPerGroup', value.toString())
        }, false)
    }

    @MethodDoc('Sets whether the job shall stop for a group when it failed for at least MaxPerGroup nodes in said group.')
    def stopProcessingGroupAfterTooManyFailure(Boolean value = true) {
        this.configuration.absorb({
            entry('stopProcessingGroupAfterTooManyFailure', value.toString())
        }, false)
    }

    @MethodDoc('Adds tags to use to group nodes.')
    def tagsName(String... values) {
        this.configuration.absorb({
            entry('tagsName', values.join(' '))
        }, false)
    }

}
