package bpc_pc2t_project;

import java.util.List;

public class Library {

	public static void main(String[] args) {
		Book book;
			book=new Novel("Nazev", List.of("Autor1"), 2018, true, Novel.Genres.Fantasy);
	
	System.out.println(book);
	}

}
