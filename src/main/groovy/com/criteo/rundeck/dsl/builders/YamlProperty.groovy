package com.criteo.rundeck.dsl.builders

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface YamlProperty {
    String name() default ""
    boolean merge() default false
}
