package com.criteo.rundeck.dsl.model

class JobList {

    def checker() { jobClosures.collect { it.checker() } }

    def jobClosures = []
}
