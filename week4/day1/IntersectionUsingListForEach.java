package week4.day1;

import java.util.ArrayList;
import java.util.List;

public class IntersectionUsingListForEach {

	public static void main(String[] args) {
		//declare array
				int[] arr1={3, 2, 11, 4, 6, 7};
				int[] arr2={1, 2, 8, 4, 9, 7};
		        // Add array elements to lists
		        List<Integer> list1 = new ArrayList<>();
		        List<Integer> list2 = new ArrayList<>();
				for (Integer i : arr1) {
					list1.add(i);
				}
				for (int j : arr2) {
					list2.add(j);
				}
		for (int values : list1) {
			if (list2.contains(values)) {
				System.out.println(values);
			}
			
		}

			}

		}
