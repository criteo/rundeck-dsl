package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'job-ref' sections
 */
class JobRefBuilder extends CommandBuilder {

    String args

    String group

    String name

    Boolean nodeStep

    Closure nodefiltersClosure

    def args(String value) {
        this.args = value
    }

    def group(String value) {
        this.group = value
    }

    def name(String value) {
        this.name = value
    }

    def nodeStep(Boolean value = true) {
        this.nodeStep = value
    }

    def nodefilters(@DelegatesTo(NodefiltersBuilder) Closure value, boolean overwrite = false) {
        this.nodefiltersClosure = overwrite ? value : (this.nodefiltersClosure ?: {}) << value
    }

    static def generateXml(JobRefBuilder b) {
        return generateXml(b) {
            def attributes = [:]
            if (b.group != null) {
                attributes.put('group', b.group)
            }
            if (b.name != null) {
                attributes.put('name', b.name)
            }
            if (b.nodeStep != null) {
                attributes.put('nodeStep', Boolean.toString(b.nodeStep))
            }
            jobref(attributes) {
                if (b.args != null) {
                    arg(line: b.args)
                }
                if (b.nodefiltersClosure) {
                    with Shortcuts.generateXml(NodefiltersBuilder, b.nodefiltersClosure)
                }
            }
        }
    }
}
