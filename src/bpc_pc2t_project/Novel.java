package bpc_pc2t_project;

import java.util.List;

public class Novel extends Book
{
	public enum Genres
	{
		Romance,
		Fantasy,
		Scifi,
		Detective,
		Horror
	}
	
	private Genres Genre;
	
	public Genres getGenre() {
		return Genre;
	}

	public void setGenre(Genres Genre) {
		this.Genre = Genre;
	}
	
	public Novel(String Title, List<String> Author, int ReleaseYear, boolean Availability, Genres Genre) {
		super(Title, Author, ReleaseYear, Availability);
		this.Genre = Genre;
	}
	
	@Override
    public String toString() {
        return super.toString() + ", Genre: " + Genre;
    }
}
