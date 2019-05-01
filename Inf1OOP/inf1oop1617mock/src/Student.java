import java.util.ArrayList;
import java.util.HashMap;

public class Student extends Person {

	private ArrayList<Course> activeCourses; //stores the courses that the student has enrolled
	private ArrayList<Course> completedCourses;
	private int maxCourses; //number of active courses that the student can be enrolled into
	
	public Student(String firstName, String lastName,
					ArrayList<Course> activeCourses,
					ArrayList<Course> completedCourses,
					int maxCourses) { 
		super(firstName, lastName);
		this.activeCourses = activeCourses;
		this.completedCourses = completedCourses;
		this.maxCourses = maxCourses;
	}
	
	
	public void setMaxCourses(int n) {this.maxCourses = n;}
	public int getMaxCourses() {return this.maxCourses;}
	
	public boolean canEnroll(Course course) {
		//Check all prereqs are satisfied
		ArrayList<String> completed = new ArrayList<>();
		for (Course completedCourse : this.completedCourses) completed.add(completedCourse.getName());
		
		for (String preReq: course.getPrerequisiteCourses()) {
			if (!completed.contains(preReq)) return false;
		}
		
		//Check if the student is not already enrolled, or if it is already completed, or if the student exceeded the max number of courses
		if (activeCourses.contains(course)
			|| completedCourses.contains(course)
			|| activeCourses.size() >= maxCourses) return false;
		else return true;
	}
	
	public boolean enroll(Course course) {
		if (this.canEnroll(course)) {
			activeCourses.add(course);
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean complete(String courseName) {
		for (Course course : this.activeCourses) {
			if (course.getName() == courseName) {
				this.completedCourses.add(course);
				this.activeCourses.remove(course);
				return true;
			}
		}
		return false; //otherwise.
	}
	
	public HashMap<Course,String> getAllCourses(){
		HashMap<Course,String> outputMap = new HashMap<>();
		
		//put all the active courses in the output map
		for (Course course : this.activeCourses) {
			outputMap.put(course, "active");
		}
		
		//put all the completed courses in the output map
		for (Course course : this.completedCourses) {
			outputMap.put(course, "completed");
		}
		
		return outputMap;
	}
	
	public String summary() {
		StringBuilder output = new StringBuilder();
		
		for (Course course : this.activeCourses) {
			output.append(String.format("%s (active)\n", course.getName()).toString());
		}
	
		for (Course course : this.completedCourses) {
			output.append(String.format("%s (completed)\n", course.getName().toString()));
		}
		
		return output.toString();
	
	}
}
