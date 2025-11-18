package school.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import school.entity.Student;

public class StudentService {
//db logic
	public static String url="jdbc:postgresql://localhost:5432/school?user=postgres&password=123";
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded");
			
			Connection con=DriverManager.getConnection(url);
			System.out.println("connection established");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public void save(Student student) {
		String sql="INSERT into student values(?,?,?)";
	}

}

