package week3.day1;

public class Palindrome {

	public static void main(String[] args) {
		String test= "MALAYALAM"; 
		String test2= ""; 
		    for (int i = test.length()-1; i >=0; i--) {
		    	test2=test2+test.charAt(i);

			}
		    System.out.println(test2);
		    if (test.equals(test2)) {
				System.out.println("String is palindrome");
			} else {
				System.out.println("String is not a palindrome");
			}
	}

}
