package com.criteo.rundeck.dsl.builders

/**
 * Builder of 'scriptUrl' sections
 */
class ScriptUrlBuilder extends CommandBuilder {

    String args

    String interpreter

    String url

    def args(String value) {
        this.args = value
    }

    def interpreter(String value) {
        this.interpreter = value
    }

    def url(String value) {
        this.url = value
    }

    static def generateXml(ScriptUrlBuilder b) {
        return generateXml(b) {
            if (b.interpreter) {
                scriptinterpreter(b.interpreter)
            }
            scripturl(b.url)
            if (b.args) {
                scriptargs(b.args)
            }
        }
    }
}
