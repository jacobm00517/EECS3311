package library;

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
		
		

	}

}
