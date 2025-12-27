package week3.day2.overloadingassignment;

public class overloadingAssignment {
	
	public void add(){//method with 0 arguments
		int a=10;
		int b=15;
		System.out.println(a+b);
		
	}
	public void add(int a,int b){//methods  with 2 arguments
		System.out.println(a+b);
		
	}
	public void add(int a,float b, int c){
		System.out.println(a+b+c);
		
	}
	public static void main(String[] args) {
		overloadingAssignment oa=new overloadingAssignment();
		oa.add();
		oa.add(1, 2);
		oa.add(1,2,3);
	}


}
