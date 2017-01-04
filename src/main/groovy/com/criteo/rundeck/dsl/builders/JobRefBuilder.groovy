package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'job-ref' sections
 */
class JobRefBuilder extends CommandBuilder {

    @YamlProperty
    def jobref = [ args: null,
                   group: null,
                   name: null,
                   nodeStep: null,
                   nodefilters: new BuildingClosure(NodefiltersBuilder) ]

    def args(String value) {
        this.jobref.args = value
    }

    def group(String value) {
        this.jobref.group = value
    }

    def name(String value) {
        this.jobref.name = value
    }

    def nodeStep(Boolean value = true) {
        this.jobref.nodeStep = value
    }

    def nodefilters(@DelegatesTo(NodefiltersBuilder) Closure value, boolean overwrite = false) {
        this.jobref.nodefilters.absorb(value, overwrite)
    }

    static def generateXml(JobRefBuilder b) {
        return generateXml(b) {
            def attributes = [:]
            if (b.jobref.group != null) {
                attributes.put('group', b.jobref.group)
            }
            if (b.jobref.name != null) {
                attributes.put('name', b.jobref.name)
            }
            if (b.jobref.nodeStep != null) {
                attributes.put('nodeStep', Boolean.toString(b.jobref.nodeStep))
            }
            jobref(attributes) {
                if (b.jobref.args != null) {
                    arg(line: b.jobref.args)
                }
                if (b.jobref.nodefilters.value) {
                    with Shortcuts.generateXml(b.jobref.nodefilters)
                }
            }
        }
    }
}
