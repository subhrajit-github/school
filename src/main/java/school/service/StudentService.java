package school.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import school.entity.Student;

public class StudentService {
//db logic
	
	private static Connection con;
	
	public static String url="jdbc:postgresql://localhost:5432/school?user=postgres&password=123";
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			System.out.println("Driver loaded");
			
	   con=DriverManager.getConnection(url);
			System.out.println("connection established");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public int save(Student st) {
		int res=0;
		String sql="INSERT into student values(?,?,?)";
		try {
		PreparedStatement pstm=con.prepareStatement(sql);
		pstm.setInt(1, st.getId());
		pstm.setString(2, st.getName());
		pstm.setInt(3, st.getAge());
		
		res=pstm.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
		
	}
	
	
	public int update(Student stu) {
		int res=0;
		String sql="UPDATE student set age=?,name=? where id=?";
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setInt(1, stu.getAge());
			pstm.setString(2,stu.getName());
			pstm.setInt(3, stu.getId());
			
			res=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	
	public int delete(int id) {
		int res=0;
		String sql="DELETE from student where id=?";
		
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			pstm.setInt(1, id);
			res=pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}

