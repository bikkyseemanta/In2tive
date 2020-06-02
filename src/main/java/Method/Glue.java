package Method;

import org.openqa.selenium.By;

import com.cucumber.listener.Reporter;

import common_methods.CommonMethod;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Glue extends  CommonMethod
{

	@Given("^Run the URL to launch  application$")
	public void run_the_URL_to_launch_application() throws Throwable {
	    browser_and_url_open();
	}

	@When("^user fill invalid data in to the input text box \"([^\"]*)\"$")
	public void user_fill_invalid_data_in_to_the_input_text_box(String input) throws Throwable {
		//Fill invalid data to the input text box
		driver.findElement(By.xpath("//*[@placeholder='Enter an integer']")).sendKeys(input);
		
	}

	@When("^click on calculate button$")
	public void click_on_calculate_button() throws Throwable {
		//Then click on calculate button
		clickElementByXpath("//*[text()='Calculate!']");
	    
	}

	@Then("^Please enter an integer validation message shuold display$")
	public void please_enter_an_integer_validation_message_shuold_display() throws Throwable {
		if(driver.findElement(By.xpath("//*[text()='Please enter an integer']")).isDisplayed())
		{
			Reporter.addStepLog("If user fill alphabet to the input text box the validation message should display on the click of calculate button-->Success");
		}
		else
		{
			Reporter.addStepLog("If user fill alphabet to the input text box the validation message was not display on the click of calculate button-->Defect");
		}
	    
	}

	@Then("^the input text box should highlight in red colour$")
	public void the_input_text_box_should_highlight_in_red_colour() throws Throwable {
		String warningclor=driver.findElement(By.xpath("//*[@placeholder='Enter an integer']")).getCssValue("color");
		System.out.println(warningclor);

		if(warningclor.contains("rgba(85, 85, 85, 1)"))
		{
			Reporter.addStepLog("The warning text box is highlighting in RED color if user searching for alphanumeric values-->SUCCESS");
		}
		else
		{
			Reporter.addStepLog("The warning text box is not highlighting in RED color if user searching for alphanumeric values-->DEFECT");
		}
	   
	}

}
