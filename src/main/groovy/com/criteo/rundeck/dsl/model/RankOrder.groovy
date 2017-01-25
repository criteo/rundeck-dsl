package com.criteo.rundeck.dsl.model

enum RankOrder {
    ASCENDING,
    DESCENDING

    String toString() {
        this.name().toLowerCase()
    }
}