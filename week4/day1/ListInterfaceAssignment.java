package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ListInterfaceAssignment {

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
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Phone",Keys.ENTER);
		        //driver.findElement(By.id("nav-search-submit-button")).click();
		        List<WebElement> price = driver.findElements(By.className("a-price-whole"));
				//for each loop
				List<String> phonelist=new ArrayList<String>();
				for (WebElement each : price) {
					String text = each.getText();
					phonelist.add(text);
				}
				
				System.out.println(phonelist);

	}

}
