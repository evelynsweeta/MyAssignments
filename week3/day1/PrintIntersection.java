package week3.day1;

import java.util.Arrays;

public class PrintIntersection {

	public static void main(String[] args) {
        int num[]= {1,2,1,3,4};
        int num1[]= {2,5,6,7,8,1};
        int lengthofnum = num.length;
        System.out.println("length of num array is:" +lengthofnum);
        int lengthofnum1 = num1.length;
        System.out.println("length of num1 array is:" +lengthofnum1);
        for (int i = 0; i < num.length; i++) {
        	for (int j = 0; j < num1.length; j++) {
				if (num[i]==num1[j]) {
					System.out.println("Intesection values are:" +num[i]);
				}
			  }

			}
		Arrays.sort(num);
	   for (int k = 0; k < num.length; k++) {
		System.out.println(num[k]);
	}
	}

}
