package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.enums.LogLevel
import org.apache.commons.lang3.StringEscapeUtils

/**
 * Builder of 'job' sections
 */
class JobBuilder {

    Closure contextClosure

    String description

    Closure dispatchClosure

    String group

    Closure loggingClosure

    LogLevel loglevel

    boolean multipleExecutions

    String name

    Closure nodefiltersClosure

    Closure notificationClosure

    def orchestrator

    Integer retry

    Closure scheduleClosure

    Closure sequenceClosure

    String timeout

    UUID uuid

    def context(@DelegatesTo(ContextBuilder) Closure value, boolean overwrite = false) {
        this.contextClosure = overwrite ? value : (this.contextClosure ?: {}) << value
    }

    def description(String value) {
        this.description = value
    }

    def dispatch(@DelegatesTo(DispatchBuilder) Closure value, boolean overwrite = false) {
        this.dispatchClosure = overwrite ? value : (this.dispatchClosure ?: {}) << value
    }

    def group(String value) {
        this.group = value
    }

    def logging(@DelegatesTo(LoggingBuilder) Closure value, boolean overwrite = false) {
        this.loggingClosure = overwrite ? value : (this.loggingClosure ?: {}) << value
    }

    def loglevel(LogLevel value) {
        this.loglevel = value
    }

    def multipleExecutions(boolean value = true) {
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
                if (b.contextClosure) {
                    with Shortcuts.generateXml(ContextBuilder, b.contextClosure)
                }
                if (b.description) {
                    if (b.description.contains('\n') || !b.description.equals(StringEscapeUtils.escapeXml10(b.description))) {
                        description {
                            mkp.yieldUnescaped("<![CDATA[${b.description}]]>")
                        }
                    } else {
                        description(b.description)
                    }
                }
                if (b.dispatchClosure) {
                    with Shortcuts.generateXml(DispatchBuilder, b.dispatchClosure)
                }
                if (b.group) {
                    group(b.group)
                }
                if (b.loggingClosure) {
                    with Shortcuts.generateXml(LoggingBuilder, b.loggingClosure)
                }
                if (b.loglevel) {
                    loglevel(b.loglevel)
                }
                if (b.multipleExecutions) {
                    multipleExecutions(b.multipleExecutions)
                }
                if (b.name) {
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
                if (b.retry) { // TODO: check: number or '${option.retry}'
                    retry(b.retry)
                }
                if (b.scheduleClosure) {
                    with Shortcuts.generateXml(ScheduleBuilder, b.scheduleClosure)
                }
                if (b.sequenceClosure) {
                    with Shortcuts.generateXml(SequenceBuilder, b.sequenceClosure)
                }
                if (b.timeout) { // TODO: check format
                    timeout(b.timeout)
                }
                if (b.uuid) {
                    uuid(b.uuid)
                }
            }
        }
    }
}
