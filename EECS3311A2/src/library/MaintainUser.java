package library;
import java.io.File;
import java.util.*;
import java.io.FileWriter;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainUser implements UserDatabase{
	private List<User> users = new ArrayList<User>();
	private String path;
	private static MaintainUser database = null;
	
	private MaintainUser() {
        
    }
	
	public static UserDatabase getInstance() {
		if (database == null) {
			database = new MaintainUser();
		}
		return database;
	}
	
	@Override
	public void load(String path) throws Exception{
		System.out.println("System loaded");
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			User user;
			if (reader.get("userType").equals("admin")) {
				user = new Admin();
			}
			else if (reader.get("userType").equals("student")) {
				user = new Student();
			}
			else if (reader.get("userType").equals("faculty")) {
				user = new Faculty();
			}
			else if (reader.get("userType").equals("visitor")) {
				user = new Visitor();
			}
			else {
				user = new Nonfaculty();
			}
			//userType,email,password
			user.setUserType(reader.get("userType"));
			user.setEmail(reader.get("email"));
			user.setPassword(reader.get("password"));
			users.add(user);
		}
	}
	
	
	@Override
	public void update() throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(pathNames.path, false), ',');
				//name,userType,email,password
				csvOutput.write("userType");
		    	csvOutput.write("email");
				csvOutput.write("password");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(User u: users){
					csvOutput.write(u.getuserType());
					csvOutput.write(u.getEmail());
					csvOutput.write(u.getPassword());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	//Based off a Users email in string, find the instance of that user.
	@Override
	public User getRegisteredUserByEmail(String email) throws Exception {
		for (User u : users) {
			if (u.getEmail().equals("email")) {
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
	public List<User> getUsers(){
		return this.users;
	}
	
	@Override
	public void setUsers(List<User> users) {
		this.users = new ArrayList<>(users);
	}
	
	/*public static void main(String [] args) throws Exception{
		String path = "/Users/jacobabarrota/Downloads/CSV_Example/user.csv";
		MaintainUser maintain = new MaintainUser();
	
		maintain.load(path);
		for(User u: maintain.users){
			System.out.println(u.toString());
		}
		
		User newUser = new User("faculty", "t4@yorku.ca", "t4t4");
		maintain.users.add(newUser);
		
		maintain.update(path);
	}*/
}