package marathon1;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SecondMarathonTc {

	public static void main(String[] args) throws InterruptedException {
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
		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	            //Type "Bags for boys" in the Search box
		        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Bags for boys");
			   //Choose the item in the result (bags for boys)
		        driver.findElement(By.xpath("(//div[text()='bags for boys'])[1]")).click();
			   //Print the total number of results (like 50000), example like this-----> 1-48 of over 50,000 results for "bags for boys"
		        String totalResult = driver.findElement(By.xpath("//h2[@class='a-size-base a-spacing-small a-spacing-top-small a-text-normal']")).getText();
		        String[] CountofRecords = totalResult.split(" ");
		        System.out.println("Total number of results:" +CountofRecords[3]);		 
		        Thread.sleep(2000);
			   //Select the first 2 brands in the left menu(like American Tourister, Generic)
		        driver.findElement(By.xpath("(//div[contains(@class,'s-navigation-checkbox aok-float-left')])[3]")).click();
		        Thread.sleep(1500);
		        driver.findElement(By.xpath("(//div[contains(@class,'s-navigation-checkbox aok-float-left')])[2]")).click();
		        Thread.sleep(1000);
			   //Choose New Arrivals (Sort)
		        driver.findElement(By.xpath("//span[text()='Last 30 days']")).click();
		        Thread.sleep(1000);
		        //get the brand name of the 1st resulting bag
		        String brandName = driver.findElement(By.xpath("(//span[contains(@class,'base-plus a-color-base')])[1]")).getText();
		        System.out.println("First resulting bag brand name:" +brandName);
		        //get product name of the 1st resulting bag
		        String productname=driver.findElement(By.xpath("(//a[@class='a-link-normal s-line-clamp-2 s-line-clamp-3-for-col-12 s-link-style a-text-normal'])[1]")).getText();
			    System.out.println("First resulting bag product name:" +productname);
			   //get price of the 1st resulting bag
		        String productprice=driver.findElement(By.xpath("(//span[@class='a-price'])[1]")).getText();
			    System.out.println("First resulting bag product price:" +productprice);
			   //Get the page title and close the browser(driver.close())
			    System.out.println("Title of the page:" +driver.getTitle());
			    driver.close();

	}

}
