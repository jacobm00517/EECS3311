package library;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) throws Exception {
		
		UserDatabase prox = MaintainUser.getInstance();
		
		prox.load(pathNames.path);
		
		User user3 = new Student("student", "email@gmail.com", "paass");
		
		prox.addUser(user3);

		prox.update();

		/*
		System.out.println(user3.getEmail());
		
		System.out.println(user3.getPassword());
		System.out.println(user3.getuserType());
		
		User newUser = new Student("student", "student@gmail.com", "t4t4");
		
		prox.addUser(newUser);
		
		prox.update();
		
		Item book1 = new Book("ItemDBProxyWorks", "Chemistry1", "2", "SteacieBasement", true, new Date(), new Date(), newUser, "Wiley", 0.00);
		
		/*MaintainItems itemDB = new MaintainItems();
		
		itemDB.load(pathNames.itemDBpath);
		
		itemDB.addItem(book1);
		
		itemDB.update();
		
		ItemDatabase itemDBprox = new MaintainItemsProxy();
		
		itemDBprox.load(pathNames.itemDBpath);

		Item book2 = new Book("ItemDBProxyWorks", "Chemistry1", "2", "SteacieBasement", true, new Date(), new Date(), user3, "Wiley", 0.00);

		Item book3 = new Book("Book", "Chemistry2", "2", "SteacieBasement", true, new Date(), new Date(), user3, "Wiley", 0.00);
		
		Item book4 = new Book("Book", "Chemistry3", "2", "SteacieBasement", true, new Date(), new Date(), user3, "Wiley", 0.00);
		itemDBprox.addItem(book1);

		itemDBprox.addItem(book2);
		
		itemDBprox.update();
		
		Date d = new Date();
		book1.setBorrowedDate(d);
		System.out.println(book1.getBorrowedDate());
		System.out.println(book1.getDueDate());
		System.out.println(book1.getLostDate());
		
		Calendar c = Calendar.getInstance();
		c.setTime(d);
	    c.add(Calendar.DATE, 40); 
	    book1.calcCost(c.getTime());
	    System.out.println(book1.getCost());
	    c.add(Calendar.DATE, 10); 
	    book1.considerIfLost(c.getTime()); // yes its lost by now
	    System.out.println(book1.getRentable());
	    

		User u = prox.getRegisteredUserByEmail("student1@gmail.com");
		System.out.println("Check" +u.getuserType());

		System.out.println("student".equals(u.getuserType()));*/

		Account account = new Account(user3);
		System.out.println(account.getNotifications());

		String dueDateS = "21/02/2024 00:55:11";
		String bDateS = "20/02/2024 00:55:12";

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Date dueDate = formatter.parse(dueDateS);
		Date bDate = formatter.parse(bDateS);
		
		
		Calendar calB = Calendar.getInstance();
		calB.setTime(bDate);

		Calendar calD = null;
		calD = Calendar.getInstance();
		calD.setTime(dueDate);
		calD.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println(calD.toString());
		if (calB.after(calD)) {
			System.out.println("Item due within 24 hours");
		}

		Date today = new Date();
		System.out.println(today.toString());

		Calendar calBDate = Calendar.getInstance();
        calBDate.setTime(new Date());
		System.out.println(calBDate.toString());

		CourseDatabase courseDB = new MaintainCoursesProxy();


		User admin = prox.getRegisteredUserByEmail("admin@yorku.ca");
		User faculty = prox.getRegisteredUserByEmail("faculty1@gmail.com");
		ArrayList<User> students = new ArrayList<User>();
		students.add(prox.getRegisteredUserByEmail("student@gmail.com"));
		students.add(prox.getRegisteredUserByEmail("student1@gmail.com"));
		students.add(prox.getRegisteredUserByEmail("student2@gmail.com"));
		Item courseBook = new Book("Book", "Chemistry1", "2", "www.url.com", false, new Date(), new Date(), admin, "Wiley", 0.00, "7");
		//subject,coursecode,startdate,enddate,textbook,faculty,students
		Course course1 = new Course("chem","3001",formatter.parse("06/01/2024 00:55:11"),formatter.parse("26/04/2024 00:55:11"),courseBook,faculty,students);
		courseDB.load();
		courseDB.addCourse(course1);
		courseDB.update();

	}

}
