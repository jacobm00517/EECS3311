<<<<<<< Updated upstream
package library;

import java.util.ArrayList;
import java.util.List;

public class AdminAccount {


	ItemDatabase itemDB = new MaintainItemsProxy();
	MaintainUnregisteredUser URuserDB = new MaintainUnregisteredUser();
	UserDatabase userDB = new MaintainUserProxy();
	public String path;
	
	
	public ArrayList<String> getAllUnregMail() {
		
//		returns a String array/arraylist of all unregistered users emails.
		
		String path = pathNames.unregisteredDBPath;
		ArrayList<String> allUnregMail = null;
		List<User> users = URuserDB.getUsers(); /// make it the users in there
		
		for (User u : users) {
				allUnregMail.add(u.getEmail());
			}
		
		return allUnregMail;
		}

		


	public void convert_ListUnregMail_accept(ArrayList<String> unregMail) {
		String path = pathNames.path;
		ArrayList<User> accepted = null;
		List<User> users = userDB.getUsers();
		
		
		//	The arraylist of unregistered users emails should be turned back into an arraylist of 
		// 	unregistered users user objects are (refer to getUserByEmail()). 
		for (String s: unregMail) {
			
			
			for (User u : users) {
				if (u.getEmail().equals(s)) {
					accepted.add(u);
				}
			}
			
		}
		
//		This method should then send this list to MaintainURUsers register method.
		try {
			URuserDB.register(accepted);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void convert_ListUnregMail_reject(ArrayList<String> unregMail) {
		String path = pathNames.path;
		ArrayList<User> rejected = null;
		List<User> users = userDB.getUsers();
		
		
		//	The arraylist of unregistered users emails should be turned back into an arraylist of 
		// 	unregistered users user objects are (refer to getUserByEmail()). 
		for (String s: unregMail) {
			
			
			for (User u : users) {
				if (u.getEmail().equals(s)) {
					rejected.add(u);
				}
			}
			
		}
		
//		This method should then send this list to MaintainURUsers register method.
		try {
			URuserDB.removeUR(rejected);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public List<Item> return_allItems() {

		// returns an ArrayList of all items in library.
		String path = pathNames.itemDBpath;
		return itemDB.getItems();
	}


	public void remove_ListItems(ArrayList<Item> items) {
		
		//	accepts an ArrayList of items and removes them from item database.
		String path = pathNames.itemDBpath;
		
		for (Item i: items) {
			if (itemDB.getItems().contains(i)) {
				itemDB.getItems().remove(i);
			}
		}
		
		try {
			itemDB.update();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	public void disable_ItemsList(ArrayList<Item> items) {

		//	accepts an ArrayList of items and disables their rentable.
		for (Item i : items) {
			i.setRentable("false");
		}
	}

	public void enable_ItemsList(ArrayList<Item> items) {
		//	accepts an ArrayList of items and enables their rentable.
		for (Item i : items) {
			i.setRentable("true");
		}
	}

	public void add_createItem(Item i) {

		//	accepts however many parameters it takes to make an item, 
		// 	makes an item from those parameters and adds it itemDatabaseProxy.
		itemDB.addItem(i);
	}

	public void requests() {



		//	method for requests. 
		// 	At the time i am not familiar with request database and class. Please figure it out.
		

	}




=======
package library;

import java.util.ArrayList;
import java.util.List;

public class AdminAccount {


	ItemDatabase itemDB = new MaintainItemsProxy();
	MaintainUnregisteredUser URuserDB = new MaintainUnregisteredUser();
	UserDatabase userDB = new MaintainUserProxy();
	public String path;
	
	
	public ArrayList<String> getAllUnregMail() {
		
//		returns a String array/arraylist of all unregistered users emails.
		
		String path = pathNames.unregisteredDBPath;
		ArrayList<String> allUnregMail = null;
		List<User> users = URuserDB.getUsers(); /// make it the users in there
		
		for (User u : users) {
				allUnregMail.add(u.getEmail());
			}
		
		return allUnregMail;
		}

		


	public void convert_ListUnregMail_accept(ArrayList<String> unregMail) {
		String path = pathNames.path;
		ArrayList<User> accepted = null;
		List<User> users = userDB.getUsers();
		
		
		//	The arraylist of unregistered users emails should be turned back into an arraylist of 
		// 	unregistered users user objects are (refer to getUserByEmail()). 
		for (String s: unregMail) {
			
			
			for (User u : users) {
				if (u.getEmail().equals(s)) {
					accepted.add(u);
				}
			}
			
		}
		
//		This method should then send this list to MaintainURUsers register method.
		try {
			URuserDB.register(accepted);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void convert_ListUnregMail_reject(ArrayList<String> unregMail) {
		String path = pathNames.path;
		ArrayList<User> rejected = null;
		List<User> users = userDB.getUsers();
		
		
		//	The arraylist of unregistered users emails should be turned back into an arraylist of 
		// 	unregistered users user objects are (refer to getUserByEmail()). 
		for (String s: unregMail) {
			
			
			for (User u : users) {
				if (u.getEmail().equals(s)) {
					rejected.add(u);
				}
			}
			
		}
		
//		This method should then send this list to MaintainURUsers register method.
		try {
			URuserDB.removeUR(rejected);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public List<Item> return_allItems() {

		// returns an ArrayList of all items in library.
		String path = pathNames.itemDBpath;
		return itemDB.getItems();
	}


	public void remove_ListItems(ArrayList<Item> items) {
		
		//	accepts an ArrayList of items and removes them from item database.
		String path = pathNames.itemDBpath;
		
		for (Item i: items) {
			if (itemDB.getItems().contains(i)) {
				itemDB.getItems().remove(i);
			}
		}
		
		try {
			itemDB.update();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

	public void disable_ItemsList(ArrayList<Item> items) {

		//	accepts an ArrayList of items and disables their rentable.
		for (Item i : items) {
			i.setRentable("false");
		}
	}

	public void enable_ItemsList(ArrayList<Item> items) {
		//	accepts an ArrayList of items and enables their rentable.
		for (Item i : items) {
			i.setRentable("true");
		}
	}

	public void add_createItem(Item i) {

		//	accepts however many parameters it takes to make an item, 
		// 	makes an item from those parameters and adds it itemDatabaseProxy.
		itemDB.addItem(i);
	}

	public void requests() {



		//	method for requests. 
		// 	At the time i am not familiar with request database and class. Please figure it out.
		

	}




>>>>>>> Stashed changes
}