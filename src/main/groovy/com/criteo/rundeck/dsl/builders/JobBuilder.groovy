package com.criteo.rundeck.dsl.builders

import org.apache.commons.lang3.StringEscapeUtils
import com.criteo.rundeck.dsl.model.LogLevel

/**
 * Builder of 'job' sections
 */
class JobBuilder {

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
