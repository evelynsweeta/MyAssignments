package week1.day2;

public class FibonacciSeries {

	public static void main(String[] args) {
		int first=0,second=1;
		System.out.println(first);
		System.out.println(second);
		for (int i =1; i<=6; i++) {
			int next=first+second;
			first=second;
			second=next;
			System.out.println(next);
			
				
		}

	}

}
