package week3.day2.overriding;

import week3.day2.overloadingassignment.overloadingAssignment;

public class LearnOverriding extends overloadingAssignment{
	public void add() {
		int c=10;
		int d=5;
		System.out.println(c+d);
		super.add();//taking the parent class method using super keyword
	}
	public static void main(String[] args) {
		LearnOverriding LO=new LearnOverriding();
		LO.add();//child class is taken here
		
	}

}
