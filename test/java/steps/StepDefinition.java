package steps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
public ChromeDriver driver;
public WebDriverWait wait;
	@Given("Launch the chrome browser and get the url and maximize the window")
	public void launch_the_chrome_browser_and_get_the_url_and_maximize_the_window() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=C:\\EmptyFile");
		driver=new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
	}

	@When("Enter the username in the field")
	public void enter_the_username_in_the_field() {
		driver.findElement(By.id("username")).sendKeys("sweetadesmond.718f91184711@agentforce.com");
	}

	@When("Enter the password in the field")
	public void enter_the_password_in_the_field() {
		driver.findElement(By.id("password")).sendKeys("TEST12345");
	}

	@When("Click login button")
	public void click_login_button() {
		driver.findElement(By.id("Login")).click();
	}

	@When("Click on toggle menu button")
	public void click_on_toggle_menu_button() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		WebElement element = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='slds-button slds-context-bar__button slds-icon-waffle_container slds-show']"))
		);
		element.click();
	}

	@When("Click view All and click Sales from App Launcher")
	public void click_view_all_and_click_sales_from_app_launcher() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
        Thread.sleep(2000);
        WebElement sales = driver.findElement(By.xpath("(//a[@class='slds-text-heading_small'])[14]"));	
        Actions action=new Actions(driver);
        action.moveToElement(sales).click().perform();
	}

	@When("Click on Accounts tab")
	public void click_on_accounts_tab() throws InterruptedException {
		Thread.sleep(2000);
	    WebElement account = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.xpath("(//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none'])[5]"))
		);
	    account.click();
	}

	@When("Click on New button")
	public void click_on_new_button() throws InterruptedException {
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//div[text()='New']")).click();
	}

	@When("Enter account name")
	public void enter_account_name() throws InterruptedException {
		Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Evelyn Sweeta Tellus");
	}

	@When("Select Ownership as Public")
	public void select_ownership_as_public() throws InterruptedException {
		Thread.sleep(1000);
		WebElement drpdown = driver.findElement(By.xpath("//button[@aria-label='Ownership']/span"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].scrollIntoView({block:'center'});", drpdown);
         js.executeScript("arguments[0].click();", drpdown);	
		driver.findElement(By.xpath("//span[text()='Public']")).click();
		
	}

	@When("Click save")
	public void click_save() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
	}

	@Then("Verify the account name is created successfully")
	public void verify_the_account_name_is_created_successfully() throws InterruptedException {
		Thread.sleep(2000);
		String accountName = driver.findElement(By.xpath("//slot[@name='primaryField']/lightning-formatted-text")).getText();
        System.out.println("Account name:" +accountName);
        if (accountName.contains("Evelyn Sweeta Tellus")) {
   	        System.out.println("ACCOUNT NAME IS SAME AS EXEPETED");
   	    } else {
   	    System.out.println("ACCOUNT NAME IS DIFFERENT");
   	}
        driver.close();
	}



}
