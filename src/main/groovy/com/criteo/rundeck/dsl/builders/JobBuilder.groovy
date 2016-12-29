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

    Closure loglimitClosure

    Boolean multipleExecutions

    String name

    Closure nodefiltersClosure

    Closure notificationClosure

    Closure optionsClosure

    def orchestrator

    Integer retry

    Closure scheduleClosure

    Closure sequenceClosure

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
        this.loglimitClosure = overwrite ? value : (this.loglimitClosure ?: {}) << value
    }

    def multipleExecutions(Boolean value = true) {
        this.multipleExecutions = value
    }

    def name(String value) {
        this.name = value
    }

    def nodefilters(@DelegatesTo(NodefiltersBuilder) Closure value, boolean overwrite = false) {
        this.nodefiltersClosure = overwrite ? value : (this.nodefiltersClosure ?: {}) << value
    }

    def notification(@DelegatesTo(NotificationBuilder) Closure value, boolean overwrite = false) {
        this.notificationClosure = overwrite ? value : (this.notificationClosure ?: {}) << value
    }

    def options(@DelegatesTo(OptionsBuilder) Closure value, boolean overwrite = false) {
        this.optionsClosure = overwrite ? value : (this.optionsClosure ?: {}) << value
    }

    def retry(Integer value) {
        this.retry = value
    }

    def schedule(@DelegatesTo(ScheduleBuilder) Closure value, boolean overwrite = false) {
        this.scheduleClosure = overwrite ? value : (this.scheduleClosure ?: {}) << value
    }

    def sequence(@DelegatesTo(SequenceBuilder) Closure value, boolean overwrite = false) {
        this.sequenceClosure = overwrite ? value : (this.sequenceClosure ?: {}) << value
    }

    def subsetOrchestrator(@DelegatesTo(SubsetOrchestratorBuilder) Closure value) {
        this.orchestrator = [builder: SubsetOrchestratorBuilder, closure: value]
    }
    // (Require the TagOrchestrator plugin)
    def tagOrchestrator(@DelegatesTo(TagOrchestratorBuilder) Closure value) {
        this.orchestrator = [builder: TagOrchestratorBuilder, closure: value]
    }
    // (Require the MaxPercentageOrchestrator plugin)
    def maxPercentageOrchestrator(@DelegatesTo(MaxPercentageOrchestratorBuilder) Closure value) {
        this.orchestrator = [builder: MaxPercentageOrchestratorBuilder, closure: value]
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
                if (b.optionsClosure) {
                    with Shortcuts.generateXml(OptionsBuilder, b.optionsClosure)
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
                if (b.loglimitClosure) {
                    with Shortcuts.generateXml(LoglimitBuilder, b.loglimitClosure)
                }
                if (b.multipleExecutions != null) {
                    multipleExecutions(b.multipleExecutions)
                }
                if (b.name != null) {
                    name(b.name)
                }
                if (b.nodefiltersClosure) {
                    with Shortcuts.generateXml(NodefiltersBuilder, b.nodefiltersClosure)
                }
                if (b.notificationClosure) {
                    with Shortcuts.generateXml(NotificationBuilder, b.notificationClosure)
                }
                if (b.orchestrator) {
                    with Shortcuts.generateXml(b.orchestrator.builder, b.orchestrator.closure)
                }
                if (b.retry != null) { // TODO: check: number or '${option.retry}'
                    retry(b.retry)
                }
                if (b.scheduleClosure) {
                    with Shortcuts.generateXml(ScheduleBuilder, b.scheduleClosure)
                }
                if (b.sequenceClosure) {
                    with Shortcuts.generateXml(SequenceBuilder, b.sequenceClosure)
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
