package week5.day1;

import java.io.File;
import java.io.IOException;
import java.sql.DriverAction;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class ActionsSnapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		        //configure chrome option
				ChromeOptions option=new ChromeOptions();
				option.addArguments("guest");
				// Initialize ChromeDriver
				ChromeDriver driver=new ChromeDriver(option);
				// Load the URL
				driver.get("https://www.snapdeal.com/");
				// Maximize the browser window
				driver.manage().window().maximize();
			       // Add implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				//Go to "Men's Fashion"
				driver.findElement(By.xpath("//div[normalize-space(.)=\"Men's Fashion\"]")).click();
				//Go to "Sports Shoes"
				Thread.sleep(1000);
				WebElement sportsShoes = driver.findElement(By.xpath("//div[text()='Sports Shoes']"));
				Actions action=new Actions(driver);
				action.moveToElement(sportsShoes).click().perform();
				//Get the count of sports shoes.
				String count = driver.findElement(By.xpath("//span[contains(@class,'category-count')]")).getText();
				String[] shoesCount = count.split(" ");
				System.out.println("Count of sports shoes:" +shoesCount[1]);
				//Click on "Training Shoes
				WebElement trainingShoes = driver.findElement(By.xpath("//div[text()='Training Shoes']"));
				action.moveToElement(trainingShoes).click().perform();
				//Sort the products by "Low to High"				
				driver.findElement(By.xpath("//div[contains(text(),'Popularity')]")).click();
				WebElement sort = driver.findElement(By.xpath("//li[normalize-space(.)='Price Low To High']"));
				action.moveToElement(sort).click().perform();
				//Check if the displayed items are sorted correctly
				Thread.sleep(2000);
				List<WebElement> priceList = driver.findElements(By.xpath("//span[contains(@class,'product-price')]"));
				List<Integer> actualList=new ArrayList<Integer>();
				for (WebElement pri : priceList) {
					String text = pri.getText();
					String text1 = text.replaceAll("[^0-9]", "");				
					actualList.add(Integer.parseInt(text1));
				}
				System.out.println("Sorted List of price:" +actualList);
				// Copy list
				List<Integer> expectedList = new ArrayList<>(actualList);
				Collections.sort(expectedList);
				System.out.println("Expected sort order:" +expectedList);
				if (actualList.equals(expectedList)) {
				    System.out.println("Items are sorted from Low to High");
				} else {
				    System.out.println("Items are not sorted from Low to High");
				}
				//Select any price range ex:(500-800).
				WebElement minPrice = driver.findElement(By.xpath("(//input[@class='input-filter'])[1]"));
				minPrice.clear();
				minPrice.sendKeys("510",Keys.ENTER);
				WebElement maxPrice = driver.findElement(By.xpath("(//input[@class='input-filter'])[2]"));
				maxPrice.clear();
				maxPrice.sendKeys("1000",Keys.ENTER);
				String fieldMinValue = minPrice.getDomProperty("value");
				String fieldMaxValue = maxPrice.getDomProperty("value");
				if ("510".equals(fieldMinValue) && "1000".equals(fieldMaxValue)) {
				    System.out.println("Price Range filter applied.");
				} else {
				    System.out.println("Price Range filter not applied.");
				}
				// Filter by any colour
				Thread.sleep(2000);
				WebElement colour = driver.findElement(By.xpath("//a[contains(text(),'White & Blue')]"));
				action.moveToElement(colour).click().perform();
				WebElement appliedColourFilter = driver.findElement(By.xpath("(//a[contains(text(),'White & Blue')])[2]"));
				if (appliedColourFilter.isDisplayed()) {
				    System.out.println("Colour filter 'White & Blue' is applied successfully.");
				} else {
				    System.out.println("Colour filter 'White & Blue' is NOT applied");
				}
				//Mouse hover on the first resulting "Training Shoes".
				WebElement firstPro = driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"));
				action.moveToElement(firstPro).perform();				
				// Click the "Quick View" button. 
				WebElement quickView = driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]"));
				action.moveToElement(quickView).click().perform();
				//Print the cost 
				String cost = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
				String onlyCost = cost.replaceAll("[^0-9]", "");
				System.out.println("Cost of the product selected:" +onlyCost);
				//Print  discount percentage
				String discountPer = driver.findElement(By.xpath("//span[contains(@class,'percent-desc')]")).getText();
				System.out.println("Discount Percentage of the product:" +discountPer);	
				//Take a snapshot of the shoes. 
				Thread.sleep(2000);
				File src=driver.findElement(By.className("cloudzoom")).getScreenshotAs(OutputType.FILE);
				File dest = new File("./screenshots/ShoeSnap.png");
				FileUtils.copyFile(src, dest);
				System.out.println("Snapshot saved at: " + dest.getAbsolutePath());
				//Close the current window. 
				WebElement close = driver.findElement(By.xpath("(//i[contains(@class,'icon-delete-sign')])[4]"));
				close.click();
				//Close the main window. 
				driver.close();
	}

}
