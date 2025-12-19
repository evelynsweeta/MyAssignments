package week1.day2;

public class Browser 

{
public void launchBrowser(String browserName) 
{
	System.out.println("Browser Name:" +browserName);
}
public String loadUrl() 
{
	return "Url loaded successfully";
}
public static void main(String[] args) {
	Browser b=new Browser();
	b.launchBrowser("Chrome");
	System.out.println(b.loadUrl());
}
}
