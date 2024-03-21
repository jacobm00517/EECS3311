package library;

import java.util.ArrayList;
import java.util.List;

public class Student extends UserType {
	// Variables
	private ArrayList<Course> courses = new ArrayList<>();
	private ArrayList<Book> courseTextbooks = new ArrayList<>();
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String userType, String email, String password) {
		super(userType, email, password);
		// TODO Auto-generated constructor stub
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public void addBookItem(Book bookItem) {
		courseTextbooks.add(bookItem);
	}
	
	public void addCourse(Course course) {
		courses.add(course);
	}
	
	public ArrayList<Course> getCourses() {
		return courses;
	}
	
	public ArrayList<Book> getBookItems() {
		return courseTextbooks;
	}

}
