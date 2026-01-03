package week4.day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FrameAndAlertInteractions {

	public static void main(String[] args) {
		//configure chrome option
		ChromeOptions option=new ChromeOptions();
		option.addArguments("guest");
		// Initialize ChromeDriver
		ChromeDriver driver=new ChromeDriver(option);
		// Load the URL
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");
		// Maximize the browser window
		driver.manage().window().maximize();
		// Switch to the frame
		driver.switchTo().frame("iframeResult");
		//add implicit wait
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  //Click the "Try It" button inside the frame
		  driver.findElement(By.xpath("//button[text()='Try it']")).click();
		  //Click OK/Cancel in the alert that appears
		  Alert alert = driver.switchTo().alert();
		  alert.accept();
		  //Confirm the action is performed correctly by verifying the text displayed 
		  String text = driver.findElement(By.id("demo")).getText();
		  if(text.contains("Cancelled")) {
			  System.out.println("User cancelled the prompt");
		  }
		  else {
			  System.out.println("User clicked Ok:" +text);
		  }
	}

}
