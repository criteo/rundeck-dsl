package com.criteo.rundeck.dsl.builders

class Shortcuts {

    static <T> T build(Class<T> builder, Closure c) {
        def b = builder.newInstance()
        c.delegate = b
        c.resolveStrategy = Closure.DELEGATE_FIRST
        c.call()
        b
    }

    static def queryAllFields(Class c) {
        c.declaredFields + (c.superclass ? queryAllFields(c.superclass) : [])
    }

}
