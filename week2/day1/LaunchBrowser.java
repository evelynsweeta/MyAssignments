package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) {
		// Instantiate(calling by an object) the chrome drive and import the libraries if 
        ChromeDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();  
        System.out.println(driver.getTitle());
        driver.close();
	}

}
