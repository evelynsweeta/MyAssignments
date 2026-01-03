package week4.day1;

public class ConcreteClass implements DatabseConnection {

	@Override
	public void connect() {
		System.out.println("First abstract method in interface--implemented in concrete class");
		
	}

	@Override
	public void disconnect() {
		System.out.println("Second abstract method in interface--implemented in concrete class");
		
	}

	@Override
	public void executeUpdate() {
		System.out.println("Third abstract method in interface--implemented in concrete class");
		
	}
	public static void main(String[] args) {
		ConcreteClass test=new ConcreteClass();
		test.connect();
		test.disconnect();
		test.executeUpdate();
	}

}
