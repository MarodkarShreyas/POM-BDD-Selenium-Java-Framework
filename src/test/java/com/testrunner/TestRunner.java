package com.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "src/test/resources/com/features" }, 
	    glue = { "stepdefinitions", "AppHooks" }, 
	    plugin = { "pretty"}
		)
public class TestRunner {

}
