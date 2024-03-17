package library;

import java.util.*;

public class MaintainUserProxy implements UserDatabase {
	
	private static UserDatabase maintainUser = new MaintainUser();
	private static List<User> users = new ArrayList<User>();

	private void initializeProxy() throws Exception {
		if (users.isEmpty()) {
			System.out.println("Check load");
			maintainUser.load(pathNames.path);
		}
	}
	
	
	@Override
	public void update() throws Exception {
		initializeProxy();
		maintainUser.setUsers(users);
		maintainUser.update();
	}

	@Override
	public User getRegisteredUserByEmail(String email) throws Exception {
		initializeProxy();
		for (User u : users) {
			System.out.println(u.getEmail());
			if (u.getEmail().equals(email)) {
				System.out.println("EMAIL FOUND TRUE");
				return u;
			}
		}
		return null;
	}

	@Override
	public void addUser(User user) {
		users.add(user);
	}


	@Override
	public void load(String path) throws Exception {
		initializeProxy();
		users.addAll(maintainUser.getUsers());
		System.out.println("System loaded proxy done");
	}
	
	@Override
	public List<User> getUsers(){
		return MaintainUserProxy.users;
	}
	
	@Override
	public void setUsers(List<User> users) {
		MaintainUserProxy.users = new ArrayList<>(users);
	}

	

}
