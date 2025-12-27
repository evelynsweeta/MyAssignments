//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and 
//removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric 
//characters include letters and numbers.
//Given a string s, return true if it is a palindrome, or false otherwise.
package javachallenges;

public class JavaChallenge3 {

	public static void main(String[] args) {
		String phrase = "A man, a plan, a canal: Panama @2025";
		String reversephrase="";
		//retrived the alphabets from the phrase
		String phrasereplaceAll = phrase.replaceAll("[^A-z]","");
		//converted to lower case
		String phraselowercase = phrasereplaceAll.toLowerCase();	
		System.out.println(phraselowercase);
		//reverse the phrase
		 for (int i = phraselowercase.length()-1; i >=0; i--) {
			 reversephrase=reversephrase+phraselowercase.charAt(i);
			}
		 //Check whether the phrase is palindrome or not
		 if (reversephrase.equals(phraselowercase)) {
				System.out.println("String is palindrome");
			} else {
				System.out.println("String is not a palindrome");
			}
	}

}
