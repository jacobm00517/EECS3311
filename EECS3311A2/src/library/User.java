package library;

public abstract class User {
	private String userType;
	private String email;
	private String password;
	
	public User(String userType, String email, String password) {
		this.userType = userType;
		this.email = email;
		this.password = password;
	}
	
	public User(){
		super();
	}

	public String getuserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User: userType=" + userType + ", email=" + email + ", password=" + password + "]";
	}
	
}