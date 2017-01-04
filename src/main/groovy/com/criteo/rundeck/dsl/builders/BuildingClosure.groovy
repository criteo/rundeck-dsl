package com.criteo.rundeck.dsl.builders

class BuildingClosure {

    final Class builder

    Closure value

    BuildingClosure(Class builder) {
        this.builder = builder
    }

    def absorb(Closure more, boolean overwrite) {
        if (overwrite) {
            value = more
        } else {
            value = value ? (value << more) : more
        }
        this
    }

    def realize() {
        def b = builder.newInstance()
        value.delegate = b
        value.resolveStrategy = Closure.DELEGATE_FIRST
        value.call()
        b
    }
}
