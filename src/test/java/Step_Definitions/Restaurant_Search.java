package Step_Definitions;

import cucumber.api.java.en.Given;

import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

@RunWith(Cucumber.class)

public class Restaurant_Search {

	public WebDriver driver = null;
	static WebDriver webDriver;
	SoftAssert TC001 = new SoftAssert();
	SoftAssert TC002 = new SoftAssert();
	SoftAssert TC003 = new SoftAssert();

	@Given("^Initialize the browser$")
	public void initialize_the_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("Chrome Browser Initialized");

	}

	@When("^user enters the (.+)$")
	public void user_enters_the(String postcode) throws Throwable {
		WebElement Enter_Your_Postcode = driver.findElement(By.name("postcode"));
		Enter_Your_Postcode.clear();
		Enter_Your_Postcode.sendKeys(postcode); // Input Post code is passed
	}

	@Then("^user sees search results$")
	public void user_sees_search_results() throws Throwable {
		String Search_results = driver.getTitle();
		{
			if (Search_results.contains("Restaurants and takeaways in")) {
				System.out.println("User is in Search Results Page");
			}

			else {
				System.out.println("Error in Search results");
			}
		}
	}

	@Given("^Navigate to JUST EAT Site$")
	public void navigate_to_JUST_EAT_Site() throws Throwable {
		driver.get("https://www.just-eat.co.uk/"); // Launching of Website
		System.out.println("JUST EAT website is launched");

	}

	@And("^click on \"([^\"]*)\"$")
	public void click_on_something(String strArg1) throws Throwable {

		driver.findElement(By.xpath("//button[@class='Form_c-search-btn_2cjDI']")).click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@And("^verify user should see some restaurants for (.+)$")

	// Restuarant Search results Page Validation
	public void verify_user_should_see_some_restaurants_for(String postcode) throws Throwable {
		String URL = driver.getCurrentUrl();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> links = driver.findElements(By.cssSelector(".c-listing-item--withHeader"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		int linkCount = links.size();
		System.out.println("Number of open resturant :" + linkCount);
		int i = 1;
		while (i <= linkCount) {

			driver.get(URL);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			driver.findElement(By.cssSelector(".c-listing-item--withHeader:nth-of-type(" + i + ")")).click();
			System.out.println("User is in resturant info page");
			String postcode1 = driver.findElement(By.id("postcode")).getText();
			System.out.println("Input Passcode:" + postcode);
			TC001.assertTrue(postcode1.equals(postcode),
					"Assertion Soft Passed: Validate input post code in Restaurant Info Page");
			TC002.assertAll();
			if (postcode1.equals(postcode)) {
				System.out.println("Restaurant available for the input Postcode :" + postcode1);
				break;
			}

			else {
				if (i == linkCount) {

				}
				i++;

			}
		}
	}

	@Then("^verify number of Restaurant listed should be equal to the number of open Restaurant displayed in the header$")
	public void verify_number_of_Restaurant_listed_should_be_equal_to_the_number_of_open_Restaurant_displayed_in_the_header()
			throws Throwable {
		// Validation of Count of restuarant displayed in Search Results
		WebElement Count = driver.findElement(By.xpath("//*[contains(text(),'open restaurants')]"));
		String Open_resturant_txt = Count.getText();
		if (Open_resturant_txt.contains(" ")) {
			String restaurant_count_str = Open_resturant_txt.substring(0, Open_resturant_txt.indexOf(" "));
			int open_restaurant_count = Integer.parseInt(restaurant_count_str);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			List<WebElement> links = driver.findElements(By.cssSelector(".c-listing-item--withHeader"));
			int linkCount = links.size();
			System.out.println("Number of displayed open resturant :" + linkCount);
			TC002.assertEquals(open_restaurant_count, linkCount);
			TC002.assertAll();
		}
	}

	@Then("^Verify the Please enter a postcode displayed$")
	public void verify_the_Please_enter_a_postcode_displayed() throws Throwable {

		System.out.println("Code to be implemented");
	}

	@Then("^Verify display of (.+)$")
	public void verify_the_displayed(String errormessage) throws Throwable {

		WebElement Message = driver.findElement(By.className("Form_c-search-error_7vv2T"));
		String Error_display = Message.getText();
		TC003.assertEquals(Error_display, errormessage);
		TC003.assertAll();
	}

	@And("^Close the browser$")
	public void close_the_browser() throws Throwable {
		driver.close();
		System.out.println("Test Case Passed Browser is closed");
	}
}
