package com.criteo.rundeck.dsl.model

enum Strategy {
    NODE_FIRST,
    STEP_FIRST,
    PARALLEL

    String toString() {
        this.name().toLowerCase().replaceAll('_', '-')
    }
}