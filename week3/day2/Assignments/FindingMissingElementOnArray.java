package week3.day2.Assignments;

import java.util.Arrays;

public class FindingMissingElementOnArray {

	public static void main(String[] args) {
		int[] num= {1, 4,3,2,8, 6, 7};
	    Arrays.sort(num);
	    for (int i = 0; i < num.length-1; i++) {
			int num1 = num[i];
			int nextnum=num[i+1];
			if (num1+1!=nextnum) {
				System.out.println(num1+1);
			}
		}

	}

}
