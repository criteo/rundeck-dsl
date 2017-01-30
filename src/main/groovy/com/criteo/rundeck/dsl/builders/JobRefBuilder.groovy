package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.JobRef

/**
 * Builder of 'job-ref' sections
 */
class JobRefBuilder extends CommandBuilder {

    def build() {
        JobRef j = new JobRef()

        j.jobref = [ args: this.jobref.args,
                     group: this.jobref.group,
                     name: this.jobref.name,
                     nodeStep: this.jobref.nodeStep,
                     nodefilters: null ]

        if (this.jobref.nodefilters?.value) {
            j.jobref.nodefilters = this.jobref.nodefilters.realize().build()
        }

        return j
    }

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
