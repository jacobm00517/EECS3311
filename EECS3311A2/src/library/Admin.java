package library;


import java.util.ArrayList;
import java.util.List;

public class Admin {
	List<Request> requestList = new ArrayList<Request>();

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

	// validate registration is handled in MaintainUnregisteredUser.java, 
	// the Admin has access to a unique GUI
	// where only they can use register() in MaintainUnregisteredUser.java on click of a button.

	// public void validateRegistration(UnregisteredUser u) {
	// }


}


