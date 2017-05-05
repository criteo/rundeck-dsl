package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
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

    @MethodDoc('Sets the arguments to pass to the referenced job when executed.')
    def args(String value) {
        this.args = value
    }

    @MethodDoc('Sets the group name of the referenced job.')
    def group(String value) {
        this.group = value
    }

    @MethodDoc('Sets the name of the referenced job.')
    def name(String value) {
        this.name = value
    }

    @MethodDoc('Sets whether this job reference shall be executed as a node step.')
    def nodeStep(Boolean value) {
        this.nodeStep = value
    }

    def nodeStep() {
        this.nodeStep(true)
    }

    @MethodDoc('Configures the node filters to use for this reference (overriding the filters of the referenced job).')
    def nodefilters(@DelegatesTo(NodefiltersBuilder) Closure value, boolean overwrite) {
        this.nodefilters.absorb(value, overwrite)
    }

    def nodefilters(@DelegatesTo(NodefiltersBuilder) Closure value) {
        this.nodefilters(value, false)
    }
}
