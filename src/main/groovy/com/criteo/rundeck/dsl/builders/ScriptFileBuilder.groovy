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
        this.path = value
    }

    static def generateXml(ScriptFileBuilder b) {
        return generateXml(b) {
            if (b.interpreter != null) {
                scriptinterpreter(b.interpreter)
            }
            if (b.path != null) {
                scriptfile(b.path)
            }
            if (b.args != null) {
                scriptargs(b.args)
            }
        }
    }
}
