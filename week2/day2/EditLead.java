package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) {
		  ChromeOptions option=new ChromeOptions(); 
		  option.addArguments("guest");
		  ChromeDriver driver=new ChromeDriver(option);
		  driver.get("http://leaftaps.com/opentaps/");
		  driver.manage().window().maximize(); 
		  //enter username
		  driver.findElement(By.id("username")).sendKeys("demosalesmanager"); 
		  //enter		  password 
		  driver.findElement(By.id("password")).sendKeys("crmsfa"); 
		  //click  login 
		  driver.findElement(By.className("decorativeSubmit")).click();
		  //Click	  on the "CRM/SFA" link. 
		  driver.findElement(By.partialLinkText("CRM")).click();
		  //Click the "Leads" link 
		  driver.findElement(By.linkText("Leads")).click();
		  //Click on Create Lead
		  driver.findElement(By.linkText("Create Lead")).click();
		  //Enter the CompanyName Field Using Xpath
		  driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Company Name");
		  //Enter the FirstName Field Using Xpath
		  driver.findElement(By.xpath("//input[contains(@id,'firstName')]")).sendKeys("First Name");
		  //Enter the LastName Field Using Xpath.
		  driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Last Name");
		  //Enter the FirstName (Local) Field Using Xpath.
		  driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Local Firstname");
		  //Enter the Department Field Using any Locator of Your Choice.
		  driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Department");
		  //Enter the Description Field Using any Locator of your choice.
		  driver.findElement(By.name("description")).sendKeys("Description 12333");
		  //Enter your email in the E-mail address Field using the locator of your choice.
		  driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("xyz@gmail.com");
		  //Select State/Province as NewYork Using Visible Text.
          WebElement State=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
          Select selstate=new Select(State);
          selstate.selectByVisibleText("New York");
          //Click on the Create Button
          driver.findElement(By.name("submitButton")).click();
          //Click on the edit button
          driver.findElement(By.linkText("Edit")).click();
          //Clear the Description Field.
          driver.findElement(By.name("description")).clear();
          //Fill the Important Note Field with Any text
          driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Important Notes ABCD EFGHIJK");
          //Click on the update button
          driver.findElement(By.name("submitButton")).click();
          //Get the Title of the Resulting Page
          System.out.println(driver.getTitle());
          driver.close();        

	}

}
