package library;

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
		
		Item book1 = new Book("Book2", "Chemistry1", "2", "SteacieBasement", true, new Date(), new Date(), newUser, "Wiley", 0.05);
		
		MaintainItems itemDB = new MaintainItems();
		
		itemDB.load(pathNames.itemDBpath);
		
		itemDB.addItem(book1);
		
		itemDB.update(pathNames.itemDBpath);
		
		
		

	}

}
