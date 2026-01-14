package week6.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class StaticParameterization {
	@Parameters({"url","username","password","companyname","description"})
@Test
	public  void staticData(String url,String username,String password,String companyname,String description) throws InterruptedException {
		        //configure chrome option
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--user-data-dir=C:\\EmptyFile");
				// Initialize ChromeDriver
				ChromeDriver driver=new ChromeDriver(options);
				// Load the URL
				driver.get(url);
				// Maximize the browser window
				driver.manage().window().maximize();
			       // Add implicit wait
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		        //enter username
		        driver.findElement(By.id("username")).sendKeys(username);
		         //enter password
		         driver.findElement(By.id("password")).sendKeys(password);
		         //click login
		         driver.findElement(By.id("Login")).click();
			    //Click on the toggle menu button from the left corner
		         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
					WebElement element = wait.until(
					        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='slds-button slds-context-bar__button slds-icon-waffle_container slds-show']"))
					);
					element.click();
			    //Click View All and click Legal Entities from App Launcher
		         driver.findElement(By.xpath("//button[text()='View All']")).click();
		         Thread.sleep(2000);
		         WebElement legalEnt = driver.findElement(By.xpath("//p[text()='Legal Entities']"));	
		         Actions action=new Actions(driver);
		         action.moveToElement(legalEnt).click().perform();
		        //Click on the Dropdown icon in the legal Entities tab-WHICH dropdown
			    //Click on New Legal Entity
	            driver.findElement(By.xpath("//div[text()='New']")).click();	
	            Thread.sleep(1500);
		        //Enter the Company name as 'TestLeaf'.
		         driver.findElement(By.xpath("(//input[@class='slds-input'])[3]")).sendKeys(companyname);			         
			    //Enter Description as 'Salesforces'.
		         driver.findElement(By.xpath("(//textarea[@class='slds-textarea'])[2]")).sendKeys(description);	
			    //Select Status as 'Active'
		         Thread.sleep(1000);
		         WebElement scrollDown = driver.findElement(By.xpath("//button[@aria-label='Status']"));
		         JavascriptExecutor js = (JavascriptExecutor) driver;
		         js.executeScript("arguments[0].scrollIntoView({block:'center'});", scrollDown);
		         js.executeScript("arguments[0].click();", scrollDown);		         
		         driver.findElement(By.xpath("//span[text()='Active']")).click();
		         //Click on Save 
		         driver.findElement(By.xpath("//button[text()='Save']")).click();
			    //Verify the Alert message (Complete this field) displayed for Name 
		         WebElement actualValiMessage = driver.findElement(By.xpath("//div[text()='Complete this field.']"));
		         String message = actualValiMessage.getText();
		         System.out.println(message);
		         if (message.contains("Complete this field.")) {
		        	    System.out.println("Validation message is displayed correctly");
		        	} else {
		        	    System.out.println("Validation message is NOT correct");
		        	}
		         //close browser
		         driver.close();

	}

}
