package com.criteo.rundeck.dsl.enums

enum RankOrder {
    ASCENDING,
    DESCENDING

    String toString() {
        this.name().toLowerCase()
    }
}