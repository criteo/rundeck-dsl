package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
import com.criteo.rundeck.dsl.model.JobList

/**
 * Builder of 'job-list' sections
 */
class JobListBuilder {

    def build() {
        JobList j = new JobList()

        j.jobClosures = this.jobClosures.collect() { it.realize().build() }

        return j
    }

    def jobClosures = []

    @MethodDoc('Adds a job.')
    def job(String jobName, @DelegatesTo(JobBuilder) Closure value) {
        this.jobClosures.add(new BuildingClosure(JobBuilder, {
            name(jobName)
            with value
        }))
    }

}
