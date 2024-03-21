package library;

import java.util.ArrayList;
import java.util.Date;

public class Course {
	// Variables
	public String subject;
	public String courseCode;
	public Date startDate;
	public Date endDate;
	public Item textbooks;
	public User professorFaculty;
	public ArrayList<User> students;

	public Course() {
		
	}
	
	public Course(String subject, String courseCode, Date startDate, Date endDate, Item textbooks,
			User professorFaculty, ArrayList<User> students) {
		this.subject = subject;
		this.courseCode = courseCode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.textbooks = textbooks;
		this.professorFaculty = professorFaculty;
		this.students = students;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setTextbooks(Item textbooks) {
		this.textbooks = textbooks;
	}

	public void setFaculty(User professorFaculty) {
		this.professorFaculty = professorFaculty;
	}

	public void setStudents(ArrayList<User> students) {
		this.students = students;
	}

	public String getSubject() {
		return subject;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Item getTextbooks() {
		return textbooks;
	}

	public User getProfessorFaculty() {
		return professorFaculty;
	}

	public ArrayList<User> getStudents() {
		return students;
	}

	public String getStudentsToString(){
		String students = "";
		for (User s : getStudents()){
			students+=s.getEmail()+",";
		}
		return students;
	}
	
}
