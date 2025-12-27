package week3.day2.inheritanceassignment;

public class Browser{
	String browserName;
    String browserVersion;
    
    public void openURL() {
        browserName = "Browser A";
        browserVersion = "1.0";
        System.out.println("Browser Name from super class ----> " + browserName);
        System.out.println("Browser Version from super class ----> " + browserVersion);
        System.out.println("openURL ----> super class");
    }
	public void closeBrowser() {
		System.out.println("CloseBrowser---->super class");
	}
	public void navigateBack() {
		System.out.println("navigateBack---->super class");
	}
}

