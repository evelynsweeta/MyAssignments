package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class LearDraggable {

	public static void main(String[] args) {
		//configure chrome option
				ChromeOptions option=new ChromeOptions();
				option.addArguments("guest");
				// Initialize ChromeDriver
				ChromeDriver driver=new ChromeDriver(option);
				// Load the URL
				driver.get("https://jqueryui.com/draggable/");
				// Maximize the browser window
				driver.manage().window().maximize();
			       // Add implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.switchTo().frame(0);
				WebElement drag = driver.findElement(By.id("draggable"));
				Actions act=new Actions(driver);
				act.dragAndDropBy(drag, 50, 70).perform();

	}

}
