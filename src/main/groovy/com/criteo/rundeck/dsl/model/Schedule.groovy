package com.criteo.rundeck.dsl.model

import com.criteo.rundeck.dsl.builders.YamlProperty
import com.cronutils.model.CronType
import com.cronutils.model.definition.CronDefinitionBuilder
import com.cronutils.parser.CronParser

class Schedule {

    def checker() {

        if (this.crontab != null) {
            def cronDefinition = CronDefinitionBuilder.instanceDefinitionFor(CronType.QUARTZ)
            def parser = new CronParser(cronDefinition)
            def quartzCron = parser.parse(this.crontab)

            // throw IllegalArgumentException
            quartzCron.validate()
        }

        if (this.crontab != null && (this.year != null || this.time != null || this.weekday != null || this.month != null))
            throw new Error("The schedule has both a crontab and individual fields set, while only one of the two is authorized")
        return null
    }

    @YamlProperty
    String crontab

    @YamlProperty(merge=true)
    Month month

    @YamlProperty
    Time time

    @YamlProperty
    Weekday weekday

    @YamlProperty
    String year
}
