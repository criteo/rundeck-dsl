package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'option' sections
 */
class OptionBuilder {

    String dateFormat

    String delimiter

    String description

    boolean enforcedValues

    boolean isDate

    boolean multivalued

    String name

    String regex

    boolean required

    boolean secure

    String storagePath

    String value

    boolean valueExposed

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

    def enforcedValues(boolean value = true) {
        this.enforcedValues = value
    }

    def isDate(boolean value = true) {
        this.isDate = value
    }

    def multivalued(boolean value = true) {
        this.multivalued = value
    }

    def name(String value) {
        this.name = value
    }

    def regex(String value) {
        this.regex = value
    }

    def required(boolean value = true) {
        this.required = value
    }

    def secure(boolean value = true) {
        this.secure = value
    }

    def storagePath(String value) {
        this.storagePath = value
    }

    def value(String value) {
        this.value = value
    }

    def valueExposed(boolean value = true) {
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
            if (b.delimiter) {
                attributes.put('delimiter', b.delimiter)
            }
            if (b.dateFormat) { // TODO: check
                attributes.put('dateFormat', b.dateFormat)
            }
            if (b.enforcedValues) {
                attributes.put('enforcedvalues', b.enforcedValues)
            }
            if (b.isDate) {
                attributes.put('isDate', b.isDate)
            }
            if (b.multivalued) {
                attributes.put('multivalued', b.multivalued)
                // TODO: check presence of 'delimiter'
            }
            if (b.name) { // TODO: require
                attributes.put('name', b.name)
            }
            if (b.regex) {
                attributes.put('regex', b.regex)
            }
            if (b.required) {
                attributes.put('required', b.required)
            }
            if (b.secure) {
                // TODO: check absence of 'multivalued'
                attributes.put('secure', b.secure)
            }
            if (b.storagePath) {
                // TODO: check presence of 'secure'
                attributes.put('storagePath', b.storagePath)
            }
            if (b.value) {
                attributes.put('value', b.value)
            }
            if (b.valueExposed) {
                attributes.put('valueExposed', b.valueExposed)
            }
            if (b.values) { // TODO: check validity
                attributes.put('values', b.values.join(','))
            }
            if (b.valuesUrl) {
                attributes.put('valuesUrl', b.valuesUrl)
            }
            option(attributes) {
                if (b.description) {
                    description(b.description)
                }
            }
        }
    }
}
