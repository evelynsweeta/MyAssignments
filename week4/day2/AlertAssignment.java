package week4.day2;


import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertAssignment {

	public static void main(String[] args) throws InterruptedException {
		//configure chrome option
		ChromeOptions option=new ChromeOptions();
		option.addArguments("guest");
		// Initialize ChromeDriver
		ChromeDriver driver=new ChromeDriver(option);
		// Load the URL
		driver.get("https://www.leafground.com/alert.xhtml");
		// Maximize the browser window
		driver.manage().window().maximize();
	       // Add implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //Click on the "Prompt Box" button to trigger the alert
        driver.findElement(By.xpath("(//span[text()='Show'])[5]")).click();
        //Switch to the alert and type a message in the alert box
        Alert alertmessage = driver.switchTo().alert();
        alertmessage.sendKeys("NewMessage");
        //Switch to the alert and type a message in the alert box
        alertmessage.accept();
       String result = driver.findElement(By.id("confirm_result")).getText();
       if(result.contains("cancelled ")) {
    	   System.out.println("user has dismissed the alert");
       }
       else
       {
    	   System.out.println("user has submitted the alert");
      }

	}

}
