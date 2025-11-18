package school.driver;

import java.util.Scanner;

import school.entity.Student;
import school.service.StudentService;

public class StudentDriver {

	public static void main(String[] args) {
		
		StudentService service=new StudentService();
		new Scanner(System.in);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("WELCOME TO TECHNO SCHOOL");
		System.out.println("enter 1 to save student data");
		System.out.println("enter 2 to update student data");
		System.out.println("enter 3 to fetch student data");
		System.out.println("enter 4 to delete student data");
		System.out.println("enter 5 to close application");
		
		System.out.println("enter your choice");
		int choice=sc.nextInt();
		
		switch(choice) {
		case 1:
			//call save()
			System.out.println("enter your id");
			int id=sc.nextInt();
			System.out.println("enter your name");
			String name=sc.next();
			System.out.println("Enter your age");
			int age=sc.nextInt();
			
			Student st=new Student();
			st.setId(id);
			st.setName(name);
			st.setAge(age);
			service.save(st);
			break;
		case 2:
		//call update()
			break;
		case 3:
			//call fetch();
			break;
		case 4:
			//call delete();
			break;
		case 5:
			//call close()
			break;
		}
	}

}
