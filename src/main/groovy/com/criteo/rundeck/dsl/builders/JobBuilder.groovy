package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.enums.LogLevel
import org.apache.commons.lang3.StringEscapeUtils

/**
 * Builder of 'job' sections
 */
class JobBuilder {

    String description

    String group

    LogLevel loglevel

    BuildingClosure loglimitClosure = new BuildingClosure(LoglimitBuilder)

    Boolean multipleExecutions

    String name

    BuildingClosure nodefiltersClosure = new BuildingClosure(NodefiltersBuilder)

    BuildingClosure notificationClosure = new BuildingClosure(NotificationBuilder)

    BuildingClosure optionsClosure = new BuildingClosure(OptionsBuilder)

    BuildingClosure orchestrator

    Integer retry

    BuildingClosure scheduleClosure = new BuildingClosure(ScheduleBuilder)

    BuildingClosure sequenceClosure = new BuildingClosure(SequenceBuilder)

    String timeout

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
        this.loglimitClosure.absorb(value, overwrite)
    }

    def multipleExecutions(Boolean value = true) {
        this.multipleExecutions = value
    }

    def name(String value) {
        this.name = value
    }

    def nodefilters(@DelegatesTo(NodefiltersBuilder) Closure value, boolean overwrite = false) {
        this.nodefiltersClosure.absorb(value, overwrite)
    }

    def notification(@DelegatesTo(NotificationBuilder) Closure value, boolean overwrite = false) {
        this.notificationClosure.absorb(value, overwrite)
    }

    def options(@DelegatesTo(OptionsBuilder) Closure value, boolean overwrite = false) {
        this.optionsClosure.absorb(value, overwrite)
    }

    def retry(Integer value) {
        this.retry = value
    }

    def schedule(@DelegatesTo(ScheduleBuilder) Closure value, boolean overwrite = false) {
        this.scheduleClosure.absorb(value, overwrite)
    }

    def sequence(@DelegatesTo(SequenceBuilder) Closure value, boolean overwrite = false) {
        this.sequenceClosure.absorb(value, overwrite)
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
                if (b.optionsClosure.value) {
                    with Shortcuts.generateXml(b.optionsClosure)
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
                if (b.loglimitClosure.value) {
                    with Shortcuts.generateXml(b.loglimitClosure)
                }
                if (b.multipleExecutions != null) {
                    multipleExecutions(b.multipleExecutions)
                }
                if (b.name != null) {
                    name(b.name)
                }
                if (b.nodefiltersClosure.value) {
                    with Shortcuts.generateXml(b.nodefiltersClosure)
                }
                if (b.notificationClosure.value) {
                    with Shortcuts.generateXml(b.notificationClosure)
                }
                if (b.orchestrator) {
                    with Shortcuts.generateXml(b.orchestrator)
                }
                if (b.retry != null) { // TODO: check: number or '${option.retry}'
                    retry(b.retry)
                }
                if (b.scheduleClosure.value) {
                    with Shortcuts.generateXml(b.scheduleClosure)
                }
                if (b.sequenceClosure.value) {
                    with Shortcuts.generateXml(b.sequenceClosure)
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
