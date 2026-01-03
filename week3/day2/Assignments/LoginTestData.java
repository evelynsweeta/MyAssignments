package week3.day2.Assignments;

public class LoginTestData extends TestData {
	public void enterUsername() {
        System.out.println("Enter the username from sub class method 1");
    }
	public void enterPassword() {
        System.out.println("Enter the password from sub class method 2");
    }
	public static void main(String[] args) {
		LoginTestData lt=new LoginTestData();
		lt.enterUsername();
		lt.enterPassword();
		lt.enterCredentials();
		lt.navigateToHomePage();
	}
}
