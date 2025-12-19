package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		
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
		  //Click "Find leads." 
		  driver.findElement(By.linkText("Find Leads")).click();
		  //Click on the "Phone" tab.		        
		driver.findElement(By.linkText("Phone")).click();
		//Enter the phone number
        driver.findElement(By.name("phoneNumber")).sendKeys("9874563210");
		//Click the "Find leads" button
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        Thread.sleep(5000);
		//Capture the lead ID of the first resulting lead
        WebElement text=driver.findElement(By.xpath("(//div[contains(@class,'partyId')])[2]/a"));
        String text1=text.getText();
        System.out.println(text1);
		//Click the first resulting lead.
        driver.findElement(By.xpath("(//div[contains(@class,'partyId')])[2]/a")).click();
		//Click the "Delete" button.
        driver.findElement(By.linkText("Delete")).click();
		//Click "Find leads" again.
		  driver.findElement(By.linkText("Find Leads")).click();
		//Enter the captured lead ID
	    driver.findElement(By.name("id")).sendKeys(text1);
		//Click the "Find leads" button
        driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
        Thread.sleep(5000);
		//Verify the presence of the message "No records to display" (Locate the message)in the Lead List. This message confirms the successful deletion.
        WebElement message=driver.findElement(By.xpath("//div[contains(text(),'No records')]"));
        //verify message text
        String actualMessage=message.getText();
        System.out.println(actualMessage);
		//Close the browser. 
        driver.close();

	}

}
