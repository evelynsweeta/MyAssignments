package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class LearnDroppable {

	public static void main(String[] args) {
		//configure chrome option
		ChromeOptions option=new ChromeOptions();
		option.addArguments("guest");
		// Initialize ChromeDriver
		ChromeDriver driver=new ChromeDriver(option);
		// Load the URL
		driver.get("https://jqueryui.com/droppable/");
		// Maximize the browser window
		driver.manage().window().maximize();
	       // Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//handle frame using index
		driver.switchTo().frame(0);
		//locate the element
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		//instantiate the action class
		Actions act=new Actions(driver);
		act.dragAndDrop(drag, drop).perform();

	}

}
