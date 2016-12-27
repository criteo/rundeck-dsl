package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.enums.RankOrder

/**
 * Builder of 'dispatch' sections
 */
class DispatchBuilder {

    boolean keepgoing

    String rankAttribute = 'nodename'

    RankOrder rankOrder = RankOrder.ASCENDING

    Integer threadcount

    def keepgoing(boolean value = true) {
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
                keepgoing(b.keepgoing)
                if (b.rankAttribute) {
                    rankAttribute(b.rankAttribute)
                }
                if (b.rankOrder) {
                    rankOrder(b.rankOrder.mnemonic)
                }
                if (b.threadcount) { // TODO: check positive
                    threadcount(b.threadcount)
                }
            }
        }
    }
}
