package week4.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SecondLargestNumberUsingList {

	public static void main(String[] args) {
		int[] arr={3, 2, 11, 4, 6, 7};
		Arrays.sort(arr);
		List<Integer> list1=new ArrayList<>();
		for (int i : arr) {
			list1.add(i);

		}
		System.out.println("Arranged in ascending order:" +list1);
        int size = list1.size();
        System.out.println(size);
		int secondlargest=list1.get(list1.size()-2);
        System.out.println(secondlargest);
	}

}
