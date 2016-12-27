package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'scriptFile' sections
 */
class ScriptFileBuilder extends CommandBuilder {

    String args

    String interpreter

    String path

    def args(String value) {
        this.args = value
    }

    def interpreter(String value) {
        this.interpreter = value
    }

    def path(String value) {
        this.path = path
    }

    static def generateXml(ScriptFileBuilder b) {
        return generateXml(b) {
            if (b.interpreter) {
                scriptinterpreter(b.interpreter)
            }
            scriptfile(b.path)
            if (b.args) {
                scriptargs(b.args)
            }
        }
    }
}
