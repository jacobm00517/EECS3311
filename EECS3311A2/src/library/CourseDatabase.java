package library;

import java.io.*;  
import java.util.Scanner;
import java.util.ArrayList;

public class CourseDatabase {
	
	Scanner sc;
	ArrayList<Student> students = new ArrayList<>();
	ArrayList<Book> books = new ArrayList<>();
	ArrayList<Faculty> faculty = new ArrayList<>();
	ArrayList<Course> courses = new ArrayList<>();
	
	public Book getBookByID(String bookID)
	{
		for(int i = 0; i < books.size(); i++)
		{
			if(bookID == books.get(i).getID())
			{
				return books.get(i);
			}
		}
		return null;
	}
	public Student getStudentByEmail(String studentEmail)
	{
		for(int i = 0; i < students.size(); i++)
		{
			if(studentEmail == students.get(i).getEmail())
			{
				return students.get(i);
			}
		}
		return null;
	}
	public Faculty getFacultyByEmail(String facultyEmail)
	{
		for(int i = 0; i < faculty.size(); i++)
		{
			if(facultyEmail == faculty.get(i).getEmail())
			{
				return faculty.get(i);
			}
		}
		return null;
	}
	
	public CourseDatabase()
	{
		int i = 0;
		
		String subject, courseCode, startDate, endDate, textbookID, professorEmail, facultyEmail, studentEmail;
		
		try {
			sc = new Scanner(new File("./Courses.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sc.useDelimiter(",");   //sets the delimiter pattern  
		while (sc.hasNext())  //returns a boolean value  
		{  
			if(i == 0)
			{
				subject = sc.next();
			}
			else if(i == 1)
			{
				courseCode  = sc.next();
			}
			else if(i == 2)
			{
				startDate = sc.next();
			}
			else if(i == 3)
			{
				endDate = sc.next();
			}
			else if(i == 4)
			{
				textbookID = sc.next();
			}
			else if(i == 5)
			{
				professorEmail = sc.next();
			}
			else if(i == 6)
			{
				facultyEmail = sc.next();
			}
			else if(i == 7)
			{
				studentEmail = sc.next();
			}
			
			System.out.print(sc.next());  //find and returns the next complete token from this scanner  
			i++;
		}   
		sc.close();  //closes the scanner  
	}  
	
	public static void main(String[] args) throws Exception  
	{
		CourseDatabase data = new CourseDatabase();
	}		
}
