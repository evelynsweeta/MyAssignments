package Marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstMarathonTc {

	public static void main(String[] args) throws InterruptedException {
		 //configure chrome option
		ChromeOptions option=new ChromeOptions();
		option.addArguments("guest");
		// Initialize ChromeDriver
		ChromeDriver driver=new ChromeDriver(option);
		// Load the URL
		driver.get("https://www.pvrcinemas.com/");
		// Maximize the browser window
		driver.manage().window().maximize();
	       // Add implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Choose Your location as "Chennai" (sometimes it will be located automatically)
        driver.findElement(By.xpath("//input[contains(@class,'autocomplete-input')]")).sendKeys("Chennai");
        driver.findElement(By.xpath("//li[text()='Chennai']")).click();
        //Click on Cinema under Quick Book
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[text()='Cinema']")).click();
        //Select Your Cinema
        driver.findElement(By.xpath("//span[text()='Select Cinema']")).click();
        driver.findElement(By.xpath("//span[text()='INOX National,Virugambakkam Chennai']")).click();
		//Select Your Date as Tomorrow
        driver.findElement(By.xpath("//span[contains(text(),'Tomorrow')]")).click();
		//Select Your Movie
        Thread.sleep(2000);
        driver.findElement(By.xpath("//li[contains(@class,'p-dropdown-item')][1]/span[1]")).click();
        //Select Your Show Time
        driver.findElement(By.xpath("//span[text()='08:15 PM']")).click();    
		//Click on Book Button
        driver.findElement(By.xpath("//button[@class='p-button p-component sc-hjsuWn kDwaXw bgColor filter-btn']/span")).click();  
		//Click Accept on Term and Condition
        driver.findElement(By.xpath("//button[text()='Accept']")).click();
		//Click any one available seat
        driver.findElement(By.id("SL.SILVER|D:16")).click();
		//Print the Seat info under book summary
        String selectedSeat=driver.findElement(By.xpath("//div[@class='seat-number']")).getText();
        System.out.println("Selected seat:" +selectedSeat);
		//Print the grand total under book summary
        String grandTotal=driver.findElement(By.xpath("//div[@class='grand-prices']")).getText();
        System.out.println("Total Amount:" +grandTotal);        
		//Click Proceed and Continue Button
        driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		//Close the popup 
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//i[@class='pi pi-times'])[2]")).click();
		//Print Your Current Page title
        System.out.println(driver.getTitle());
		//Close Browser
        driver.close();

	}

}
