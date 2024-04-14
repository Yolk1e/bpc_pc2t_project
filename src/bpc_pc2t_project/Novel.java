package bpc_pc2t_project;

import java.util.List;

public class Novel extends Book
{
	//Seznam dostupných žánrů a vytvoření "Datového typu"
	public enum Genres
	{
		Detektivní,
		Fantasy,
		Scifi,
		Venkovský,
		Hororový
	}
	
	private static Genres Genre;
	
	public static Genres getGenre() {
		return Genre;
	}

	public void setGenre(Genres Genre) {
		Novel.Genre = Genre;
	}
	
	public Novel(String title, List<String> author, int releaseYear, boolean availability, Genres genre) {
		super(title, author, releaseYear, availability);
		setGenre(genre);
	}
	
	//Přidání žánru k výpisu knihy
	@Override
    public String toString() {
        return super.toString() + ", Zanr: " + Genre;
    }
}
