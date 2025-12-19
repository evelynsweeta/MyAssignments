package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
         ChromeOptions option=new ChromeOptions();
         option.addArguments("guest");
         ChromeDriver driver=new ChromeDriver(option);
         driver.get("http://leaftaps.com/opentaps/");
         driver.manage().window().maximize();
         //enter username
         driver.findElement(By.id("username")).sendKeys("demosalesmanager");
         //enter password
         driver.findElement(By.id("password")).sendKeys("crmsfa");
         //click login
         driver.findElement(By.className("decorativeSubmit")).click(); 
         //Click on the "CRM/SFA" link. 
         driver.findElement(By.partialLinkText("CRM")).click();
         //Click on the "Accounts" tab
         driver.findElement(By.linkText("Accounts")).click();
         //Click on the "Create Account" button
         driver.findElement(By.linkText("Create Account")).click();
         //Enter an account name
         driver.findElement(By.id("accountName")).sendKeys("First Assignment");
         //Enter a description as "Selenium Automation Tester."
         driver.findElement(By.name("description")).sendKeys("Selenium Automation Tester.");
         //Select "ComputerSoftware" as the industry-1st locate the field
         WebElement industry=driver.findElement(By.name("industryEnumId"));
         //Select "ComputerSoftware" as the industry-select class
         Select selindustry=new Select(industry);
         selindustry.selectByIndex(3);
         //Select "S-Corporation" as ownership using SelectByVisibleText
         WebElement ownership=driver.findElement(By.name("ownershipEnumId"));
         Select selownership=new Select(ownership);
         selownership.selectByVisibleText("S-Corporation");
         //Select "Employee" as the source using SelectByValue
         WebElement source=driver.findElement(By.id("dataSourceId"));
         Select selsource=new Select(source);
         selsource.selectByValue("LEAD_EMPLOYEE");
         //Select "eCommerce Site Internal Campaign" as the marketing campaign using SelectByIndex
         WebElement marketcam=driver.findElement(By.id("marketingCampaignId"));
         Select selmarketcam=new Select(marketcam);
         selmarketcam.selectByIndex(6);
         //Select "Texas" as the state/province using SelectByValue
         WebElement state=driver.findElement(By.id("generalStateProvinceGeoId"));
         Select selstate=new Select(state);
         selstate.selectByValue("TX");
         //Click the "Create Account" button
         driver.findElement(By.className("smallSubmit")).click();
         //Close the browser window. 
        driver.close();
         
         		
        
	}

}
