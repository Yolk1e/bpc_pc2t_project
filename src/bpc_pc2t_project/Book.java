package bpc_pc2t_project;

import java.util.List;

public abstract class Book 
{
	private String Title;
	
	private List<String> Author;
	
	private int ReleaseYear;
	
	private boolean Availability;
	
	
	public Book(String Title, List<String> Author, int ReleaseYear, boolean Availability) 
	{
		super ();
		this.Title = Title;
		this.Author = Author;
		this.ReleaseYear = ReleaseYear;
		this.Availability = Availability;
	}


	public String getTitle() {
		return Title;
	}


	public void setTitle(String title) {
		Title = title;
	}


	public List<String> getAuthor() {
		return Author;
	}


	public void setAuthor(List<String> author) {
		Author = author;
	}


	public int getReleaseYear() {
		return ReleaseYear;
	}


	public void setReleaseYear(int releaseYear) {
		ReleaseYear = releaseYear;
	}


	public boolean isAvailability() {
		return Availability;
	}

	public void setAvailability(boolean availability) {
		Availability = availability;
	}
	
	@Override
    public String toString() {
		String Status = Availability ? "Available" : "Not available";
        return Title + " by " + String.join(", ", Author) + " (" + ReleaseYear + "), Availability: " + Status;
    }
}