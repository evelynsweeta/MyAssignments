package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class LearnMouseOver {

	public static void main(String[] args) {
        //configure chrome option
		ChromeOptions option=new ChromeOptions();
		option.addArguments("guest");
		// Initialize ChromeDriver
		ChromeDriver driver=new ChromeDriver(option);
		// Load the URL
		driver.get("https://www.amazon.in/");
		// Maximize the browser window
		driver.manage().window().maximize();
	       // Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement mouHover = driver.findElement(By.xpath("//a[text()='Mobiles']"));
		//instiati the action class
		Actions act=new Actions(driver);
		//use objec to call the req method
		act.moveToElement(mouHover).perform();
	}

}
