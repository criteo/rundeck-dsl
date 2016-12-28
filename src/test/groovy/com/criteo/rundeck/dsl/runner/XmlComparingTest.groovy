package com.criteo.rundeck.dsl.runner

import com.criteo.rundeck.dsl.Interpreter
import com.criteo.rundeck.dsl.builders.JobListBuilder
import groovy.xml.MarkupBuilder
import org.junit.Test

import java.nio.file.Paths

import static org.junit.Assert.assertEquals

class XmlComparingTest {

    void generateAndCompare(String expectedResourcePath, String inputResourcePath) {
        def expected = Paths.get(getClass().getResource(expectedResourcePath).file).text
        def input = Paths.get(getClass().getResource(inputResourcePath).file)

        JobListBuilder jobListBuilder = new Interpreter().run(input)

        def writer = new StringWriter()
        new MarkupBuilder(writer).joblist() {
            with JobListBuilder.generateXml(jobListBuilder)
        }

        assertEquals expected, writer.toString()
    }

    @Test
    void testGeneratingMostDirectives() {
        generateAndCompare("/most_directives.xml", "/most_directives.groovy")
    }

    @Test
    void testGeneratingEscapedDescription() {
        generateAndCompare("/job_description_multiline.xml", "/job_description_multiline.groovy")
        generateAndCompare("/job_description_xml_entities.xml", "/job_description_xml_entities.groovy")
    }
}
