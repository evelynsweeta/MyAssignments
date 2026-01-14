package marathon2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Tatacliq {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("guest");
		ChromeDriver driver=new ChromeDriver(option);
		//Load the url as https://www.tatacliq.com/
		driver.get("https://www.tatacliq.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//button[@id='moe-dontallow_button']")).click();
		//MouseHover on 'Brands'
		WebElement brand = driver.findElement(By.xpath("(//div[@class='DesktopHeader__categoryAndBrand'])[2]"));
		Actions action=new Actions(driver);
		action.moveToElement(brand).perform();
		//MouseHover on 'Watches & Accessories'
		WebElement watches = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		action.moveToElement(watches).perform();
		//Choose the first option from the 'Featured brands'.		
		WebElement firstOption = driver.findElement(By.xpath("//div[text()='Casio']"));
		action.moveToElement(firstOption).click().perform();
		//Select sortby: New Arrivals
		WebElement sortByField = driver.findElement(By.xpath("//select[@class='SelectBoxDesktop__hideSelect']"));
		Select sel = new Select(sortByField);
		sel.selectByVisibleText("New Arrivals");
		//choose men from catagories filter.
		driver.findElement(By.xpath("(//div[text()='Men'])[1]/preceding-sibling::div")).click();
		Thread.sleep(3000);
		//print all price of watches
		List<WebElement> allPrice = driver.findElements(By.xpath("//div[@class='ProductDescription__priceHolder']/h3"));
		List<String> list=new ArrayList<String>();
		for (WebElement p : allPrice) {
			String list1 = p.getText();
			String price = list1.replaceAll("[^0-9]", "");
			list.add(price);			
		  }
		System.out.println("All Price of watches: " +list);
		//click on the first resulting watch.
		Thread.sleep(3000);
		WebElement firstWatch = driver.findElement(By.xpath("(//h2[contains(@class,'ProductDescription')])[1]"));
		//action.scrollToElement(firstWatch).click().perform(); not working
		((JavascriptExecutor) driver)
        .executeScript("arguments[0].click();", firstWatch);

		//compare two price are similar
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
		List<String> windowList=new ArrayList<String>(windows);
		driver.switchTo().window(windowList.get(1));
		String watchPrice = driver.findElement(By.xpath("//div[@class='ProductDetailsMainCard__price']")).getText().replaceAll("[^0-9]", "");
		System.out.println("Price of the selected watch: " +watchPrice);
		
		String firstPriceList = list.get(0);
		if (watchPrice.equalsIgnoreCase(firstPriceList)) {
			System.out.println("Both price are similar");
		}
		else {
			System.out.println("Price differs");
		}
		//click Add to cart
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[contains(@class,'buttonAddToBag')])[2]")).click();
		//get count from the cart icon
		Thread.sleep(1000);
		String count = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']")).getText();
		System.out.println("Count from the card icon:" +count);
		//Click on the cart
		driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']/parent::div")).click();
		//Take a snap of the resulting page.
		Thread.sleep(3000);
		File cardScreenshot = driver.findElement(By.xpath("//div[@class='CartPage__pageCenter']")).getScreenshotAs(OutputType.FILE);
		File savePath= new File("./screenshots/CardScreenshot.png");
		FileUtils.copyFile(cardScreenshot, savePath);
		//Close All the opened windows one by one.
		driver.close();
		driver.switchTo().window(windowList.get(0));
		driver.close();
	}

}
