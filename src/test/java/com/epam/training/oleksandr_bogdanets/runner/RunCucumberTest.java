package com.epam.training.oleksandr_bogdanets.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.epam.training.oleksandr_bogdanets.steps", "com.epam.training.oleksandr_bogdanets.hooks"},
    plugin = {
        "pretty",
        "html:target/cucumber-report.html",
        "json:target/cucumber.json"
    },
    monochrome = true
)
public class RunCucumberTest extends AbstractTestNGCucumberTests {
}
