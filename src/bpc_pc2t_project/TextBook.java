package bpc_pc2t_project;

import java.util.List;

public class TextBook extends Book 
{
	private int Grade;
	
	public TextBook(String Title, List<String> Author, int ReleaseYear, boolean Availability, int Class) {
		super(Title, Author, ReleaseYear, Availability);
		this.setGrade(Class);
	}

	public int getGrade() {
		return Grade;
	}

	public void setGrade(int grade) {
		Grade = grade;
	}
	
	@Override
    public String toString() {
        return super.toString() + ", Rocnik: " + Grade;
    }
}
