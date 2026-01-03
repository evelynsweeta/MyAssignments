package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class myntra {

	public static void main(String[] args) throws InterruptedException {
		        //configure chrome option
				ChromeOptions option=new ChromeOptions();
				option.addArguments("guest");
				// Initialize ChromeDriver
				ChromeDriver driver=new ChromeDriver(option);
				// Load the URL
				driver.get("https://www.myntra.com/-");
				// Maximize the browser window
				driver.manage().window().maximize();
			       // Add implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				//In the search box, type as "bags" and press enter 
				driver.findElement(By.xpath("//input[@class='index-inputBox']")).sendKeys("Bags", Keys.ENTER);
				//To the left of the screen under "Gender" click on "Men" 
				driver.findElement(By.xpath("//label[text()='Men']")).click();
				Thread.sleep(1000);
				//click laptop bags
				driver.findElement(By.xpath("//label[text()='Laptop Bag']")).click();
				Thread.sleep(2000);
				//Print the count of the items found-located the field and gathered the text
				//using replaceall took the number counts alone
				String result = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
				String count = result.replaceAll("[^0-9]", "");
				System.out.println("Total number of bags: " +count); 
				/*Get the list of brand of the products displayed in the page and print the list
				*1.Storing webelements in the list webelement.
				*2.created an empty list
				*3.using for each iterating and using getText extracted the text inside the element
				*4.Adding each text to the list
				*/
				List<WebElement> productbrand = driver.findElements(By.xpath("//h3[@class='product-brand']"));
				List<String> brandNames = new ArrayList<String>();
				for (WebElement value : productbrand) {
					String brand = value.getText();
					brandNames.add(brand);
					
				}
				//print the brand list
System.out.println("Brand List" +brandNames);
/*Get the list of names of the bags and print it 
*1.Storing webelements in the list webelement.
*2.created an empty list
*3.using for each iterating and using getText extracted the text inside the element
*4.Adding each text to the list
*/
List<WebElement> product = driver.findElements(By.xpath("//h4[@class='product-product']"));
List<String> productNames=new ArrayList<String>();
for (WebElement proNames : product) {
	String proNames1 = proNames.getText();
	productNames.add(proNames1);
}
System.out.println("List of bag name:" +productNames);
	}

}
