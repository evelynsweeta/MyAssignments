package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;

public class UsingActionsClass {

	public static void main(String[] args) throws IOException, InterruptedException {
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
		//Search for "oneplus 9 pro"
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		Actions action = new Actions(driver);
		action.moveToElement(search).click().sendKeys("oneplus 9 pro").sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		//Get the price of the first product
		String firstProductPrice = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]//span[@class='a-price-whole']")).getText();
		System.out.println("First product price: " + firstProductPrice);
		//Print the number of customer ratings for the first displayed product.
		String custRating = driver.findElement(By.xpath("(//span[@class='a-size-small a-color-base'])[1]")).getText();
		System.out.println("Customer Rating for the first product:" +custRating);
		//Click the first text link of the first image.
		WebElement firstTextLink = driver.findElement(By.xpath("(//h2[contains(@class,'a-color-base a-text-normal')])[1]"));
		action.moveToElement(firstTextLink).click().perform();
		Thread.sleep(2000);
		//switch the newly opened window
		Set<String> windows = driver.getWindowHandles();
		List<String> windowsList=new ArrayList<String>(windows);
		driver.switchTo().window(windowsList.get(1));
		/*Take a screenshot of the product displayed.
		1.Wait until main product image is visible
		2.locate the element
		3.take screenshot
		4.save screenshot
		*/
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement product = wait.until(
		        ExpectedConditions.visibilityOfElementLocated(By.id("landingImage")));
		File src=product.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/product.png");
        FileUtils.copyFile(src, dest);
        // Confirm the screenshot
        System.out.println("Screenshot saved at: " + dest.getAbsolutePath());
        //Click the 'Add to Cart' button
        driver.findElement(By.id("add-to-cart-button")).click();
        // Get the cart subtotal and verify if it is correct
        String cardProduct = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
        System.out.println("Card Subtotal is:" +cardProduct);
        if (firstProductPrice.equals(cardProduct)){
            System.out.println("Price verification PASSED");
        } else {
            System.out.println("Price verification FAILED");
        }
        //close browsers
        driver.quit();


	}

}
