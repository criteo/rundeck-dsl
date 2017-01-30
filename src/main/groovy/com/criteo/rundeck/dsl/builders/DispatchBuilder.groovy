package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.Dispatch
import com.criteo.rundeck.dsl.model.RankOrder

/**
 * Builder of 'dispatch' sections
 */
class DispatchBuilder {

    def build() {
        Dispatch d = new Dispatch()

        d.excludePrecedence = this.excludePrecedence
        d.keepgoing = this.keepgoing
        d.rankAttribute = this.rankAttribute
        d.rankOrder = this.rankOrder
        d.threadcount = this.threadcount

        return d
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

    def excludePrecedence(Boolean value = true) {
        this.excludePrecedence = value
    }

    def keepgoing(Boolean value = true) {
        this.keepgoing = value
    }

    def rankAttribute(String value) {
        this.rankAttribute = value
    }

    def rankOrder(RankOrder value) {
        this.rankOrder = value
    }

    def threadcount(Integer value) {
        this.threadcount = value
    }

}
