package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
import com.criteo.rundeck.dsl.model.Job
import com.criteo.rundeck.dsl.model.LogLevel

/**
 * Builder of 'job' sections
 */
class JobBuilder {

    def build() {
        Job j = new Job()

        j.description = this.description
        j.executionEnabled = this.executionEnabled
        j.group = this.group
        j.loglevel = this.loglevel
        j.loglimit = this.loglimit?.value ? this.loglimit.realize().build() : null
        j.multipleExecutions = this.multipleExecutions
        j.name = this.name
        j.nodefilters = this.nodefilters?.value ? this.nodefilters.realize().build() : null
        j.nodesSelectedByDefault = this.nodesSelectedByDefault
        j.notification = this.notification?.value ? this.notification.realize().build() : null
        j.options = this.options?.value ? this.options.realize().build() : null
        j.orchestrator = this.orchestrator?.value ? this.orchestrator.realize().build() : null
        j.retry = this.retry
        j.schedule = this.schedule?.value ? this.schedule.realize().build() : null
        j.scheduleEnabled = this.scheduleEnabled
        j.sequence = this.sequence?.value ? this.sequence.realize().build() : null
        j.timeout = this.timeout
        j.uuid = this.uuid

        return j
    }

    String description

    Boolean executionEnabled

    String group

    LogLevel loglevel

    BuildingClosure loglimit = new BuildingClosure(LoglimitBuilder)

    Boolean multipleExecutions

    String name

    BuildingClosure nodefilters = new BuildingClosure(NodefiltersBuilder)

    Boolean nodesSelectedByDefault

    BuildingClosure notification = new BuildingClosure(NotificationBuilder)

    BuildingClosure options = new BuildingClosure(OptionsBuilder)

    BuildingClosure orchestrator

    Integer retry

    BuildingClosure schedule = new BuildingClosure(ScheduleBuilder)

    Boolean scheduleEnabled

    BuildingClosure sequence = new BuildingClosure(SequenceBuilder)

    String timeout

    String uuid

    @MethodDoc('Sets the description for this job (can be blank). The first line is the "simple description". Remaining lines are the "extended description"')
    def description(String value) {
        this.description = value
    }

    @MethodDoc('Sets whether this job is enabled for execution.')
    def executionEnabled(Boolean value = true) {
        this.executionEnabled = value
    }

    @MethodDoc('Sets the group name of this job.')
    def group(String value) {
        this.group = value
    }

    @MethodDoc('Sets the log level to use for this job.')
    def loglevel(LogLevel value) {
        this.loglevel = value
    }

    @MethodDoc('Sets the logging limit for this job.')
    def loglimit(String loggingLimit, @DelegatesTo(LoglimitBuilder) Closure value, boolean overwrite = false) {
        value = ({ limit(loggingLimit) } << value)
        this.loglimit.absorb(value, overwrite)
    }

    @MethodDoc('Sets whether this job can executed several times at once.')
    def multipleExecutions(Boolean value = true) {
        this.multipleExecutions = value
    }

    @MethodDoc('Sets the name of this job. A non-null, non-empty name is required.')
    def name(String value) {
        this.name = value
    }

    @MethodDoc('Configures node filters')
    def nodefilters(@DelegatesTo(NodefiltersBuilder) Closure value, boolean overwrite = false) {
        this.nodefilters.absorb(value, overwrite)
    }

    def nodesSelectedByDefault(Boolean value = true) {
        this.nodesSelectedByDefault = value
    }

    @MethodDoc('Configures result notifications for this job')
    def notification(@DelegatesTo(NotificationBuilder) Closure value, boolean overwrite = false) {
        this.notification.absorb(value, overwrite)
    }

    @MethodDoc('Configures options of this job.')
    def options(@DelegatesTo(OptionsBuilder) Closure value, boolean overwrite = false) {
        this.options.absorb(value, overwrite)
    }

    @MethodDoc('Sets the number of times to retry the job if it fails or times out.')
    def retry(Integer value) {
        this.retry = value
    }

    @MethodDoc('Configures the schedule for this job (for its repeated execution).')
    def schedule(@DelegatesTo(ScheduleBuilder) Closure value, boolean overwrite = false) {
        this.schedule.absorb(value, overwrite)
    }

    def scheduleEnabled(Boolean value = true) {
        this.scheduleEnabled = value
    }

    @MethodDoc('Configures the workflow of this job.')
    def sequence(@DelegatesTo(SequenceBuilder) Closure value, boolean overwrite = false) {
        this.sequence.absorb(value, overwrite)
    }

    @MethodDoc('Configures the orchestrator for this job as a "subset orchestrator".')
    def subsetOrchestrator(@DelegatesTo(SubsetOrchestratorBuilder) Closure value) {
        this.orchestrator = new BuildingClosure(SubsetOrchestratorBuilder, value)
    }

    @MethodDoc('Configures the orchestrator for this job as a "tag orchestrator". Requires the TagOrchestrator plugin.')
    def tagOrchestrator(@DelegatesTo(TagOrchestratorBuilder) Closure value) {
        this.orchestrator = new BuildingClosure(TagOrchestratorBuilder, value)
    }

    @MethodDoc('Configures the orchestrator for this job as a "max percentage orchestrator".')
    def maxPercentageOrchestrator(@DelegatesTo(MaxPercentageOrchestratorBuilder) Closure value) {
        this.orchestrator = new BuildingClosure(MaxPercentageOrchestratorBuilder, value)
    }

    @MethodDoc('Sets the maximum runtime before the job should be stopped.')
    def timeout(String value) {
        this.timeout = value
    }

    @MethodDoc('Sets the unique identifier of this job')
    def uuid(String value) {
        this.uuid = value
    }

}
