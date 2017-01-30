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

    @YamlProperty
    String description

    @YamlProperty
    Boolean executionEnabled

    @YamlProperty
    String group

    @YamlProperty
    LogLevel loglevel

    @YamlProperty(merge=true)
    BuildingClosure loglimit = new BuildingClosure(LoglimitBuilder)

    @YamlProperty
    Boolean multipleExecutions

    @YamlProperty
    String name

    @YamlProperty
    BuildingClosure nodefilters = new BuildingClosure(NodefiltersBuilder)

    @YamlProperty
    Boolean nodesSelectedByDefault

    @YamlProperty
    BuildingClosure notification = new BuildingClosure(NotificationBuilder)

    @YamlProperty(merge=true)
    BuildingClosure options = new BuildingClosure(OptionsBuilder)

    @YamlProperty
    BuildingClosure orchestrator

    @YamlProperty
    Integer retry

    @YamlProperty
    BuildingClosure schedule = new BuildingClosure(ScheduleBuilder)

    @YamlProperty
    Boolean scheduleEnabled

    @YamlProperty
    BuildingClosure sequence = new BuildingClosure(SequenceBuilder)

    @YamlProperty
    String timeout

    @YamlProperty
    UUID uuid

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

    def uuid(UUID value) {
        this.uuid = value
    }

}
