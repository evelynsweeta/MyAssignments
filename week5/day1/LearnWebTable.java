package week5.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class LearnWebTable {

	public static void main(String[] args) {
		        //configure chrome option
				ChromeOptions option=new ChromeOptions();
				option.addArguments("guest");
				// Initialize ChromeDriver
				ChromeDriver driver=new ChromeDriver(option);
				// Load the URL
				driver.get("https://leafground.com/table.xhtml");
				// Maximize the browser window
				driver.manage().window().maximize();
			       // Add implicit wait
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				//locate the table
				//WebElement table = driver.findElement(By.xpath("(//table[@role='grid'])[2]/tbody"));
                //to get row count
				List<WebElement> row = driver.findElements(By.xpath("(//table[@role='grid'])[2]/tbody/tr"));
				int size=row.size();
				System.out.println(size);
				//to get column count
				List<WebElement> column = driver.findElements(By.xpath("(//table[@role='grid'])[2]/thead/tr/th"));
				int columnSize=column.size();
				System.out.println(columnSize);
				//particular data
				String text = driver.findElement(By.xpath("(//table[@role='grid'])[2]/tbody/tr[3]/td[2]")).getText();
				System.out.println(text);
				//print entire row
				List<WebElement> singleRow = driver.findElements(By.xpath("(//table[@role='grid'])[2]/tbody/tr[3]"));
				for (WebElement rowIt : singleRow) {
					String rowDetails = rowIt.getText();
					System.out.println(rowDetails);
				}
				//all data
				List<WebElement> allData = driver.findElements(By.xpath("(//table[@role='grid'])[2]/tbody/tr/td"));
				for (WebElement all : allData) {
					String allDatas = all.getText();
					System.out.println(allDatas);
					
				}
				
				//dynamic datas
				for (int i = 1; i < row.size(); i++) {
					driver.findElement(By.xpath("(//table[@role='grid'])[2]/tbody/tr["+i+"]/td"));
					System.out.println("------------------------");
					for (int j = 1; j < column.size(); j++) {
						WebElement dynamicDatas = driver.findElement(By.xpath("(//table[@role='grid'])[2]/tbody/tr["+i+"]/td["+j+"]"));
						System.out.println(dynamicDatas.getText());
						
					}
				}
	
				
	}

}
