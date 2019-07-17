package week8;

import java.util.ArrayList;

public class Video{
	private final String title;
	private boolean checked = false;	
	
	private ArrayList<Integer> ratings = new ArrayList<>();	


	public Video(String title){
		this.title = title;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public boolean addRating(int rating){
		if (1 <= rating && rating <= 5){ //if the rating is between 1 and 5 (inclusive), 
			ratings.add(rating);
			return true;		
		} else{
			System.out.printf("%d should be between 1 and 5.\n", rating);
			return false;
		}
	}	
	public double getAverageRating(){
		if (ratings.isEmpty()) return 0;
		else {
			double total = 0; //initialise total (ratings) to zero
			for (int r: ratings) total+=r; //Add each rating to total;
			return total/this.ratings.size(); //return the average by dividing by the number of ratings
		}
	}
	public boolean checkOut(){
		//     If the video is already checked out, warn the user and return false. Otherwise change the status of the video to checked out, and return true. 
		if (this.checked){
			System.out.printf("%s is already checked out.\n", this.toString());
			return false;
		} else{
			this.checked = true;
			return true;
		}
	}
	public boolean returnToStore(){
		if (!this.checked){
			System.out.printf("Video[title=\"%s\", checkedOut=%s] is not checked out.\n", this.title, this.checked);
			return false;
			
		} else{
			this.checked = false;
			return true;
		}
	}
	public boolean isCheckedOut(){
		return this.checked;
	}

	public String toString(){
	//     Return a String of the form Video[title="<title>", checkedOut=<status>]. 
		return ("Video[title=\""+ this.title  +"\", checkedOut=" + this.checked  +"]");
	}

}
