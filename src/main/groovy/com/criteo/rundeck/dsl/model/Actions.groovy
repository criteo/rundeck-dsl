package com.criteo.rundeck.dsl.model

enum Actions {
    HALT,
    TRUNCATE

    String toString() {
        this.name().toLowerCase()
    }
}
