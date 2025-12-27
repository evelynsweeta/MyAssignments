package week3.day2.inheritanceassignment;

public class Chrome extends Browser{
	public void openIncognito() {
		System.out.println("OPEN IN INCOG---->sub class 1");	
	}
	public void clearCache() {
		System.out.println("Clear Cache---->sub class 1");		
	}
	public static void main(String[] args) {
		Chrome c=new Chrome();
		c.openURL();
		c.openIncognito();
		c.clearCache();
		c.closeBrowser();
		c.navigateBack();
	}

}
