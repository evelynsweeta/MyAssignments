package week3.day1;

public class ReverseString1 {

	public static void main(String[] args) {
		String test= "test"; 
		String test2= ""; 
		    for (int i = test.length()-1; i >=0; i--) {
		    	test2=test2+test.charAt(i);

			}
		    System.out.println(test2);	

	}

}
