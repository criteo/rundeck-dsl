package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'job-list' sections
 */
class JobListBuilder {

    def jobClosures = []

    def job(String jobName, @DelegatesTo(JobBuilder) Closure value) {
        this.jobClosures.add({
            name(jobName)
            with value
        })
    }

    static def generateXml(JobListBuilder b) {
        return {
            b.jobClosures.each { jobClosure ->
                with Shortcuts.generateXml(JobBuilder, jobClosure)
            }
        }
    }
}
