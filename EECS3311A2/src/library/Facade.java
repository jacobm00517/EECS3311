package library;

import java.util.regex.*;
import javax.mail.internet.*;

public interface Facade {

	
	public static String makeUser (String userType, String email, String password) {
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

	
	public static boolean passwordValid(String password)
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

	public static boolean emailValid(String email) {
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
		}

	public static boolean userTypeValid(String userType) {
		if ("student".equals(userType)||"faculty".equals(userType)||"non-faculty".equals(userType)||"visitor".equals(userType)) {
			System.out.println("student".equals(userType));
			return true;
		}
		else {
			return false;
		}
	}

	public static String addToDatabase(User newUser) {
		if (newUser.getuserType().equals("visitor")) {
			String path = pathNames.path;
    		MaintainUser maintain = new MaintainUser();
    	
    		try {
				maintain.load(path);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    		
    		maintain.users.add(newUser);
    		
    		try {
				maintain.update(path);
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

}
