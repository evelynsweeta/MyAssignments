package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Practice1 {

	public static void main(String[] args) throws InterruptedException {
		//Fill a Form
		ChromeOptions option=new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://demoqa.com/text-box");
        Thread.sleep(5000);
		driver.manage().window().maximize();
		driver.findElement(By.id("userName")).sendKeys("NewUser");
		driver.findElement(By.id("userEmail")).sendKeys("newuser96@gmail.com");
		driver.findElement(By.id("currentAddress")).sendKeys("currentAddress is this");
		driver.findElement(By.linkText("Submit")).click();
		//driver.close();

	}

}
