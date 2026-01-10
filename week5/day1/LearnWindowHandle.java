package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class LearnWindowHandle {

	public static void main(String[] args) {
		 //configure chrome option
		ChromeOptions option=new ChromeOptions();
		option.addArguments("guest");
		// Initialize ChromeDriver
		ChromeDriver driver=new ChromeDriver(option);
		// Load the URL
		driver.get("https://leafground.com/window.xhtml");
		// Maximize the browser window
		driver.manage().window().maximize();
	       // Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//get address of current window
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		//address of child window
		Set<String> childWindow = driver.getWindowHandles();
		//convert set to list
		List<String> listWindow=new ArrayList<String>(childWindow);
		//navigate to child window
		driver.switchTo().window(listWindow.get(1));
		//address of child
		String chWindow = driver.getWindowHandle();
		System.out.println(chWindow);
		System.out.println(driver.getTitle());
		//close the child window -that is currenly opened
		driver.close();
		//close all the window
		driver.quit();
	}

}
