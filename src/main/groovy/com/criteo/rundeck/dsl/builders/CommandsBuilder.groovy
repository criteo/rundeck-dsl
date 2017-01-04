package com.criteo.rundeck.dsl.builders

abstract class CommandsBuilder {

    def commands = []

    def exec(String execCommand, @DelegatesTo(ExecBuilder) Closure value = {}) {
        this.commands.add(new BuildingClosure(ExecBuilder, value >> { command(execCommand) }))
    }

    def script(String scriptBody, @DelegatesTo(ScriptBuilder) Closure value = {}) {
        this.commands.add(new BuildingClosure(ScriptBuilder, value >>  { body(scriptBody) }))
    }

    def scriptFile(String scriptPath, @DelegatesTo(ScriptFileBuilder) Closure value = {}) {
        this.commands.add(new BuildingClosure(ScriptFileBuilder, value >> { path(scriptPath) }))
    }

    def scriptUrl(String l, @DelegatesTo(ScriptUrlBuilder) Closure value = {}) {
        this.commands.add(new BuildingClosure(ScriptUrlBuilder, value >> { url(l) }))
    }

    def jobref(@DelegatesTo(JobRefBuilder) Closure value) {
        this.commands.add(new BuildingClosure(JobRefBuilder, value))
    }

    def nodestepplugin(@DelegatesTo(NodeStepPluginBuilder) Closure value) {
        this.commands.add(new BuildingClosure(NodeStepPluginBuilder, value))
    }

    def localexec(String localExecCommand, @DelegatesTo(NodeStepPluginBuilder.LocalExecBuilder) Closure value = {}) {
        this.commands.add(new BuildingClosure(NodeStepPluginBuilder.LocalExecBuilder, value >> { command(localExecCommand) }))
    }

    def stepplugin(@DelegatesTo(StepPluginBuilder) Closure value) {
        this.commands.add(new BuildingClosure(StepPluginBuilder, value))
    }

}
