package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.enums.LogLevel
import org.apache.commons.lang3.StringEscapeUtils

/**
 * Builder of 'job' sections
 */
class JobBuilder {

    @YamlProperty
    String description

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
    BuildingClosure sequence = new BuildingClosure(SequenceBuilder)

    @YamlProperty
    String timeout

    @YamlProperty
    UUID uuid

    def description(String value) {
        this.description = value
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

    static def generateXml(JobBuilder b) {
        return {
            job {
                if (b.options.value) {
                    with Shortcuts.generateXml(b.options)
                }
                if (b.description != null) {
                    if (b.description.contains('\n') || !b.description.equals(StringEscapeUtils.escapeXml10(b.description))) {
                        description {
                            mkp.yieldUnescaped("<![CDATA[${b.description}]]>")
                        }
                    } else {
                        description(b.description)
                    }
                }
                if (b.group != null) {
                    group(b.group)
                }
                if (b.loglevel) {
                    loglevel(b.loglevel)
                }
                if (b.loglimit.value) {
                    with Shortcuts.generateXml(b.loglimit)
                }
                if (b.multipleExecutions != null) {
                    multipleExecutions(b.multipleExecutions)
                }
                if (b.name != null) {
                    name(b.name)
                }
                if (b.nodefilters.value) {
                    with Shortcuts.generateXml(b.nodefilters)
                }
                if (b.notification.value) {
                    with Shortcuts.generateXml(b.notification)
                }
                if (b.orchestrator) {
                    with Shortcuts.generateXml(b.orchestrator)
                }
                if (b.retry != null) { // TODO: check: number or '${option.retry}'
                    retry(b.retry)
                }
                if (b.schedule.value) {
                    with Shortcuts.generateXml(b.schedule)
                }
                if (b.sequence.value) {
                    with Shortcuts.generateXml(b.sequence)
                }
                if (b.timeout != null) { // TODO: check format
                    timeout(b.timeout)
                }
                if (b.uuid) {
                    uuid(b.uuid)
                }
            }
        }
    }
}
