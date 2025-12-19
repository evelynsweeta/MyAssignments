package week1.day2;

public class IsPrimeNumber {

	public static void main(String[] args) {
		int n=6;
		for(int i=2;i<=n-1;i++)
		{
			if(n%i==0) {
				System.out.println("This is Non prime number:" +n);
				return;
			}
			
		}
		System.out.println("This is prime number:" +n);		
	}

}
