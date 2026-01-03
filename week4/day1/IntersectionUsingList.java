package week4.day1;

import java.util.List;
import java.util.ArrayList;

public class IntersectionUsingList {

	public static void main(String[] args) {
		//declare array
		int[] arr1={3, 2, 11, 4, 6, 7};
		int[] arr2={1, 2, 8, 4, 9, 7};
        // Add array elements to lists
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < arr1.length; i++) {
			list1.add(arr1[i]);
		}
		for (int j = 0; j < arr2.length; j++) {
			list2.add(arr2[j]);			
		}
       for (int values : list1) {
	    if (list2.contains(values)) {
		System.out.println(values);
	}
    }

}

}
