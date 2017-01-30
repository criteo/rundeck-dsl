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

}
