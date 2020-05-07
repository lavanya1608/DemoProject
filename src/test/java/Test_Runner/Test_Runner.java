package Test_Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "Feature",
		glue="Step_Definitions",
		plugin = {"json:target/cucumber.json","html:target/site/cucumber-pretty"},
	    dryRun= false 
		
		)
public class Test_Runner {

}
