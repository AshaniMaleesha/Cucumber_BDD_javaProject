package com.runner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="src\\main\\resources\\Features",
		glue={"com.stepDefinition"},
		monochrome=true,
		plugin= {"html:test-output",
				"json:target/cucumber-report.json",
				"junit:Reports\\JUnitReport\\Cucumber.xml",
				},
		dryRun=true
		
		)
public class Runner {
	@AfterClass
    public static void generateReport() {
        File reportOutputDirectory = new File("target/cucumber-report");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("target/cucumber-report.json");

        Configuration configuration = new Configuration(reportOutputDirectory, "Your Project Name");
        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        reportBuilder.generateReports();
	}
}
