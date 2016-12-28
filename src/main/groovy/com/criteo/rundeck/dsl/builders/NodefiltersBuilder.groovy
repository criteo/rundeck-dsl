package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'nodefilters' sections
 */
class NodefiltersBuilder {

    Boolean excludePrecedence

    String filter

    def excludePrecedence(Boolean value = true) {
        this.excludePrecedence = value
    }

    def filter(String value) {
        this.filter = value
    }

    static def generateXml(NodefiltersBuilder b) {
        return {
            def attributes = [:]
            if (b.excludePrecedence != null) {
                attributes.put('excludeprecedence', Boolean.toString(b.excludePrecedence))
            }
            nodefilters(attributes) {
                if (b.filter != null) {
                    filter(b.filter)
                }
            }
        }
    }
}
