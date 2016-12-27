package com.criteo.rundeck.dsl.builders

abstract class CommandsBuilder {

    def commands = []

    def exec(String execCommand, @DelegatesTo(ExecBuilder) Closure value = {}) {
        this.commands.add([builder: ExecBuilder.class, closure: (value >> { command(execCommand) })])
    }

    def script(String scriptBody, @DelegatesTo(ScriptBuilder) Closure value = {}) {
        this.commands.add([builder: ScriptBuilder.class, closure: (value >>  { body(scriptBody) })])
    }

    def scriptFile(String scriptPath, @DelegatesTo(ScriptFileBuilder) Closure value = {}) {
        this.commands.add([builder: ScriptFileBuilder.class, closure: (value >> { path(scriptPath) })])
    }

    def scriptUrl(String l, @DelegatesTo(ScriptUrlBuilder) Closure value = {}) {
        this.commands.add([builder: ScriptUrlBuilder.class, closure: (value >> { url(l) })])
    }

    def jobref(@DelegatesTo(JobRefBuilder) Closure value) {
        this.commands.add([builder: JobRefBuilder.class, closure: value])
    }

    def nodestepplugin(@DelegatesTo(NodeStepPluginBuilder) Closure value) {
        this.commands.add([builder: NodeStepPluginBuilder.class, closure: value])
    }

    def localexec(String localExecCommand, @DelegatesTo(NodeStepPluginBuilder.LocalExecBuilder) Closure value = {}) {
        this.commands.add([builder: NodeStepPluginBuilder.LocalExecBuilder.class, closure: (value >> { command(localExecCommand) })])
    }

    def stepplugin(@DelegatesTo(StepPluginBuilder) Closure value) {
        this.commands.add([builder: StepPluginBuilder.class, closure: value])
    }

}
