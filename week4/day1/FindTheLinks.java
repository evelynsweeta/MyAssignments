package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindTheLinks {

	public static void main(String[] args) {
		ChromeDriver driver=new ChromeDriver();
		//load the url
		driver.get("https://www.facebook.com/");
		//maximize
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//find the links
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println(allLinks.size());
		
		WebElement name = allLinks.get(4);
		System.out.println(name.getText());
		//for each loop
		List<String> list=new ArrayList<String>();
		for (WebElement each : allLinks) {
			String text = each.getText();
			//System.out.println(text);
			list.add(text);
		}
		
		System.out.println(list);
	

	}

}