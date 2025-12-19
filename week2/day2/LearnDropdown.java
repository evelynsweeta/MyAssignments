package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class LearnDropdown {

	public static void main(String[] args) {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver=new ChromeDriver(option);
        driver.get("http://leaftaps.com/opentaps/");
        driver.manage().window().maximize();  
        driver.findElement(By.id("username")).sendKeys("demosalesmanager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
        driver.findElement(By.className("decorativeSubmit")).click();
        driver.findElement(By.partialLinkText("CRM")).click();
        driver.findElement(By.linkText("Leads")).click();
        driver.findElement(By.linkText("Create Lead")).click();
        driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Evelyn");
		//last name
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Sweeta");
		//lOCATE THE source field
		WebElement sourceDD = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select sel=new Select(sourceDD);
		sel.selectByIndex(4);
		WebElement sourceDD1 = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		//instantiate the select class
		Select sel1=new Select(sourceDD1);
		sel1.selectByVisibleText("Automobile");
		WebElement sourceDD2 = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		//instantiate the select class
		Select sel2=new Select(sourceDD2);
		sel2.selectByValue("OWN_CCORP");
		driver.findElement(By.name("submitButton")).click();
        System.out.println(driver.getTitle());
        driver.close();
	}
	}
