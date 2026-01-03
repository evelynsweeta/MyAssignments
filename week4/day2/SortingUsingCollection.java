package week4.day2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingUsingCollection {

	public static void main(String[] args) {
		//declared a string array
		String[] value={"HCL", "Wipro", "Aspire Systems", "CTS"};	
		//created 2 empty list
		List<String> list1=new ArrayList<>();
		List<String> list2=new ArrayList<>();
		//using for each loop adding the values from a atring array to list
		for (String st : value) {
			list1.add(st);
			//sort the list
			Collections.sort(list1);
		} 
		//printing the sorted list
      System.out.println("Sorted List:" +list1);
      //using for loop reversing the list and adding to the empty list2
     for (int i =list1.size()-1; i>=0; i--) {
    	 list2.add(list1.get(i));
    	  }
     System.out.println("Reversed List:" +list2);
	}

}
