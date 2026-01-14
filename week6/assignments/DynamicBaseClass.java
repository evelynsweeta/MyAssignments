package week6.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class DynamicBaseClass {
	
	public ChromeDriver driver;
	
	/*
	 * This is the base method with login details
	 */
@Parameters({"url","username","password"})
@BeforeMethod
	public  void baseMethod(String url,String username,String password) throws InterruptedException {
		//configure chrome option
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=C:\\EmptyFile");
		// Initialize ChromeDriver
		 driver=new ChromeDriver(options);
		// Load the URL
		driver.get(url);
		// Maximize the browser window
		driver.manage().window().maximize();
	       // Add implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //enter username
        driver.findElement(By.id("username")).sendKeys(username);
         //enter password
         driver.findElement(By.id("password")).sendKeys(password);
         //click login
         driver.findElement(By.id("Login")).click();
}
}