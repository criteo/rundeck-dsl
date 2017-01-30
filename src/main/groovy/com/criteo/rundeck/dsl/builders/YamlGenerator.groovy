package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.JobList

import java.lang.reflect.Field

class YamlGenerator {

    static def queryAllYamlFields(t) {
        Shortcuts.queryAllFields(t).collectEntries { f ->
            def a = f.declaredAnnotations.find { it.annotationType() == YamlProperty }
            a ? [(f): a] : [:]
        }
    }

    private static boolean isPrimitive(v) {
        v.class in [Boolean, Integer, Number, String]
    }

    private static boolean isMap(v) {
        v.class == [:].class
    }

    private static boolean isArray(v) {
        v.class == [].class
    }

    private static boolean isBuildingClosure(v) {
        v.class == BuildingClosure
    }

    private static boolean isModel(v) {
        !(v instanceof Enum) && v.getClass().getPackage().getName() == "com.criteo.rundeck.dsl.model"
    }

    static def generate(value) {
        if (value == null) {
            return null

        } else if (isMap(value)) {
            if (!value.empty) {
                return value.collectEntries {
                    [(it.key): it.value ? generate(it.value) : null]
                }.findAll {
                    it.value != null
                }.sort()
            }

        } else if (isArray(value)) {
            if (!value.empty) {
                return value.collect {
                    generate(it)
                }.findAll()
            }

        } else if (isPrimitive(value)) {
            return value

        } else if (isModel(value)) {
            return queryAllYamlFields(value.class).collectEntries { Field f, YamlProperty yamlProperty ->
                def v = generate(value[f.name])
                if (v == null) {
                    return [:]
                } else if (yamlProperty.merge()) {
                    return v
                } else {
                    return [(yamlProperty.name() ?: f.name): v]
                }
            }.sort()
        } else {
            return value.toString()
        }
    }

    static def generate(JobListBuilder b) {
        JobList j = b.build()
        j.checker()
        j.jobClosures.collect { generate(it) }
    }
}
