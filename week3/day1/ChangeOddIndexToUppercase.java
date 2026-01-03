package week3.day1;

public class ChangeOddIndexToUppercase {

	public static void main(String[] args) {
		 String test = "changeme";
		 char[] charactrArr = test.toCharArray();
		 // Loop from end to start
		 for (int i = charactrArr.length-1; i >=0; i--) {
			 //change the character to uppercase only if the index is odd
			if (i%2!=0) {
				charactrArr[i]=Character.toUpperCase(charactrArr[i]);
			}
			
		}
		 System.out.println(charactrArr);
	}

}
