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
			output.append(String.format("\nMain schedule %c courses:", this.mainSchedule));
			for (Course c : super.getCourses()) {
				if (c.getSchedule() == this.mainSchedule) {
					output.append("\n" + c.getName());
				}
			}
		}

		return output.toString();
	}
	
	
}
