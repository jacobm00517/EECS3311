package library;

import java.util.List;
import java.util.regex.*;
import javax.mail.internet.*;

public class Facade {
	public static Search search = new Search();
	public static DiscountOffers discount = new DiscountOffers();
	private static User userL;


	//to make a user from registering
	public String makeUser (String userType, String email, String password) {
		User newUnregisteredUser;
		if (false==userTypeValid(userType)) {
			return "<html>Pick one of the following user types:<br/>student, faculty, non-faculty, or visitor</html>";
		}
		else if (!emailValid(email)) {
			return "Enter valid email address.";
		}
		else if (!passwordValid(password)) {
			return "Invalid Password: must contain at least 8-20 characters, one digit, one upper case and one lower case.";
		}
		else {
			if ("student".equals(userType)) {
	    		newUnregisteredUser = new Student(userType, email, new String(password));
	    	}
	    	else if ("faculty".equals(userType)) {
	    		newUnregisteredUser = new Faculty(userType, email, new String(password));
	    	}
	    	else {
	    		newUnregisteredUser = new Nonfaculty(userType, email, new String(password));
	    	}
			return addToDatabase(newUnregisteredUser);
		}
	}

	
	public boolean passwordValid(String password)
    {
 
        // Regex to check valid password.
        String regex = "^(?=.*[0-9])"
                       + "(?=.*[a-z])(?=.*[A-Z])"
                       + "(?=.*[@#$%^&+=!?_-])"
                       + "(?=\\S+$).{8,20}$";
 
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);
 
        // If the password is empty
        // return false
        if (password == null) {
            return false;
        }
 
        // Pattern class contains matcher() method
        // to find matching between given password
        // and regular expression.
        Matcher m = p.matcher(password);
 
        // Return if the password
        // matched the ReGex
        return m.matches();
    }

	public boolean emailValid(String email) {
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
		}

	public boolean userTypeValid(String userType) {
		if ("student".equals(userType)||"faculty".equals(userType)||"non-faculty".equals(userType)||"visitor".equals(userType)) {
			return true;
		}
		else {
			return false;
		}
	}

	public String addToDatabase(User newUser) {
		if (newUser.getuserType().equals("visitor")) {
			String path = pathNames.path;
    		UserDatabase maintain = new MaintainUserProxy();
    		
    		maintain.addUser(newUser);
    		
    		try {
				maintain.update();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
    		return "Registration successful.";
		}
		else {
	    	String pathUR = pathNames.unregisteredDBPath;
			MaintainUnregisteredUser maintainUR = new MaintainUnregisteredUser();
		
			try {
				maintainUR.load(pathUR);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			maintainUR.users.add(newUser);
			
			try {
				maintainUR.update(pathUR);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return "Please wait for admin approval.";
		}
	}


	public User loginUser(String email, char[] password) {
		String passwordString = new String(password);
		UserDatabase prox = new MaintainUserProxy();
		
		User u = null;
		try {
			prox.load(pathNames.path);
			u = prox.getRegisteredUserByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (u.getPassword().equals(passwordString)) {
			this.userL = u;
			return u;
		}
		else{
			return null;
		}

	}

	public User getUser(){
		return Facade.userL;
	}

	//is this correct?
	public void initializeGUI(){
		
		if (Facade.userL.getuserType().equals("student")){
			new MainFrame(this.userL);
		}
		else if (Facade.userL.getuserType().equals("faculty")){
			new FacultyFrame(this.userL);
		}
		else if (Facade.userL.getuserType().equals("non-faculty")){
			new MainFrame(this.userL);
		}
		else if (Facade.userL.getuserType().equals("visitor")){
			new MainFrame(this.userL);
		}
		else if (Facade.userL.getuserType().equals("admin")) {
			new AdminFrame(this.userL);
		}

		
	}

	public static List<Item> search(String input, ItemDatabase items){
		return search.strategyInput(input, items);
	}

	public static List<Item> discountOffers(String input, ItemDatabase items){
		return discount.strategyInput(input, items);
	}

}
