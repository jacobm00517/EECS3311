package library;

public class Visitor extends UserType {

	public Visitor() {
		// TODO Auto-generated constructor stub
	}

	public Visitor(String userType, String email, String password) {
		super(userType, email, password);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getuserType() {
		// TODO Auto-generated method stub
		return super.getuserType();
	}

	@Override
	public void setUserType(String userType) {
		// TODO Auto-generated method stub
		super.setUserType(userType);
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return super.getEmail();
	}

	@Override
	public void setEmail(String email) {
		// TODO Auto-generated method stub
		super.setEmail(email);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}