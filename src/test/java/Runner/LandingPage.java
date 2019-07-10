package Runner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/feature"},
				 tags = {"@TechnicalSprint"},
				 glue= {"StepDefinitions"},
				 plugin= {"pretty","html:target/cucumber-reports",
						 "json:target/cucumber-reports/cucumber-usage.json","junit:target/cucumber-results.xml"}, 
				 monochrome = true,
				 dryRun = false
		)

public class LandingPage {

}
