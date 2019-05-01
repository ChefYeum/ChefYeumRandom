

import java.util.ArrayList;

public class testMain {
	public static void main(String[] args) {
		ArrayList completed = new ArrayList<>();
		ArrayList active = new ArrayList<>();
		
		Course c1 = new Course("Introduction to Logic", new ArrayList<>());
		Course c2 = new Course("Python", new ArrayList<>());
		
		ArrayList<String> prerequisite1 = new ArrayList<>();
		prerequisite1.add(c1.getName());
		Course c3 = new Course("Advanced Logic", prerequisite1);
		
		ArrayList<String> prerequisite2 = new ArrayList<>();
		prerequisite2.add(c1.getName());
		prerequisite2.add(c2.getName());
		prerequisite2.add(c3.getName());
		
		Course c4 = new Course("Video games design", prerequisite2);
		
		completed.add(c1);
		active.add(c2);
		
		Student s1 = new Student("John", "Doe", active, completed, 3);
		System.out.println(s1.summary());
		
	}
}
