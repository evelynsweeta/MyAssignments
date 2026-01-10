package week5.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class FinanceYahoo {

	public static void main(String[] args) throws InterruptedException {
		 //configure chrome option
		ChromeOptions option=new ChromeOptions();
		option.addArguments("guest");
		// Initialize ChromeDriver
		ChromeDriver driver=new ChromeDriver(option);
		// Load the URL
		driver.get("https://finance.yahoo.com/");
		// Maximize the browser window
		driver.manage().window().maximize();
	       // Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//agree the privacy info pop up
		Thread.sleep(1000);
		driver.switchTo().frame("consent-liveRampPopup-popUp");
		driver.findElement(By.xpath("//a[text()='Agree']")).click();
		//mousehover on More button
		driver.switchTo().defaultContent();
		WebElement more = driver.findElement(By.xpath("//span[text()='More']"));
		Actions action=new Actions(driver);
		action.moveToElement(more).perform();
		//Click on “Crypto” tab
		driver.findElement(By.xpath("(//a[contains(text(),'Crypto' )])[3]")).click();
		//Identify the table in the dom using <table> tag
		List<WebElement> table = driver.findElements(By.xpath("//table[@class='yf-1uayyp1 bd']/tbody/tr/td[2]"));
		System.out.println("All cryptocurrency names from table:");
		for (WebElement allData : table) {
			String data = allData.getText();
		     System.out.println(data);
		}

	}

}
