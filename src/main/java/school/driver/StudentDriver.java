package school.driver;

import java.util.Scanner;

import school.entity.Student;
import school.service.StudentService;

public class StudentDriver {

	public static void main(String[] args) {
		
		StudentService service=new StudentService();
		Scanner sc=new Scanner(System.in);
		System.out.println("WELCOME TO TECHNO SCHOOL");
		while(true) {
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
				int save=service.save(st);
				if(save!=0) {
				System.out.println("data saved!!!");
				}
				break;
			case 2:
			//call update()
				System.out.println("enter your id to be updated");
				int idu=sc.nextInt();
				System.out.println("enter your name to be updated");
				String nameu=sc.next();
				System.out.println("Enter your age to be updated");
				int ageu=sc.nextInt();
				Student stu=new Student();
				stu.setAge(ageu);
				stu.setName(nameu);
				stu.setId(idu);
				int update=service.update(stu);
				if(update!=0) {
					System.out.println("data updated");
				}
				break;
			case 3:
				//call fetch();
				break;
			case 4:
				//call delete();
				System.out.println("enter your id to be deleted");
				int idd=sc.nextInt();
				int delete=service.delete(idd);
				if(delete!=0) {
					System.out.println("data is deleted");
				}
				else {
					System.out.println("ID INVALID!!!");
				}
				break;
			case 5:
				//call close()
				break;
			}
		}
		
	}

}
