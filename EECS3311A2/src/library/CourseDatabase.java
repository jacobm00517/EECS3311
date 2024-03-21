package library;

import java.util.List;
import java.util.ArrayList;

//needs singleton
public interface CourseDatabase {


	void load() throws Exception;

	void update() throws Exception;

	Course getCourse(Course Course);

	List<Course> getCourses();

	void setCourses(List<Course> course);
	public void addCourse(Course courses);

}