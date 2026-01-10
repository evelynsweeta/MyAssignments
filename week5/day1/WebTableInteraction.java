package week5.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebTableInteraction {

	public static void main(String[] args) throws InterruptedException {
        //configure chrome option
		ChromeOptions option=new ChromeOptions();
		option.addArguments("guest");
		// Initialize ChromeDriver
		ChromeDriver driver=new ChromeDriver(option);
		// Load the URL
		driver.get("https://erail.in/");
		// Maximize the browser window
		driver.manage().window().maximize();
	       // Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement from=driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("MAS");
		driver.findElement(By.xpath("//div[text()='Mgr Chennai Ctr']")).click();
		WebElement to = driver.findElement(By.id("txtStationTo"));
		to.clear();
		to.sendKeys("MDU");
		driver.findElement(By.xpath("//div[text()='Madurai Jn']")).click();
		Thread.sleep(2000);
		WebElement checkboxx = driver.findElement(By.id("chkSelectDateOnly"));
		if (checkboxx.isSelected()) {
			checkboxx.click();
		}
		//Retrieve the train names from the web table
		List<WebElement> train = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader stickyTrainListHeader']/tbody/tr/td[2]"));
		for (WebElement trainNames : train) {
			String trainNam = trainNames.getText();
			System.out.println(trainNam);
		}
	}

}

