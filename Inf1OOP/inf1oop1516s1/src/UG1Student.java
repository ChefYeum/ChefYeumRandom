import java.util.Hashtable;

public class UG1Student extends Student {
	private char mainSchedule;
	public UG1Student(String name, String uun, char mainSchedule) {
		super(name,uun,1);
		this.mainSchedule = mainSchedule;
	}
	
	public UG1Student() {
		super("not set", "not set", 1);
		this.mainSchedule = 'X';
	}
	
	public boolean addCourse(Course course) {
		if (course.getLevel() == 7 || course.getLevel() == 8) {
			return super.addCourse(course);
		} else {
			return false;
		}
	}
	
	public boolean addCourses(Course[] courses) {
		//Assume the array, and any Course objects in it, are not null
		//Empty array returns true as there is no failed addition of courses
		boolean output = true;

		for (Course c : courses) {
			if (!this.addCourse(c)) output = false;
		}
		
		return output;
	}
	
	public String toString() {
		
		StringBuilder output = new StringBuilder();
		output.append(super.toString());
		
		
		if (super.getCourses().length != 0) {
			//get main schedule (most frequent course schedule)
			Hashtable<Character, Integer> countSchedule = new Hashtable<>();
			
			for (Course c : super.getCourses()) {
				char schedule = c.getSchedule();
				countSchedule.put(schedule, countSchedule.getOrDefault(schedule, 0)+1);
			}
			
			//Get Max
			char maxKey = (char) countSchedule.keySet().toArray()[0];
			for (Character c : countSchedule.keySet()) {
				if (countSchedule.get(c) > countSchedule.get(maxKey)) {
					maxKey = c;
				}
			}
			
			output.append(String.format("\nMain schedule %c courses:", maxKey));
			for (Course c : super.getCourses()) {
				if (c.getSchedule() == maxKey) {
					output.append("\n" + c.getName());
				}
			}
		}

		return output.toString();
	}
	
	
}
