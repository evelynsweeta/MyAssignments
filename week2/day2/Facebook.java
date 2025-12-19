package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Facebook {

	public static void main(String[] args) {
		//configure chrome option
		ChromeOptions option=new ChromeOptions();
		option.addArguments("guest");
		// Initialize ChromeDriver
		ChromeDriver driver=new ChromeDriver(option);
		// Load the URL
		driver.get("https://en-gb.facebook.com/");
		// Maximize the browser window
		driver.manage().window().maximize();
		// Add implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //Click on the Create new account button
        driver.findElement(By.xpath("//a[contains(@class,'selected _51sy')]")).click();
        //Enter the First name
        driver.findElement(By.name("firstname")).sendKeys("Raymond");
        //Enter the Surname
        driver.findElement(By.name("lastname")).sendKeys("Jose");
        //Enter the Mobile number or email address.
        driver.findElement(By.xpath("//input[contains(@name,'email')]")).sendKeys("xyz@gmail.com");
        //Enter the New password
        driver.findElement(By.id("password_step_input")).sendKeys("Password1234");
        //Handle all three dropdowns in Date of birth-10-Jun-1999
        WebElement dob=driver.findElement(By.id("day"));
        Select seldob=new Select(dob);
        seldob.selectByIndex(9);
        WebElement month=driver.findElement(By.id("month"));
        Select selmonth=new Select(month);
        selmonth.selectByValue("6");
        WebElement year=driver.findElement(By.id("year"));
        Select selyear=new Select(year);
        selyear.selectByVisibleText("1999");
        //Select the radio button in Gender. 
        driver.findElement(By.xpath("(//input[@id='sex'])[2]")).click();
	}

}
