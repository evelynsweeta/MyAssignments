package week4.day1;

import java.util.Arrays;
import java.util.List;

public class MissingElementUsingList {

	public static void main(String[] args) {
		Integer[] arr={1, 2, 3, 4, 10, 6, 8};
		Arrays.sort(arr);
		//List<Integer> list=new ArrayList<>();
		//convert array to list
		List<Integer> list = Arrays.asList(arr);
		for (int i = 0; i < arr.length-1; i++) {
			int current = list.get(i);
			int next=list.get(i+1);
			if (current+1 != next) {
				System.out.println(current+1);
			}
			
		}

	}

}
