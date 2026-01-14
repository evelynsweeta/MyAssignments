package commonintegration;


import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class CreateLeadIntegration extends BaseClass {
	@BeforeTest
	public void excelsheets() {
		excelsheet="CreateLeadData";
	}

	@Test(dataProvider="takeData")
	public  void runCL(String cname,String fname, String lname) {	
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
		driver.findElement(By.name("submitButton")).click();
		
}
	
}






