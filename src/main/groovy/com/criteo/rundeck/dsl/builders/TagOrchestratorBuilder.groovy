package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'tagOrchestrator' sections
 */
class TagOrchestratorBuilder {

    Number maxPerGroup

    Boolean stopProcessingGroupAfterTooManyFailure

    def tagsName = []

    def maxPerGroup(Number value) {
        this.maxPerGroup = value
    }

    def stopProcessingGroupAfterTooManyFailure(Boolean value = true) {
        this.stopProcessingGroupAfterTooManyFailure = value
    }

    def tagsName(String... values) {
        this.tagsName.addAll(values)
    }

    static def generateXml(TagOrchestratorBuilder b) {
        return OrchestratorBuilder.generateXml('tag-orchestrator') {
            if (b.maxPerGroup != null) {
                maxPerGroup(b.maxPerGroup)
            }
            if (b.stopProcessingGroupAfterTooManyFailure != null) {
                stopProcessingGroupAfterTooManyFailure(b.stopProcessingGroupAfterTooManyFailure)
            }
            tagsName(b.tagsName.join(' '))
        }
    }

}
