
import java.util.List;

public abstract class Book 
{
	private String Title;
	private List<String> Author;
	
	private int ReleaseYear;
	
	private boolean Availability;
	
	
	public Book(String title, List<String> author, int releaseYear, boolean availability) 
	{
		super ();
		this.setTitle(title);
		this.setAuthor(author);
		this.setReleaseYear(releaseYear);
		this.setAvailability(availability);
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
		String Status = Availability ? "K dispozici" : "Vypujceno";
        return Title + " od " + String.join(", ", Author) + " (" + ReleaseYear + "), Dostupnost: " + Status;
    }
}
