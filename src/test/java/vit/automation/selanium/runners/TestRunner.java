package vit.automation.selanium.runners;
import org.junit.ClassRule; 
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features="classpath:Feature",
		glue="vit.automation.selanium.stepdis",
		tags="@prodisc",
		plugin={
				"pretty",
				"html:target/html/htmlreport.html",
				"json:target/json/file.json",
		},
				monochrome =true,
				publish=true,
				dryRun=false
				
				
				
		
		)
public class TestRunner{
	
}
