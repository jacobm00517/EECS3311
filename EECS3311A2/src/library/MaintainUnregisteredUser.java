package library;
import java.io.File;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

public class MaintainUnregisteredUser {
	public ArrayList<User> users = new ArrayList<User>();
	public String path;
	
	public void load(String path) throws Exception {
		
		CsvReader reader = new CsvReader(path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			User user;
			if (reader.get("userType").equals("student")) {
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
	
	public void update(String path) throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(path, false), ',');
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
	
	//to move approved users from unregistered database to registered database
	public void register(ArrayList<User> usersApproved) throws Exception {
		String path = pathNames.path;
		UserDatabase maintain = new MaintainUserProxy();
		
		//add each user to registered ArrayList
		for (User u: usersApproved) {
			maintain.addUser(u);
		}
		
		//update registered database
		maintain.update();
		
		//removed registered users from database
		removeUR(usersApproved);
	}

	//to remove registered or denied accounts
	public void removeUR(ArrayList<User> usersRemoved) throws Exception {
		String path = pathNames.unregisteredDBPath;
		//if a user in the database is part of the users to be removed, remove it from list (and therefore database).
		for (User u: usersRemoved) {
			if (users.contains(u)) {
				users.remove(u);
			}
		}
		
		update(path);
	}
	
	public List<User> getUsers(){
		return this.users;
	}
	public void setUsers(List<User> users) {
		this.users = new ArrayList<>(users);
	}
	
	
	
	/*public static void main(String [] args) throws Exception{
		String path = "/Users/jacobabarrota/Downloads/CSV_Example/URuser.csv";
		MaintainUnregisteredUser maintain = new MaintainUnregisteredUser();
	
		maintain.load(path);
		for(User u: maintain.users){
			System.out.println(u.toString());
		}
		
		User newUser = new User("faculty", "t4@yorku.ca", "t4t4");
		maintain.users.add(newUser);
		
		maintain.update(path);
	}*/
}
