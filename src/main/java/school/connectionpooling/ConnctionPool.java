package school.connectionpooling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnctionPool {
	private static Connection con;

	public static String url = "jdbc:postgresql://localhost:5432/school?user=postgres&password=123";
	
	 private static List<Connection> list=new ArrayList<Connection>();

	static {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded");

			con = DriverManager.getConnection(url);
			System.out.println("connection established");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(int i=1;i<=15;i++) {
			list.add(con);
		}
	}
	public static Connection getConnect() {
		//list is empty create connection() or not
		
		return con;
	}
	public static void recieveConnection(Connection con) {
		list.add(con);
	}
	public static Connection createConnection() {
		try {
			con = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
