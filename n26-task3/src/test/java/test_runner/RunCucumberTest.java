package test_runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		strict = true,
		plugin = {"pretty", "html:target/cucumber", "json:target/cucumber/report.json"},
		tags = {"~@excluded"},
		features = "src/test/resources/features/",
		glue = {"stepdefs_api"}
)

public class RunCucumberTest {

}
