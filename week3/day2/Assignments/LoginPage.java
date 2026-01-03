package week3.day2.Assignments;

public class LoginPage extends BasePage {
	//method overriding created an method with same name and arguments
	public void performCommonTasks() {
        System.out.println("Method in login page");
    }
	public static void main(String[] args) {
		LoginPage lp=new LoginPage();
		lp.findElement();
		lp.clickElement();
		lp.enterText();
		//overriding method-this will display the message from this class
		lp.performCommonTasks();
	}
}
