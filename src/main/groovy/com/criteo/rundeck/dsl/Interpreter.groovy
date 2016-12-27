package com.criteo.rundeck.dsl

import com.criteo.rundeck.dsl.builders.JobListBuilder
import org.codehaus.groovy.control.CompilerConfiguration

import java.nio.file.Path

class Interpreter {
    final Binding binding = new Binding()
    final GroovyShell shell

    Interpreter() {
        def cc = new CompilerConfiguration();
        cc.setScriptBaseClass(DelegatingScript.class.getName());
        this.shell = new GroovyShell(this.class.classLoader, binding, cc);
    }

    JobListBuilder run(Path p) {
        def sc = (DelegatingScript) shell.parse(p.toFile())
        def b = new JobListBuilder()
        sc.setDelegate(b)
        sc.run()
        b
    }
}
