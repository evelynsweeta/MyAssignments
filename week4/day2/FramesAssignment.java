package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FramesAssignment {

	public static void main(String[] args) {
		//configure chrome option
		ChromeOptions option=new ChromeOptions();
		option.addArguments("guest");
		// Initialize ChromeDriver
		ChromeDriver driver=new ChromeDriver(option);
		// Load the URL
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		// Maximize the browser window
		driver.manage().window().maximize();
		// Switch to the frame
        driver.switchTo().frame("iframeResult");
	       // Add implicit wait
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
         //Click the "Try It" button inside the frame 
         driver.findElement(By.xpath("//button[text()='Try it']")).click();
         //Click OK/Cancel in the alert that appears 
         Alert alert1 = driver.switchTo().alert();
         alert1.dismiss();
         //Confirm the action is performed correctly by verifying the text displayed 
         String text = driver.findElement(By.id("demo")).getText();
         if (text.contains("OK")) {
			System.out.println(text);
		 } else {
            System.out.println(text);
		}
	}

}
