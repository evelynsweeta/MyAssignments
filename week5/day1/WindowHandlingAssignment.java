package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandlingAssignment {

	public static void main(String[] args) throws InterruptedException {
		        //configure chrome option
				ChromeOptions option=new ChromeOptions();
				option.addArguments("guest");
				// Initialize ChromeDriver
				ChromeDriver driver=new ChromeDriver(option);
				// Load the URL
				driver.get("http://leaftaps.com/opentaps/control/login");
				// Maximize the browser window
				driver.manage().window().maximize();
			       // Add implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				//enter username
		         driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		         //enter password
		         driver.findElement(By.id("password")).sendKeys("crmsfa");
		         //click login
		         driver.findElement(By.className("decorativeSubmit")).click(); 
		         //Click on the "CRM/SFA" link. 
		         driver.findElement(By.partialLinkText("CRM")).click();
		         //Click on the Contacts button
		         driver.findElement(By.linkText("Contacts")).click();
		         //Click on Merge Contacts
		         driver.findElement(By.linkText("Merge Contacts")).click();
		         //Click on the widget of the "From Contact".
		         driver.findElement(By.xpath("(//table[@class='twoColumnForm']/tbody/tr/td[2]/a)[1]")).click();
		         //1st switch window,Click on the first resulting contact
		         Thread.sleep(1000);
		         Set<String> window1 = driver.getWindowHandles();
		         List<String> windowList=new ArrayList<String>(window1);
		         driver.switchTo().window(windowList.get(1));
		         driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		         // Click on the widget of the "To Contact"
		         Thread.sleep(2000);
		         driver.switchTo().window(windowList.get(0));
		         driver.findElement(By.xpath("(//table[@class='twoColumnForm']/tbody/tr/td[2]/a)[2]")).click();
		         //Click on the second resulting contact.		         
		         Set<String> window2 = driver.getWindowHandles();
		         List<String> windowList2=new ArrayList<String>(window2);
		         driver.switchTo().window(windowList2.get(1));
		         driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();
		         // Click on the Merge button
		         driver.switchTo().window(windowList.get(0));
		         driver.findElement(By.xpath("//table[@class='twoColumnForm']/tbody/tr[4]/td[2]/a")).click();
		         //Accept the alert.
		         Alert alertpopup = driver.switchTo().alert();
		         alertpopup.accept();
		         // Verify the title of the page.
		         Thread.sleep(1000);
		         String actualTitle = driver.getTitle();
		         String expectedTitle = "Merge Contacts | opentaps CRM";
		         System.out.println("Title of the page is: " +actualTitle);
		         if (actualTitle.equals(expectedTitle)) {
		             System.out.println("Title verified");
		         } else {
		             System.out.println("Title not verified");
		         }         

	}

}
