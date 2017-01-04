package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.enums.RankOrder

/**
 * Builder of 'dispatch' sections
 */
class DispatchBuilder {

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

    static def generateXml(DispatchBuilder b) {
        return {
            dispatch {
                if (b.excludePrecedence != null) {
                    excludePrecedence(b.excludePrecedence)
                }
                if (b.keepgoing != null) {
                    keepgoing(b.keepgoing)
                }
                if (b.rankAttribute != null) {
                    rankAttribute(b.rankAttribute)
                }
                if (b.rankOrder) {
                    rankOrder(b.rankOrder.toString())
                }
                if (b.threadcount != null) { // TODO: check positive
                    threadcount(b.threadcount)
                }
            }
        }
    }
}
