package bpc_pc2t_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Functions 
{
	
	
	static void EditBook(List<Book> Library) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Zadejte název knihy, kterou chcete upravit:");
		String Title = sc.nextLine();
		
		Book Selected = null;
		for (Book Book : Library) 
		{
			if(Book.getTitle().compareToIgnoreCase(Title) == 0) 
			{
				Selected = Book;
				break;
			}
			
		}
		
		if (Selected == null) 
		{
			System.out.println("Kniha s Vámi zadaným názvem " + Title + " nebyla nalezena!");
			return;
		}
		
		System.out.println("╔════════════════════════════════════════╗");
		System.out.println("║ Vyberte jaký parametr chcete upravit:  ║");
		System.out.println("║ 1 .. Autor/Autoři                      ║");
		System.out.println("║ 2 .. Rok vydání                        ║");
		System.out.println("║ 3 .. Stav dostupnosti                  ║");
		System.out.println("╚════════════════════════════════════════╝");
	
		int Choice = sc.nextInt();
		
		switch (Choice) 
		{
			case 1:
				System.out.println("Zadejte jméno/jména autorů, oddělené čárkou:");
				sc.nextLine();
				String[] AuthorsInput = sc.nextLine().split(",");
				
			    List<String> Authors = new ArrayList<>();
			    for (String Author : AuthorsInput) {
			        Authors.add(Author.trim());
			    }
			    
			    Selected.setAuthor(Authors);
			    System.out.println("Autor/autoři byli úspěšně změněni");
			    break;
			
			case 2:
				System.out.println("Zadejte nový rok vydáni knihy:");
				Selected.setReleaseYear(sc.nextInt());
				System.out.println("Rok vydání byl úspěšně změněn.");
				break;
				
			case 3:
				System.out.println("Zadejte nový stav dostupnosti (true/false):");
				Selected.setAvailability(sc.nextBoolean());
				System.out.println("Dostupnost byla úspěšně změněna.");
				break;
		}
		
	}
	
}
