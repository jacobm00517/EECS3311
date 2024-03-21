<<<<<<< Updated upstream
package library;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

//needs singleton
public class MaintainCourses implements CourseDatabase{
    
    private List<Course> courses = new ArrayList<Course>();
	private String path=pathNames.COURSEDBPATH;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  

	
	@Override
	public void load() throws Exception{
		CsvReader reader = new CsvReader(this.path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			Course course = new Course();
			//subject,coursecode,startdate,enddate,textbook,faculty,students
            course.setSubject(reader.get("subject"));
            course.setCourseCode(reader.get("coursecode"));
			course.setStartDate(formatter.parse((reader.get("startdate"))));
			course.setEndDate(formatter.parse((reader.get("enddate"))));
            ItemDatabase itemDB = new MaintainItemsProxy();
			course.setTextbooks(itemDB.getItemByTitle(reader.get("textbook")));
            UserDatabase userDB = new MaintainUserProxy();
            course.setFaculty(userDB.getRegisteredUserByEmail(reader.get("faculty")));
            String parse = reader.get("students");
            String[] studentsS = parse.split(",");
            ArrayList<User> students = new ArrayList<User>();
            for (String s : studentsS){
                students.add(userDB.getRegisteredUserByEmail(s));
            }
            course.setStudents(students);
			
			courses.add(course);
			
		}
	}
	
	@Override
	public void update() throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(pathNames.COURSEDBPATH, false), ',');
				//subject,coursecode,startdate,enddate,textbook,faculty,students
				csvOutput.write("subject");
		    	csvOutput.write("coursecode");
				csvOutput.write("startdate");
				csvOutput.write("enddate");
				csvOutput.write("textbook");
				csvOutput.write("faculty");
				csvOutput.write("students");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(Course c: courses){
					csvOutput.write(c.getSubject());
			    	csvOutput.write(c.getCourseCode());
					csvOutput.write(formatter.format(c.getStartDate()));
					csvOutput.write(formatter.format(c.getEndDate()));
					csvOutput.write(c.getTextbooks().getTitle());
					csvOutput.write(c.getProfessorFaculty().getEmail());
					csvOutput.write(c.getStudentsToString());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	@Override
	public Course getCourse(Course course) {
		
		return null;
	}
	
	@Override
	public List<Course> getCourses(){
		return this.courses;
	}

	@Override
    public void addCourse(Course courses){
        this.courses.add(courses);
    }

    @Override
	public void setCourses(List<Course> course){
		this.courses = new ArrayList<Course>(course);
	}

    
=======
package library;

import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;

//needs singleton
public class MaintainCourses implements CourseDatabase{
    
    private List<Course> courses = new ArrayList<Course>();
	private String path=pathNames.COURSEDBPATH;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  

	
	@Override
	public void load() throws Exception{
		CsvReader reader = new CsvReader(this.path); 
		reader.readHeaders();
		
		while(reader.readRecord()){ 
			Course course = new Course();
			//subject,coursecode,startdate,enddate,textbook,faculty,students
            course.setSubject(reader.get("subject"));
            course.setCourseCode(reader.get("coursecode"));
			course.setStartDate(formatter.parse((reader.get("startdate"))));
			course.setEndDate(formatter.parse((reader.get("enddate"))));
            ItemDatabase itemDB = new MaintainItemsProxy();
			course.setTextbooks(itemDB.getItemByTitle(reader.get("textbook")));
            UserDatabase userDB = new MaintainUserProxy();
            course.setFaculty(userDB.getRegisteredUserByEmail(reader.get("faculty")));
            String parse = reader.get("students");
            String[] studentsS = parse.split(",");
            ArrayList<User> students = new ArrayList<User>();
            for (String s : studentsS){
                students.add(userDB.getRegisteredUserByEmail(s));
            }
            course.setStudents(students);
			
			courses.add(course);
			
		}
	}
	
	@Override
	public void update() throws Exception{
		try {		
				CsvWriter csvOutput = new CsvWriter(new FileWriter(pathNames.COURSEDBPATH, false), ',');
				//subject,coursecode,startdate,enddate,textbook,faculty,students
				csvOutput.write("subject");
		    	csvOutput.write("coursecode");
				csvOutput.write("startdate");
				csvOutput.write("enddate");
				csvOutput.write("textbook");
				csvOutput.write("faculty");
				csvOutput.write("students");
				csvOutput.endRecord();

				// else assume that the file already has the correct header line
				// write out a few records
				for(Course c: courses){
					csvOutput.write(c.getSubject());
			    	csvOutput.write(c.getCourseCode());
					csvOutput.write(formatter.format(c.getStartDate()));
					csvOutput.write(formatter.format(c.getEndDate()));
					csvOutput.write(c.getTextbooks().getTitle());
					csvOutput.write(c.getProfessorFaculty().getEmail());
					csvOutput.write(c.getStudentsToString());
					csvOutput.endRecord();
				}
				csvOutput.close();
			
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
	@Override
	public Course getCourse(Course course) {
		
		return null;
	}
	
	@Override
	public List<Course> getCourses(){
		return this.courses;
	}

	@Override
    public void addCourse(Course courses){
        this.courses.add(courses);
    }

    @Override
	public void setCourses(List<Course> course){
		this.courses = new ArrayList<Course>(course);
	}

    
>>>>>>> Stashed changes
}