package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'job-ref' sections
 */
class JobRefBuilder extends CommandBuilder {

    String arg

    Closure dispatchClosure

    String group

    String name

    boolean nodeStep

    Closure nodefiltersClosure

    def arg(String value) {
        this.arg = value
    }

    def dispatch(@DelegatesTo(DispatchBuilder) Closure value, boolean overwrite = false) {
        this.dispatchClosure = overwrite ? value : (this.dispatchClosure ?: {}) << value
    }

    def group(String value) {
        this.group = value
    }

    def name(String value) {
        this.name = value
    }

    def nodeStep(boolean value = true) {
        this.nodeStep = value
    }

    def nodefilters(@DelegatesTo(NodefiltersBuilder) Closure value, boolean overwrite = false) {
        this.nodefiltersClosure = overwrite ? value : (this.nodefiltersClosure ?: {}) << value
    }

    static def generateXml(JobRefBuilder b) {
        return generateXml(b) {
            def attributes = [:]
            if (b.group) {
                attributes.put('group', b.group)
            }
            if (b.name) {
                attributes.put('name', b.name)
            }
            if (b.nodeStep) {
                attributes.put('nodeStep', b.nodeStep)
            }
            jobref(attributes) {
                if (b.arg) {
                    arg(line: b.arg)
                }
                if (b.nodefiltersClosure) {
                    with Shortcuts.generateXml(NodefiltersBuilder, b.nodefiltersClosure)
                }
                if (b.dispatchClosure) {
                    with Shortcuts.generateXml(DispatchBuilder, b.dispatchClosure)
                }
            }
        }
    }
}
