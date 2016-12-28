package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'tagOrchestrator' sections
 */
class TagOrchestratorBuilder {

    Number maxPerGroup

    boolean stopProcessingGroupAfterTooManyFailure

    def tagsName = []

    def maxPerGroup(Number value) {
        this.maxPerGroup = value
    }

    def stopProcessingGroupAfterTooManyFailure(boolean value = true) {
        this.stopProcessingGroupAfterTooManyFailure = value
    }

    def tagsName(String... values) {
        this.tagsName.addAll(values)
    }

    static def generateXml(TagOrchestratorBuilder b) {
        return OrchestratorBuilder.generateXml('tag-orchestrator') {
            maxPerGroup(b.maxPerGroup)
            stopProcessingGroupAfterTooManyFailure(b.stopProcessingGroupAfterTooManyFailure)
            tagsName(b.tagsName.join(' '))
        }
    }

}