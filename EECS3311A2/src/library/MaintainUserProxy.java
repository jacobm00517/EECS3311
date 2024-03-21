package library;

import java.util.*;

public class MaintainUserProxy implements UserDatabase {
	
	private static UserDatabase maintainUser = MaintainUser.getInstance();
	private static List<User> users = new ArrayList<User>();

	private void initializeProxy() throws Exception {
		if (users.isEmpty()) {
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
