package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'option' sections
 */
class OptionBuilder {

    String dateFormat

    String delimiter

    String description

    Boolean enforcedValues

    Boolean isDate

    Boolean multivalued

    String name

    String regex

    Boolean required

    Boolean secure

    String storagePath

    String value

    Boolean valueExposed

    def values = []

    URL valuesUrl

    def dateFormat(String value) {
        this.dateFormat = value
    }

    def delimiter(String value) {
        this.delimiter = value
    }

    def description(String value) {
        this.description = value
    }

    def enforcedValues(Boolean value = true) {
        this.enforcedValues = value
    }

    def isDate(Boolean value = true) {
        this.isDate = value
    }

    def multivalued(Boolean value = true) {
        this.multivalued = value
    }

    def name(String value) {
        this.name = value
    }

    def regex(String value) {
        this.regex = value
    }

    def required(Boolean value = true) {
        this.required = value
    }

    def secure(Boolean value = true) {
        this.secure = value
    }

    def storagePath(String value) {
        this.storagePath = value
    }

    def value(String value) {
        this.value = value
    }

    def valueExposed(Boolean value = true) {
        this.valueExposed = value
    }

    def values(String... values) {
        this.values.addAll(values)
    }

    def valuesUrl(URL value) {
        this.valuesUrl = value
    }

    static def generateXml(OptionBuilder b) {
        return {
            def attributes = [:]
            if (b.dateFormat != null) { // TODO: check
                attributes.put('dateFormat', b.dateFormat)
            }
            if (b.delimiter != null) {
                attributes.put('delimiter', b.delimiter)
            }
            if (b.enforcedValues != null) {
                attributes.put('enforcedvalues', b.enforcedValues)
            }
            if (b.isDate != null) {
                attributes.put('isDate', b.isDate)
            }
            if (b.multivalued != null) {
                attributes.put('multivalued', b.multivalued)
                // TODO: check presence of 'delimiter'
            }
            if (b.name != null) { // TODO: require
                attributes.put('name', b.name)
            }
            if (b.regex != null) {
                attributes.put('regex', b.regex)
            }
            if (b.required != null) {
                attributes.put('required', b.required)
            }
            if (b.secure != null) {
                // TODO: check absence of 'multivalued'
                attributes.put('secure', b.secure)
            }
            if (b.storagePath != null) {
                // TODO: check presence of 'secure'
                attributes.put('storagePath', b.storagePath)
            }
            if (b.value != null) {
                attributes.put('value', b.value)
            }
            if (b.valueExposed != null) {
                attributes.put('valueExposed', b.valueExposed)
            }
            if (b.values) { // TODO: check validity
                attributes.put('values', b.values.join(','))
            }
            if (b.valuesUrl) {
                attributes.put('valuesUrl', b.valuesUrl)
            }
            option(attributes) {
                if (b.description != null) {
                    description(b.description)
                }
            }
        }
    }
}
