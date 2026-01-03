package week4.day1;

public abstract class MySqlConnection implements DatabaseConnection {
	
	public void executeQuery() {
		System.out.println("execute query method from abstract class--implemented in abstract class");
	}

}
