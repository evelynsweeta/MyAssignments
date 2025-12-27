package week3.day2.inheritanceassignment;

public class Edge extends Browser {
	public void  takeSnap() {
		System.out.println("TAKE SNAP---->sub class 2");	
	}
	public void  clearCookies() {
		System.out.println("Clear Cookies---->sub class 2");		
	}
	public static void main(String[] args) {
		Edge e=new Edge();
		e.openURL();
		e.closeBrowser();
		e.navigateBack();
		e.takeSnap();
		e.clearCookies();
	}

}
