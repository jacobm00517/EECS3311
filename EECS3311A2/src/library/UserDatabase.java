package library;

import java.util.List;

public interface UserDatabase {

	public void update() throws Exception;
	public User getRegisteredUserByEmail(String email) throws Exception;
	void addUser(User user);
	public void load(String path) throws Exception;
	public List<User> getUsers();
	public void setUsers(List<User> users);
	
	
}
