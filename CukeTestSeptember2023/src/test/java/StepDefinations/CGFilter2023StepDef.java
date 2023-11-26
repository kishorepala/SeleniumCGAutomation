package StepDefinations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import Framework.DriverManager;
import Framework.DriverType;
import Pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CGFilter2023StepDef {
	
	WebDriver driver;
	DriverManager d = new DriverManager();
	HomePage homePage;
	
	@Before("@CarFilter001")
	public void BeforeTest() {
		
		driver = d.CreateDriver(DriverType.Chrome);		
	}
	
	@After("@CarFilter001")
    public void AfterTest() {
		
		System.out.println("Cleaning up driver Instance");
		driver.quit();
	}
	
	@Given("As CarsGuide active User, I'm on the landing Page")
	public void as_cars_guide_active_user_i_m_on_the_landing_page() {
	   
		homePage = new HomePage(driver);
		homePage.NavigateToHomePage("https://www.carsguide.com.au/");
		
	}

	@When("I filter cars by {string} and {string}")
	public void i_filter_cars_by_and(String make, String model) throws InterruptedException {
		
		homePage.SearchForCar(make, model);
	   
	}

	@Then("I should get search {string} displayed on landing Page")
	public void i_should_get_search_displayed_on_landing_page(String expectResult) {
	    
		String resultFromApp = homePage.GetSearchResults();
		//Assert.assertEquals(expectResult,resultFromApp);
		
		Assert.assertTrue(resultFromApp.contains(expectResult));
	}

}
