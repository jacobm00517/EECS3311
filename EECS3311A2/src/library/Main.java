package library;

import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) throws Exception {
		UserDatabase prox = new MaintainUserProxy();
		
		prox.load(pathNames.path);
		
		User user3;
		
		user3 = prox.getRegisteredUserByEmail("student1@gmail.com");
		
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
		
		itemDB.update();*/
		
		ItemDatabase itemDBprox = new MaintainItemsProxy();
		
		itemDBprox.load(pathNames.itemDBpath);
		
		itemDBprox.addItem(book1);
		
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
	    
		

	}

}
