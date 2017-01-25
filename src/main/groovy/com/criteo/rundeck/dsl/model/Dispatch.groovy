package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class Dispatch {

    def checker() {
        if (this.threadcount != null && this.threadcount <= 0)
            throw new Error("Dispatch: threadcount should be positive")
        return null
    }

    @YamlProperty
    Boolean excludePrecedence

    @YamlProperty
    Boolean keepgoing

    @YamlProperty
    String rankAttribute

    @YamlProperty
    RankOrder rankOrder

    @YamlProperty
    Integer threadcount
}
