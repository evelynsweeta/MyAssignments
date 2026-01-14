package stepdefilayer;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepdefinition {
	public ChromeDriver driver;
	
	@Given("Launch the browser and get the url")
	public void launch_the_browser_and_get_the_url() {
		driver=new ChromeDriver();
		// Load the URL
		driver.get("http://leaftaps.com/opentaps/"); 
	}

	@When("Enter the username")
	public void enter_the_username() {
		driver.findElement(By.id("username")).sendKeys("democsr2");
		
	}

	@When("Enter the password")
	public void enter_the_password() {
		driver.findElement(By.id("password")).sendKeys("crmsfa");
	}

	@When("click the login button")
	public void click_the_login_button() {
		driver.findElement(By.className("decorativeSubmit")).click();
	}

	@Then("user should be logged in to the application")
	public void user_should_be_logged_in_to_the_application() {
	    String title = driver.getTitle();
	    if (title.contains("Leaftaps")) {
			System.out.println("Logged in successfully");
		} else {
			System.out.println("Login failed");
		}
	    driver.close();
	}

}
