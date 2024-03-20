package library;


import java.util.ArrayList;
import java.util.List;

public class Admin {
	private ArrayList<Request> requestList = new ArrayList<Request>();

	// req7
	public void addItem(Item i) {

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


	// validate registration is handled in MaintainUnregisteredUser.java, 
	// the Admin has access to a unique GUI
	// where only they can use register() in MaintainUnregisteredUser.java on click of a button.

	// public void validateRegistration(UnregisteredUser u) {
	// }


}


