package commonintegration;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class BaseClass {
	public RemoteWebDriver driver;
	public String excelsheet;
	
	
	@DataProvider(name="takeData")
	 public String[][] sendData() throws IOException {
         return ReadExcelIntegration.ExcelData(excelsheet);
	 }

	@Parameters({"browser","url","username","password"})
	@BeforeMethod
	public void preCondns(String browser,String url, String username, String password) {
		 if (browser.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@AfterMethod
	public void postCondns() {
		driver.close();
	}

}
