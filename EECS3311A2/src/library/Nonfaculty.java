package library;

public class Nonfaculty extends UserType {

	public Nonfaculty() {
		// TODO Auto-generated constructor stub
	}

	public Nonfaculty(String userType, String email, String password) {
		super(userType, email, password);
		// TODO Auto-generated constructor stub
	}
	
	// CONSTRUCTOR ATTRIBUTE GETTER/SETTERS
	@Override
	public String getuserType() {
		
		return super.getuserType();
	}
	@Override
	public void setUserType(String userType) {
		
		super.setUserType(userType);
	}
	
	@Override
	public String getEmail() {
	
		return super.getEmail();
	}
	@Override
	public void setEmail(String email) {
		
		super.setEmail(email);
	}
	
	@Override
	public String getPassword() {
		
		return super.getPassword();
	}
	@Override
	public void setPassword(String password) {
		super.setPassword(password);
	}
	
	
	@Override
	public String toString() {
	
		return super.toString();
	}

}
