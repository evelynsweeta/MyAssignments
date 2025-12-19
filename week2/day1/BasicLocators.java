package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicLocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();  
        //enter username
        driver.findElement(By.id("email")).sendKeys("testleaf.2023@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("Tuna@321");
        driver.findElement(By.name("login")).click();
        System.out.println(driver.getTitle());

	}

}
