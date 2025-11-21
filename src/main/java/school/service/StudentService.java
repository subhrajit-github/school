package school.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public List<Student> fetch(){
		List<Student> list=new ArrayList<Student>();
		String sql="SELECT * from student";
		try {
			PreparedStatement pstm=con.prepareStatement(sql);
			ResultSet resultSet=pstm.executeQuery();
			while(resultSet.next()) {
				int id=resultSet.getInt(1);
				String name=resultSet.getString(2);
				int age=resultSet.getInt(3);
				Student st=new Student();
				st.setId(id);
				st.setName(name);
				st.setAge(age);
				//list.add(new Student(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public boolean exit() {
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return true;
	}
	
	}



