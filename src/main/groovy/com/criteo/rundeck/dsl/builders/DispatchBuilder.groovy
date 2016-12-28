package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.enums.RankOrder

/**
 * Builder of 'dispatch' sections
 */
class DispatchBuilder {

    Boolean keepgoing

    String rankAttribute

    RankOrder rankOrder

    Integer threadcount

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
                if (b.keepgoing != null) {
                    keepgoing(b.keepgoing)
                }
                if (b.rankAttribute != null) {
                    rankAttribute(b.rankAttribute)
                }
                if (b.rankOrder) {
                    rankOrder(b.rankOrder.mnemonic)
                }
                if (b.threadcount != null) { // TODO: check positive
                    threadcount(b.threadcount)
                }
            }
        }
    }
}
