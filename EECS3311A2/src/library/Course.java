package library;

import java.util.ArrayList;
import java.util.Date;

public class Course {
	// Variables
	public String subject;
	public String courseCode;
	public Date startDate;
	public Date endDate;
	public Book textbooks;
	public Faculty professorFaculty;
	public ArrayList<Student> students;

	public Course() {
		
	}
	
	public Course(String subject, String courseCode, Date startDate, Date endDate, Book textbooks,
			Faculty professorFaculty, ArrayList<Student> students) {
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

	public void setTextbooks(Book textbooks) {
		this.textbooks = textbooks;
	}

	public void setProfessorFaculty(Faculty professorFaculty) {
		this.professorFaculty = professorFaculty;
	}

	public void setStudents(ArrayList<Student> students) {
		this.students = students;
	}
	
}
