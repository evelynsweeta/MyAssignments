package week3.day1;

import java.util.Arrays;

public class LearnArray {

	public static void main(String[] args) {
		//array literals
		int marks[]= {76,98,89,40,26,100,34};
    ///length of the array
		int length = marks.length;//length is a property in array -there is no()
		System.out.println(length);
		//sorting a array using method
		Arrays.sort(marks);//ascending order->26,34,40,76,89,98,100
		for (int i = 0; i < marks.length; i++) {
			System.out.println(marks[i]);
		}
			//get the last value in array
			int num[]= {70,89,567,344,87,90};
            System.out.println(num[num.length-1]); 
            //Array Instantiation-based on the size
            int marks1[]=new int[4];//size is length
            marks1[0]=34;
            marks1[1]=10;
            marks1[2]=212;
            marks1[3]=53;
            System.out.println("instratiation array:" +marks1[3]);//here  the value is index
            
	}

}
