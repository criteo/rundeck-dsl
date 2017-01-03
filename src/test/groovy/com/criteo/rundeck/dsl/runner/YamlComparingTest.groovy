package com.criteo.rundeck.dsl.runner

import com.criteo.rundeck.dsl.Interpreter
import com.criteo.rundeck.dsl.builders.YamlGenerator
import org.junit.Test
import org.yaml.snakeyaml.DumperOptions
import org.yaml.snakeyaml.Yaml

import java.nio.file.Paths

import static org.junit.Assert.assertEquals

class YamlComparingTest {

    void generateAndCompare(String expectedResourcePath, String inputResourcePath) {
        def input = Paths.get(getClass().getResource(inputResourcePath).file)

        def jobListBuilder = new Interpreter().run(input)

        def options = new DumperOptions()
        options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK)
        def output = new Yaml(options).dump(YamlGenerator.generate(jobListBuilder))

        def expected = Paths.get(getClass().getResource(expectedResourcePath).file).text

        assertEquals expected, output
    }

    @Test
    void testGeneratingMostDirectives() {
        generateAndCompare("/most_directives.yaml", "/most_directives.groovy")
    }

}
