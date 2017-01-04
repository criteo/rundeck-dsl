package com.criteo.rundeck.dsl.builders

abstract class CommandsBuilder {

    abstract def registerCommand(BuildingClosure c)

    final def registerCommand(Class builder, Closure value) {
        registerCommand(new BuildingClosure(builder, value))
    }

    def exec(String execCommand, @DelegatesTo(ExecBuilder) Closure value = {}) {
        registerCommand(ExecBuilder, value >> { command(execCommand) })
    }

    def script(String scriptBody, @DelegatesTo(ScriptBuilder) Closure value = {}) {
        registerCommand(ScriptBuilder, value >>  { body(scriptBody) })
    }

    def scriptFile(String scriptPath, @DelegatesTo(ScriptFileBuilder) Closure value = {}) {
        registerCommand(ScriptFileBuilder, value >> { path(scriptPath) })
    }

    def scriptUrl(String l, @DelegatesTo(ScriptUrlBuilder) Closure value = {}) {
        registerCommand(ScriptUrlBuilder, value >> { url(l) })
    }

    def jobref(@DelegatesTo(JobRefBuilder) Closure value) {
        registerCommand(JobRefBuilder, value)
    }

    def nodestepplugin(@DelegatesTo(NodeStepPluginBuilder) Closure value) {
        registerCommand(NodeStepPluginBuilder, value)
    }

    def localexec(String localExecCommand, @DelegatesTo(NodeStepPluginBuilder.LocalExecBuilder) Closure value = {}) {
        registerCommand(NodeStepPluginBuilder.LocalExecBuilder, value >> { command(localExecCommand) })
    }

    def stepplugin(@DelegatesTo(StepPluginBuilder) Closure value) {
        registerCommand(StepPluginBuilder, value)
    }

}
