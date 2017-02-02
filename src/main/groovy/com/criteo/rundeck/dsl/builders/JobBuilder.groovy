package com.criteo.rundeck.dsl.builders

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

    def description(String value) {
        this.description = value
    }

    def executionEnabled(Boolean value = true) {
        this.executionEnabled = value
    }

    def group(String value) {
        this.group = value
    }

    def loglevel(LogLevel value) {
        this.loglevel = value
    }

    def loglimit(String loggingLimit, @DelegatesTo(LoglimitBuilder) Closure value, boolean overwrite = false) {
        value = ({ limit(loggingLimit) } << value)
        this.loglimit.absorb(value, overwrite)
    }

    def multipleExecutions(Boolean value = true) {
        this.multipleExecutions = value
    }

    def name(String value) {
        this.name = value
    }

    def nodefilters(@DelegatesTo(NodefiltersBuilder) Closure value, boolean overwrite = false) {
        this.nodefilters.absorb(value, overwrite)
    }

    def nodesSelectedByDefault(Boolean value = true) {
        this.nodesSelectedByDefault = value
    }

    def notification(@DelegatesTo(NotificationBuilder) Closure value, boolean overwrite = false) {
        this.notification.absorb(value, overwrite)
    }

    def options(@DelegatesTo(OptionsBuilder) Closure value, boolean overwrite = false) {
        this.options.absorb(value, overwrite)
    }

    def retry(Integer value) {
        this.retry = value
    }

    def schedule(@DelegatesTo(ScheduleBuilder) Closure value, boolean overwrite = false) {
        this.schedule.absorb(value, overwrite)
    }

    def scheduleEnabled(Boolean value = true) {
        this.scheduleEnabled = value
    }

    def sequence(@DelegatesTo(SequenceBuilder) Closure value, boolean overwrite = false) {
        this.sequence.absorb(value, overwrite)
    }

    def subsetOrchestrator(@DelegatesTo(SubsetOrchestratorBuilder) Closure value) {
        this.orchestrator = new BuildingClosure(SubsetOrchestratorBuilder, value)
    }
    // (Require the TagOrchestrator plugin)
    def tagOrchestrator(@DelegatesTo(TagOrchestratorBuilder) Closure value) {
        this.orchestrator = new BuildingClosure(TagOrchestratorBuilder, value)
    }
    // (Require the MaxPercentageOrchestrator plugin)
    def maxPercentageOrchestrator(@DelegatesTo(MaxPercentageOrchestratorBuilder) Closure value) {
        this.orchestrator = new BuildingClosure(MaxPercentageOrchestratorBuilder, value)
    }

    def timeout(String value) {
        this.timeout = value
    }

    def uuid(String value) {
        this.uuid = value
    }

}
