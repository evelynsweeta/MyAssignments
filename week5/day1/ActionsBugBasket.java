package week5.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ActionsBugBasket {

	public static void main(String[] args) throws InterruptedException, IOException {
		//configure chrome option
		ChromeOptions option=new ChromeOptions();
		option.addArguments("guest");
		// Initialize ChromeDriver
		ChromeDriver driver=new ChromeDriver(option);
		// Load the URL
		driver.get("https://www.bigbasket.com/");
		// Maximize the browser window
		driver.manage().window().maximize();
	       // Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Click on "Shop by Category".
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Category'])[2]")).click();
		//Mouse over "Foodgrains, Oil & Masala".
		Thread.sleep(2000);
		WebElement foodGrains=driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
		Actions action=new Actions(driver);
		action.moveToElement(foodGrains).perform();
		//Mouse over "Rice & Rice Products".
		Thread.sleep(2000);
		WebElement riceProduct =driver.findElement(By.xpath("//a[text()='Rice & Rice Products']"));
		action.moveToElement(riceProduct).perform();
		//Click on "Boiled & Steam Rice".
		Thread.sleep(2000);
		WebElement steamRice = driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']"));
		action.moveToElement(steamRice).click().perform();
		//Filter the results by selecting the brand "bb Royal".
		Thread.sleep(2000);
		WebElement bbRoyal = driver.findElement(By.xpath("//label[text()='bb Royal']/preceding-sibling::input"));
		action.moveToElement(bbRoyal).click().perform();
		Thread.sleep(2000);
		WebElement brandFiltered = driver.findElement(By.xpath("(//span[text()='bb Royal'])[1]"));
		if (brandFiltered.isDisplayed()) {
		    System.out.println("bb Royal filter is applied");
		} else {
		    System.out.println("bb Royal filter is not applied.");
		}
		//Click on "Tamil Ponni Boiled Rice".
		Thread.sleep(6000);
		WebElement riceElement = driver.findElement(By.xpath("//h3[text()='Tamil Ponni Boiled Rice']"));
		action.moveToElement(riceElement).click().perform();
		//Select the 5 Kg bag.
		Set<String> childWindow = driver.getWindowHandles();
		List<String> listWindow=new ArrayList<String>(childWindow);
		driver.switchTo().window(listWindow.get(1));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement fiveKg = wait.until(
		    ExpectedConditions.elementToBeClickable(
		        By.xpath("(//span[text()='5 kg'])[1]/following-sibling::span[text()='(12-17 Months Old)']")));
		action.scrollToElement(fiveKg).perform();
		Thread.sleep(2000);
		action.moveToElement(fiveKg).click().perform();
		//Check and note the price of the rice.
		String priceDetails = driver.findElement(By.xpath("(//td[contains(@class,'StyledTd')])")).getText();
		String price = priceDetails.replaceAll("[^0-9]", "");
		System.out.println("Price of 5kg rice is : " +price);
		//Click "Add" to add the bag to your cart.
		driver.findElement(By.xpath("(//button[text()='Add to basket'])[1]")).click();
		//Verify the success message that confirms the item was added to your cart.
		WebElement successMsg = driver.findElement(By.xpath("//*[contains(text(),'An item has been added to your basket successfully')]"));
		if (successMsg.isDisplayed() && successMsg.getText().contains("added to your basket")) {
		    System.out.println("Success message verified.");
		} else {
		    System.out.println("Success message not found.");
		}
		//Take a snapshot of the current page
		Thread.sleep(2000);
		File src=driver.findElement(By.id("confetti-container")).getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/CurrentPageSnap.png");
		FileUtils.copyFile(src, dest);
		System.out.println("Snapshot saved at: " + dest.getAbsolutePath());
		//Close the current window.
		driver.close();
		// Switch back to main window
		driver.switchTo().window(listWindow.get(0));
		//Close the main window.
		driver.close();
	}

}
