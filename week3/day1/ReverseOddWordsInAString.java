package week3.day1;

public class ReverseOddWordsInAString {

	public static void main(String[] args) {
		String test = "I am a software tester";
		//Split the words 
		String[] split1 = test.split(" ");
		for (int i = 0; i<split1.length ; i++) {
			//Find the odd index within the loop
			if(i%2!=0) {
				//Convert the String array into a character array
				char[] charArray = split1[i].toCharArray();
				for (int j = charArray.length - 1; j >= 0; j--) {
                    System.out.print(charArray[j]);
                }
                System.out.print(" ");
                
			}
			else {
				System.out.print(split1[i] + " ");
			}
		}
		
	}

}
