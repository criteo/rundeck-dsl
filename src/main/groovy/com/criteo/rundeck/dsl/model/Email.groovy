package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class Email {

    def checker() { return null }

    @YamlProperty
    Boolean attachLog

    @YamlProperty
    String recipients

    @YamlProperty
    String subject
}
