package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'job-list' sections
 */
class JobListBuilder {

    def jobClosures = []

    def job(String jobName, @DelegatesTo(JobBuilder) Closure value) {
        this.jobClosures.add(new BuildingClosure(JobBuilder, {
            name(jobName)
            with value
        }))
    }

}
