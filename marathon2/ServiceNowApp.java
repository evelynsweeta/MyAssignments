package marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import io.github.sukgu.Shadow;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class ServiceNowApp {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver=new ChromeDriver(option);
		//Launch ServiceNow application
		driver.get("https://dev181504.service-now.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Login with valid credentials username as admin and password 
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("F/*jyM6Q6pHh");
		driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		//Click-All Enter Service catalog in filter navigator and press enter or Click the ServiceCatalog
		Shadow sha=new Shadow(driver);
		sha.setImplicitWait(15);
		sha.findElementByXPath("//div[text()='All']").click();
		sha.findElementByXPath("//span[text()='Service Catalog']").click();
		//Click on  mobiles
		WebElement frameA = sha.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frameA);
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
		//Select Apple iphone13pro
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 13 pro']")).click();
		//Choose yes option in lost or broken iPhone
		driver.findElement(By.xpath("//label[text()='Yes']")).click();
		//Enter phonenumber as 99 in original phonenumber field
		driver.findElement(By.xpath("//input[@class='cat_item_option sc-content-pad form-control']")).sendKeys("9998653421");
		//Select Unlimited from the dropdown in Monthly data allowance
		WebElement dropdwn = driver.findElement(By.xpath("//select[@class='form-control cat_item_option ']"));
		Select dpdwn=new Select(dropdwn);
		dpdwn.selectByValue("unlimited");
		//Update color field to SierraBlue and storage field to 512GB
		driver.findElement(By.xpath("//label[text()='Sierra Blue']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//label[contains(text(),'512 GB')]")).click();
		//Click on Order now option
		driver.findElement(By.xpath("//button[text()='Order Now']")).click();
		//Verify order is placed and copy the request number
		String text="Thank you, your request has been submitted";
		String notificationtext = driver.findElement(By.xpath("//div[@class='notification notification-success']")).getText();
		if (notificationtext.contains(text)) {
			System.out.println("Order is placed");
		} else {
			System.out.println("Order NOT placed");
		}
		String requestNumber = driver.findElement(By.xpath("//a[@id='requesturl']")).getText();
		System.out.println("Request Number for your order is :" +requestNumber);
		//Take a Snapshot of order placed page 
		File sourceScreenshot = driver.getScreenshotAs(OutputType.FILE);
		File destScreenshot=new File("./screenshots/ServiceNowSnap.png");
		FileUtils.copyFile(sourceScreenshot, destScreenshot);
		System.out.println("Snapshot is saved here :" +destScreenshot.getAbsolutePath());	

	}

}
