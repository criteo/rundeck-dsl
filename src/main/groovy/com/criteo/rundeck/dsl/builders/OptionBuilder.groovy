package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc
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

    @MethodDoc('Sets the date/time format to use in the UI. Using the momentjs format.')
    def dateFormat(String value) {
        this.dateFormat = value
    }

    @MethodDoc('Sets the string to use when joining multiple input values. Required if multivalued is "true".')
    def delimiter(String value) {
        this.delimiter = value
    }

    @MethodDoc('Sets the description of this option, which will be rendered as Markdown.')
    def description(String value) {
        this.description = value
    }

    @MethodDoc('Sets whether this option value must be one of the specified possible values.')
    def enforcedValues(Boolean value = true) {
        this.enforcedValues = value
    }

    @MethodDoc('Sets whether this option should display as a date/time input field.')
    def isDate(Boolean value = true) {
        this.isDate = value
    }

    @MethodDoc('Sets whether this option supports multiple input values.')
    def multivalued(Boolean value = true) {
        this.multivalued = value
    }

    // Sets the name identifying this option (documented in the caller)
    def name(String value) {
        this.name = value
    }

    @MethodDoc('Sets a regular expression defining what option values are acceptable.')
    def regex(String value) {
        this.regex = value
    }

    @MethodDoc('Sets whether this option is required or not.')
    def required(Boolean value = true) {
        this.required = value
    }

    @MethodDoc('Sets whether this option is a secure input option. Not compatible with "multivalued".')
    def secure(Boolean value = true) {
        this.secure = value
    }

    @MethodDoc('Sets a storage path to password value to use as default for a secure option.')
    def storagePath(String value) {
        this.storagePath = value
    }

    @MethodDoc('Sets a default value for this option.')
    def value(String value) {
        this.value = value
    }

    @MethodDoc('Sets whether a secure input option value is exposed to scripts or not. False means the option will be used only as a Secure Remote Authentication option.')
    def valueExposed(Boolean value = true) {
        this.valueExposed = value
    }

    @MethodDoc('Sets a set of possible values for this option.')
    def values(String... values) {
        this.values.addAll(values)
    }

    @MethodDoc('Sets an URL to an endpoint that will return a JSON-formatted set of values for this option.')
    def valuesUrl(URL value) {
        this.valuesUrl = value
    }

}
