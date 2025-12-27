//Given a string s consisting of words and spaces, return the length of the last word in the string.
//A word is a maximal substring consisting of non-space characters only.

package javachallenges;

public class JavaChallenge1 {

	public static void main(String[] args) {
		String str="Welcome to learn automation in Testleaf";
		String[] words = str.split(" ");
		System.out.println(words[words.length-1].length());

	}

}
