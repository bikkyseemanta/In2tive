package Runner_Glue;

import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(

		features = "C:\\Users\\lenovo\\eclipse-workspace\\TestInTwoTive\\src\\main\\java\\inttive\\inttwotive.feature",
		glue = {"Method" }, 
		monochrome = true, 
		dryRun = false,
		strict = true,
		 format =
		 {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		tags = { "@Validate_Red_From_Validation_Styling,@Validate_factorial_of_five" })


public class Runner {

}
