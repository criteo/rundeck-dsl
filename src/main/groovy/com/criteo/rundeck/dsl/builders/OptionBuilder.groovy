package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.model.Option

/**
 * Builder of 'option' sections
 */
class OptionBuilder {

    def build() {
        Option o = new Option()

        o.dateFormat = this.dateFormat
        o.delimiter = this.delimiter
        o.description = this.description
        o.enforcedValues = this.enforcedValues
        o.isDate = this.isDate
        o.multivalued = this.multivalued
        o.name = this.name
        o.regex = this.regex
        o.required = this.required
        o.secure = this.secure
        o.storagePath = this.storagePath
        o.value = this.value
        o.valueExposed = this.valueExposed
        o.values = this.values
        o.valuesUrl = this.valuesUrl

        return o
    }

    @YamlProperty
    String dateFormat

    @YamlProperty
    String delimiter

    @YamlProperty
    String description

    @YamlProperty(name='enforced')
    Boolean enforcedValues

    @YamlProperty
    Boolean isDate

    @YamlProperty
    Boolean multivalued

    @YamlProperty
    String name

    @YamlProperty
    String regex

    @YamlProperty
    Boolean required

    @YamlProperty
    Boolean secure

    @YamlProperty
    String storagePath

    @YamlProperty
    String value

    @YamlProperty
    Boolean valueExposed

    @YamlProperty
    def values = []

    @YamlProperty
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

}
