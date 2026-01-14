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

public class dummy {

	public static void main(String[] args) throws InterruptedException {
		
			
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--user-data-dir=C:\\EmptyFile");
				// Initialize ChromeDriver
				 ChromeDriver driver=new ChromeDriver(options);
				// Load the URL
				driver.get("https://login.salesforce.com/");
				// Maximize the browser window
			    driver.manage().window().maximize();
				driver.findElement(By.id("username")).sendKeys("sweetadesmond.718f91184711@agentforce.com");
				driver.findElement(By.id("password")).sendKeys("TEST12345");
				driver.findElement(By.id("Login")).click();
				Thread.sleep(2000);
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				WebElement element = wait.until(
				        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='slds-button slds-context-bar__button slds-icon-waffle_container slds-show']"))
				);
				element.click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[text()='View All']")).click();
		        Thread.sleep(2000);
		        WebElement sales = driver.findElement(By.xpath("(//a[@class='slds-text-heading_small'])[14]"));	
		        Actions action=new Actions(driver);
		        action.moveToElement(sales).click().perform();
				Thread.sleep(2000);
			    WebElement account = wait.until(
				        ExpectedConditions.visibilityOfElementLocated(By.xpath("(//one-app-nav-bar-item-root[@class='navItem slds-context-bar__item slds-shrink-none'])[5]"))
				);
			    account.click();
			    Thread.sleep(2000);
			    driver.findElement(By.xpath("//div[text()='New']")).click();
			    Thread.sleep(2000);
			    driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Evelyn Sweeta Tellus");
			    Thread.sleep(1000);
				WebElement drpdown = driver.findElement(By.xpath("//button[@aria-label='Ownership']/span"));
				JavascriptExecutor js = (JavascriptExecutor) driver;
		         js.executeScript("arguments[0].scrollIntoView({block:'center'});", drpdown);
		         js.executeScript("arguments[0].click();", drpdown);	
				driver.findElement(By.xpath("//span[text()='Public']")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//button[text()='Save'])[2]")).click();
				Thread.sleep(2000);
				String accountName = driver.findElement(By.xpath("//slot[@name='primaryField']/lightning-formatted-text")).getText();
		        System.out.println("Account name:" +accountName);
		        if (accountName.contains("Evelyn Sweeta Tellus")) {
		   	        System.out.println("ACCOUNT NAME IS SAME AS EXEPETED");
		   	    } else {
		   	    System.out.println("ACCOUNT NAME IS DIFFERENT");
		   	}
			}
}
