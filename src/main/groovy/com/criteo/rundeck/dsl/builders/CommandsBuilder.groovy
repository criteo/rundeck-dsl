package com.criteo.rundeck.dsl.builders

import com.criteo.rundeck.dsl.doc.MethodDoc

abstract class CommandsBuilder {

    abstract build()

    abstract def registerCommand(BuildingClosure c)

    final def registerCommand(Class builder, Closure value) {
        registerCommand(new BuildingClosure(builder, value))
    }

    @MethodDoc('Sets a command to be executed on target nodes. By opposition to "script", this command will be executed outside of any shell, so logical operators or redirections cannot be used')
    def exec(String execCommand, @DelegatesTo(ExecBuilder) Closure value) {
        registerCommand(ExecBuilder, value >> { command(execCommand) })
    }

    def exec(String execCommand) {
        this.exec(execCommand, {})
    }

    @MethodDoc('Sets an inline script to be executed on target nodes.')
    def script(String scriptBody, @DelegatesTo(ScriptBuilder) Closure value) {
        registerCommand(ScriptBuilder, value >>  { body(scriptBody) })
    }

    def script(String scriptBody) {
        this.script(scriptBody, {})
    }

    @MethodDoc('Sets the path of a script file to be executed on target nodes.')
    def scriptFile(String scriptPath, @DelegatesTo(ScriptFileBuilder) Closure value) {
        registerCommand(ScriptFileBuilder, value >> { path(scriptPath) })
    }

    def scriptFile(String scriptPath) {
        this.scriptFile(scriptPath, {})
    }

    @MethodDoc('Sets the URL of a script file to be executed on target nodes.')
    def scriptUrl(String l, @DelegatesTo(ScriptUrlBuilder) Closure value) {
        registerCommand(ScriptUrlBuilder, value >> { url(l) })
    }

    def scriptUrl(String l) {
        this.scriptUrl(l, {})
    }

    @MethodDoc('Sets a reference to another job to be executed.')
    def jobref(@DelegatesTo(JobRefBuilder) Closure value) {
        registerCommand(JobRefBuilder, value)
    }

    @MethodDoc('Sets a node-step plugin to be executed.')
    def nodestepplugin(@DelegatesTo(NodeStepPluginBuilder) Closure value) {
        registerCommand(NodeStepPluginBuilder, value)
    }

    @MethodDoc('''Sets a command to be executed locally. When dispatching to nodes, the "local exec" step will be executed for each node and given that node's information, but will be run locally''')
    def localexec(String localExecCommand, @DelegatesTo(NodeStepPluginBuilder.LocalExecBuilder) Closure value) {
        registerCommand(NodeStepPluginBuilder.LocalExecBuilder, value >> { command(localExecCommand) })
    }

    def localexec(String localExecCommand) {
        localexec(localExecCommand, {})
    }

    @MethodDoc('Sets a workflow-step plugin to be executed')
    def stepplugin(@DelegatesTo(StepPluginBuilder) Closure value) {
        registerCommand(StepPluginBuilder, value)
    }

}
