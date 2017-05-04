package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
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

    Boolean excludePrecedence

    Boolean keepgoing

    String rankAttribute

    RankOrder rankOrder

    Integer threadcount

    @MethodDoc('Determines precedence for filters.')
    def excludePrecedence(Boolean value = true) {
        this.excludePrecedence = value
    }

    @MethodDoc('Sets whether to keep going on remaining nodes if failures occur on some nodes.')
    def keepgoing(Boolean value = true) {
        this.keepgoing = value
    }

    @MethodDoc('Sets the name of the node attribute to use for ordering the sequence of nodes.')
    def rankAttribute(String value) {
        this.rankAttribute = value
    }

    @MethodDoc('Sets the order direction for node ranking.')
    def rankOrder(RankOrder value) {
        this.rankOrder = value
    }

    @MethodDoc('Set the number of threads to use for parallel dispatch.')
    def threadcount(Integer value) {
        this.threadcount = value
    }

}
