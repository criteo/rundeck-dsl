package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.JobRef

/**
 * Builder of 'job-ref' sections
 */
class JobRefBuilder extends CommandBuilder {

    def build() {
        JobRef j = new JobRef()

        j.jobref = [ args: this.args,
                     group: this.group,
                     name: this.name,
                     nodeStep: this.nodeStep,
                     nodefilters: null ]

        if (this.nodefilters?.value) {
            j.jobref.nodefilters = this.nodefilters.realize().build()
        }

        return j
    }

    String args

    String group

    String name

    Boolean nodeStep

    BuildingClosure nodefilters = new BuildingClosure(NodefiltersBuilder)

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
        this.nodefilters.absorb(value, overwrite)
    }

}
