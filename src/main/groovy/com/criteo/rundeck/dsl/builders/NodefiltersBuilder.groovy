package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'nodefilters' sections
 */
class NodefiltersBuilder {

    boolean excludePrecedence

    String filter

    def excludePrecedence(boolean value = true) {
        this.excludePrecedence = value
    }

    def filter(String value) {
        this.filter = value
    }

    static def generateXml(NodefiltersBuilder b) {
        return {
            nodefilters(excludeprecedence: Boolean.toString(b.excludePrecedence)) {
                if (b.filter) {
                    filter(b.filter)
                }
            }
        }
    }
}
