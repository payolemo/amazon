package com.amazon.testSuite.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "com.amazon.testSuite.steps", plugin = {"pretty", "html:target/cucumberReports"}, publish = true, monochrome = true)
public class TestSuiteExecutor {
}
