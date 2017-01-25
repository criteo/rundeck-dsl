package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty

class Notification {

    def checker() { return null }

    @YamlProperty
    NotificationDefinition onfailure

    @YamlProperty
    NotificationDefinition onstart

    @YamlProperty
    NotificationDefinition onsuccess
}
