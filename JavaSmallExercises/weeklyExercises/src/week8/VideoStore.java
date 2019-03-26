package week8;

import java.util.ArrayList;

public class VideoStore {
	ArrayList<Video> inventory = new ArrayList<>();

	public boolean addVideo(String title) {
		// If there is already a video with that title in the store’s inventory, print
		// out an error message and return false.
		for (Video v : this.inventory) {
			if (v.getTitle() == title)
				return false;
		}
		// Otherwise, add a new video with that title and return true.
		this.inventory.add(new Video(title));
		return true;
	}

	public Video getVideo(String title) {
		// Return the video whose title is title.
		for (Video v : this.inventory) {
			if (v.getTitle() == title)
				return v;
		}
		// If there is no video in the inventory with that title, print out an error
		// message and return null.
		return null;
	}

	public boolean checkOutVideo(String title) {
		// If there is a video with that title not already checked out, change its
		// status to checked out and return true
		for (Video v : this.inventory) {
			if (title.equals(v.getTitle()) && !v.isCheckedOut()) {
				return v.checkOut();
			} else {
				// Otherwise, print out an appropriate error message and return false.
				System.out.printf("\"%s\" is not available video in the inventory", title);
				return false;
			}
		}
		System.out.println("Inventory empty");
		return false;
	}

	public boolean returnVideo(Video video) {
		//what if the video is not contained?
		if (!inventory.contains(video)) {
			System.out.println("Sorry, this video did not come from this store");
			return false;
		}
		return video.returnToStore();
	}

	public void rateVideo(Video video, int rating) {
		video.addRating(rating);
	}

	public double getAverageRatingForVideo(Video video) {
		return video.getAverageRating();
	}

	public Video[] getCheckedOut() {
		ArrayList<Video> checkedOutVideos = new ArrayList<>();
		for (Video v : inventory) {
			if (v.isCheckedOut())
				checkedOutVideos.add(v);
		}
		Video[] returnedArray = new Video[checkedOutVideos.size()];
		return checkedOutVideos.toArray(returnedArray);
		
	}

	public Video mostPopular() {
//     Return the video which has the highest average ranking. If there is a tie, return the first one. If the store is not stocking any videos, return null;
		if (this.inventory.size() == 0)
			return null;
		else {
			Video mostPopularVideo = this.inventory.get(0);
			double highestAvgRating = mostPopularVideo.getAverageRating();
			for (int i = 1; i < this.inventory.size(); i++) {
				Video currentVid = this.inventory.get(i);
				double currentAvgRating = currentVid.getAverageRating();
				if (currentAvgRating > highestAvgRating) {
					mostPopularVideo = currentVid;
					highestAvgRating = currentAvgRating;
				}
			}
			return mostPopularVideo;
		}
	}

}
