package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.enums.LimitActionValue

/**
 * Builder of 'logging' sections
 */
class LoggingBuilder {

    String limit

    Closure limitActionClosure

    def limit(String value, @DelegatesTo(LimitActionBuilder) Closure c = null) {
        this.limit = value
        this.limitActionClosure = c
    }

    static def generateXml(LoggingBuilder b) {
        return {
            def attributes = [:]
            if (b.limit != null) { // TODO: check format
                attributes.put('limit', b.limit)
            }
            if (b.limitActionClosure) {
                def limitAction = Shortcuts.build(LimitActionBuilder, b.limitActionClosure)
                switch (limitAction.value) {
                    case LimitActionValue.HALT:
                        attributes.put('limitAction', 'halt')
                        if (limitAction.statusOnHalt != null) {
                            attributes.put('status', limitAction.statusOnHalt)
                        }
                        break;
                    case LimitActionValue.TRUNCATE:
                        attributes.put('limitAction', 'truncate')
                        break;
                }
            }
            logging(attributes)
        }
    }
}
