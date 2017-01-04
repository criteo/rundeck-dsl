package com.criteo.rundeck.dsl.builders

class Shortcuts {

    static <T> T build(Class<T> builder, Closure c) {
        def b = builder.newInstance()
        c.delegate = b
        c.resolveStrategy = Closure.DELEGATE_FIRST
        c.call()
        b
    }

    static Closure generateXml(Class builder, Closure c) {
        return builder.generateXml(build(builder, c))
    }

    static def queryAllFields(Class c) {
        c.declaredFields + (c.superclass ? queryAllFields(c.superclass) : [])
    }

    static Closure generateXml(BuildingClosure c) {
        return c.builder.generateXml(c.realize())
    }

}
