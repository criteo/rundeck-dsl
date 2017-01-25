package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class Option {

    def checker() {
        if (this.name == null)
            throw new Error("The name of the option shall be set")

        if (this.secure != null && this.multivalued != null)
            throw new Error("Option ${this.name} is both secured and multivalued, while only one of the two is authorized")

        if (this.storagePath != null && this.secure == null)
            throw new Error("Option ${this.name} is not secured but has a storage path, which only makes sense when the option is secured")

        if (this.multivalued != null && this.delimiter == null)
            throw new Error("Option ${this.name} is multivalued but no delimiter is set, which is required")

        // TODO: Check dateFormat
        // TODO: check validity for values

        return null
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
}
