package com.TestRunner.Nov;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.util.nov.NovTestBase;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"src/test/resources/Featuress"} , 
plugin = {"json:target/cucumber.json"},
glue = "NovStepDef",tags= {"@Senity"})

public class NovTestRunner extends AbstractTestNGCucumberTests {

	@BeforeTest
	public void openurlll() {
		NovTestBase openurl = new NovTestBase();
		openurl.initbrowser();
	
		
	}
	@AfterTest
	public void closeurll() {
		NovTestBase openurl = new NovTestBase();
		openurl.driver.quit();
	}
	
}
