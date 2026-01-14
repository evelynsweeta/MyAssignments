package week6.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
	

	public class DynamicParameterizationTest extends DynamicBaseClass {
			
	@Test(dataProvider="takeData")
	public  void dataFromProv(String membername) throws InterruptedException {
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
	        //Enter Name as 'Salesforce Automation by *Your Name*'(Parameterized value) 
	        driver.findElement(By.xpath("(//input[@class='slds-input'])[2]")).sendKeys("Salesforce Automation by " + membername);			         
	        //Click on Save 
	        driver.findElement(By.xpath("//button[text()='Save']")).click();
	        //Verify Legal Entity Name  
	        String legalEntityName = driver.findElement(By.xpath("//slot[@name='primaryField']//lightning-formatted-text")).getText();
	        System.out.println("Actual legal entity name displayed:" +legalEntityName);
	        String expectedText = "Salesforce Automation by " + membername;
	        if (legalEntityName.contains(expectedText)) {
	   	        System.out.println("ENTITY NAME IS SAME AS EXEPETED");
	   	    } else {
	   	    System.out.println("ENTITY NAME IS DIFFERENT");
	   	}
	    //close browser
	    driver.close();
	}
	@DataProvider(name="takeData")
	public String[][] sendData() {
		 return new String[][] {
		        {"Reshma"},
		        {"Mithun"},
		        {"Rena"},
		        {"Laya"}
		    };
		}


}


