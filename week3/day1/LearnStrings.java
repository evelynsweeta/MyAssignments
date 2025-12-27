package week3.day1;

public class LearnStrings {

	public static void main(String[] args) {
		//string literals
		String name="Test leaf";
		String name1="Tes tleaF";
  //string instantiation
		String str=new String("Test Leaf");
		String str1=new String("Test LeaF");
		//count the number of character
		int length=str.length();
		System.out.println(length);
		//concatenation
		System.out.println(5+9);
		System.out.println("5"+"9");
		System.out.println(5+"9");
		String s1="Welcome";
		String s2="to Testleaf";
		String s3="for selenium";
		System.out.println(s1+s2);
		System.out.println(s1.concat(s2));
		System.out.println(s1.concat(s2).concat(s3));
        //compare the values -comparison methods
		//1.equals
		boolean test=str.equals(str1);
		System.out.println(test);
		//2.== method->based on the memory address it will compare
		//literal string compare
		if (name==name1) {
			System.out.println("value matched");
		} else {
         System.out.println("value not matched");
		}
		//instantiation string compare
		if (str==str1) {
			System.out.println("value matched");
		} else {
         System.out.println("value not matched");
		}
		//ignore casesen
		boolean equalsIgnoreCase=str.equalsIgnoreCase(str1);
		System.out.println(equalsIgnoreCase);
		//toCharArray-convert string to char
		char[] charArray = name.toCharArray();
		System.out.println(charArray);
		//iterate the character in the string name
		for (int i = 0; i < charArray.length; i++) {
			System.out.println(charArray[i]);
		}
		//charAt->retrive the value by index
		System.out.println(name.charAt(4));
		System.out.println(name.charAt(3));
   //replace
		String s="Testleaf@123ttest";
		System.out.println(s.replace("e", ""));
		System.out.println(s.replace("e", " "));
		System.out.println(s);
		//lowercase
		System.out.println(s.toLowerCase());
		//uppercase
		System.out.println(s.toUpperCase());
		//replaceAll retrieve any value
	    String replaceAll = s.replaceAll("[^0-9]", "");
	    System.out.println(replaceAll);
	    //replace alphabets
	    String replaceAll1 = s.replaceAll("[^A-z]", "");
	    System.out.println(replaceAll1);
	    //string to integer->to sort the number the string should be converted to integer
	    String st="120";
	    System.out.println(st+10);
	    int int1 = Integer.parseInt(st);
	    System.out.println(int1+10);
	    //integer to string
	    int i=100;
	   System.out.println(i+1);
	   String string1 = Integer.toString(i);
	   System.out.println(string1+1);
	   //split-split teh string to multiple string
	   String str3="Testleaf and Qeagle";//Test---0 index af and Qeag--1 index
	   String[] split = str3.split("le");
	   System.out.println(split[0]);
	   System.out.println(split[1]);
	   String[] split1 = str3.split(" ");// testleaf--0,and--1 ,Qeagle--2
	   System.out.println(split1[0]);
	   System.out.println(split1[1]);
	   System.out.println(split1[2]);
	   String[] split2 = str3.split("");//this will split as a empty string
	   System.out.println(split2[13]);
	   String[] split3 = str3.split("e");//T--0,stl--1,af and Q--2,agl--3 ->length is 4
	   System.out.println(split3[2]);
	   //substring
	   String st1="December";
	   String substring = st1.substring(2);
	   System.out.println(substring);
	   String substring1 = st1.substring(2, 7);//end index-n+1
	   System.out.println(substring1);
	   String k="hello";
	   k=k.replace("l", "x");
	   System.out.println(k);
	   
	   
	}

}
