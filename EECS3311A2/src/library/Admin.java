package library;


import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
	private ArrayList<Request> requestList = new ArrayList<Request>();
	private String userType;
	private String email;
	private String password;

	public Admin() {
	}

	public Admin(String userType, String email, String password) {
		super(userType, email, password);
		// TODO Auto-generated constructor stub
	}

	public List<Item> getItems(){
		ItemDatabase itemDB = new MaintainItemsProxy();
		return itemDB.getItems();
	}

	// req7
	public void addItem(Item i) {
		ItemDatabase itemDB = new MaintainItemsProxy();
		itemDB.addItem(i);
	}

	public void enableItem(Item i) {
		i.setRentable("true");
	}

	public void disableItem(Item i) {
		i.setRentable("false");
	}

	// req: handle requests 
	public void handleRequests() {
		// handle requests
	}
	
	//getters and setters
	public ArrayList<Request> getRequestList() {
		return requestList;
	}
	public void setRequestList(ArrayList<Request> requestList) {
		this.requestList = requestList;
	}

	@Override
	public String getuserType() {
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


	// validate registration is handled in MaintainUnregisteredUser.java, 
	// the Admin has access to a unique GUI
	// where only they can use register() in MaintainUnregisteredUser.java on click of a button.

	// public void validateRegistration(UnregisteredUser u) {
	// }
}


