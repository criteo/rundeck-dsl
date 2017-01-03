package com.criteo.rundeck.dsl.enums

enum Strategy {
    NODE_FIRST,
    STEP_FIRST,
    PARALLEL

    String toString() {
        this.name().toLowerCase().replaceAll('_', '-')
    }
}