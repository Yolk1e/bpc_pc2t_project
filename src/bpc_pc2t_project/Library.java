package bpc_pc2t_project;

import java.util.List;

public class Library {

	public static void main(String[] args) {
		
		Book book = new Novel("Harry Potter and the Philosopher's Stone", List.of("J. K. Rowling"), 1997, true, Novel.Genres.Fantasy);
	
	System.out.println(book);
	}

}
