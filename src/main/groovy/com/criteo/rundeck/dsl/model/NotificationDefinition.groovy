package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class NotificationDefinition {

    def checker() { return null }

    @YamlProperty
    Email email

    @YamlProperty
    Plugin plugin

    @YamlProperty
    def webhook = []
}
