package bpc_pc2t_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Functions 
{
	//private Scanner sc;
	public static int NumbersN(Scanner sc) 
	{
		int Number = 0;
		try
		{
			Number = sc.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Zadali jste neco jineho, nez je vyzadovano. Zadejte prosim cele cislo ");
			//sc.nextLine(); 
			sc = new Scanner(System.in);
			Number = NumbersN(sc);
		}
		return Number;
	}
	
	static void AddNovel(Scanner sc, List<Book> Library) 
	{
		String Title;
	    int Year;
	    
	    System.out.println("Zadejte název románu:");
	    //sc.nextLine();
	    sc = new Scanner(System.in);
	    Title = sc.nextLine();
	    
	    System.out.println("Zadejte autora/autory románu (oddělené čárkou):");
	    String[] AuthorsInput = sc.nextLine().split(",");
	    List<String> Authors = new ArrayList<>();
	    for (String Author : AuthorsInput) {
	        Authors.add(Author.trim());
	    }
	    
	    System.out.println("Zadejte rok vydání románu:");
	    Year = NumbersN(sc);
	    
	    Novel.Genres Genre = null;
	    boolean validChoice = false;
	    do {
	    	System.out.println("╔════════════════════════════════════════╗");
			System.out.println("║ Vyberte žánr vašeho románu z nabídky:  ║");
			System.out.println("║ 1 .. Detektivní                        ║");
			System.out.println("║ 2 .. Fantasy                           ║");
			System.out.println("║ 3 .. Scifi                             ║");
			System.out.println("║ 4 .. Venkovský                         ║");
			System.out.println("║ 5 .. Hororový                          ║");
			System.out.println("╚════════════════════════════════════════╝");
	        int GenreOption = NumbersN(sc);
	        switch (GenreOption) {
	            case 1:
	                Genre = Novel.Genres.Detektivní;
	                validChoice = true;
	                break;
	            case 2:
	                Genre = Novel.Genres.Fantasy;
	                validChoice = true;
	                break;
	            case 3:
	                Genre = Novel.Genres.Scifi;
	                validChoice = true;
	                break;
	            case 4:
	                Genre = Novel.Genres.Venkovský;
	                validChoice = true;
	                break;
	            case 5:
	                Genre = Novel.Genres.Hororový;
	                validChoice = true;
	                break;
	            default:	                
	            	System.out.println("Neplatná volba. Zadejte prosím platný žánr.");
	        }
	    } while (!validChoice);
	    
		
	    Library.add(new Novel(Title, Authors, Year, true, Genre));
	    
	    System.out.println("Román byl úspěšně přidán do knihovny.");
	    System.out.println(Library);
	}
	
	static void AddTextBook(Scanner sc, List<Book> Library) 
	{
		String Title;
	    int Year;
	    
	    System.out.println("Zadejte název učebnice:");
	    //sc.nextLine();
	    sc = new Scanner(System.in);
	    Title = sc.nextLine();
	    
	    System.out.println("Zadejte autora/autory učebnice (oddělené čárkou):");
	    String[] AuthorsInput = sc.nextLine().split(",");
	    List<String> Authors = new ArrayList<>();
	    for (String Author : AuthorsInput) {
	        Authors.add(Author.trim());
	    }
	    
	    System.out.println("Zadejte rok vydání učebnice:");
	    Year = NumbersN(sc);
	    
	    System.out.println("Zadejte ročník učebnice (1-9):");
	    int Grade;
	    while (true) 
	    {
	        Grade = NumbersN(sc);
	        if (Grade >= 1 && Grade <= 9)
	            break; 
	        else
	            System.out.println("Zadali jste číslo mimo povolený rozsah. Zadejte prosím ročník v intervalu (1-9):");
	    }
	    
	    Library.add(new TextBook(Title, Authors, Year, true, Grade));
	    
	    System.out.println("Učebnice byla úspěšně přidána do knihovny.");
	    System.out.println(Library);
	}
	
	static void EditBook(Scanner sc, List<Book> Library) 
	{
		
		System.out.println("Zadejte název knihy, kterou chcete upravit:");
		sc = new Scanner(System.in);
		//sc.nextLine(); //Problém s instantním scannem
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
				//sc.nextLine();
				sc = new Scanner(System.in);
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
				System.out.println("V aktuální chíli je tato kniha: " + (Selected.isAvailability() ? "K dispozici" : "Vypujcena") + ".");
				System.out.println("Chcete tento stav změnit na: " + (Selected.isAvailability() ? "Vypujcena" : "K dispozici") + "?" );
				System.out.println("╔═══════════╗");
				System.out.println("║ 1 .. Ano  ║");
				System.out.println("║ 2 .. Ne   ║");
				System.out.println("╚═══════════╝");
				int Option = sc.nextInt();
				if(Option == 1) 
				{
					if(Selected.isAvailability() == true) 
					{
						Selected.setAvailability(false);
					}
					else if(Selected.isAvailability() == false) 
					{
						Selected.setAvailability(true);
					}
					System.out.println("Dostupnost byla úspěšně změněna.");
				}
				else if(Choice == 2)
				{
					System.out.println("Dostupnost nebyla změněna.");
				}
				else
				{
					System.out.println("Byla zadána neplatná volba. Vracím do hlavního menu.");
				}
				break;
		}
		
	}
	
	static void SetStatus(Scanner sc, List<Book> Library) 
	{
		System.out.println("Zadejte název knihy, kterou chcete upravit:");
		//sc.nextLine(); //Problém s instantním scannem
		sc = new Scanner(System.in);
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
		
		System.out.println("V aktuální chíli je tato kniha: " + (Selected.isAvailability() ? "K dispozici" : "Vypujcena") + ".");
		System.out.println("Chcete tento stav změnit na: " + (Selected.isAvailability() ? "Vypujcena" : "K dispozici") + "?" );
		System.out.println("╔═══════════╗");
		System.out.println("║ 1 .. Ano  ║");
		System.out.println("║ 2 .. Ne   ║");
		System.out.println("╚═══════════╝");
		int Choice = sc.nextInt();
		if(Choice == 1) 
		{
			if(Selected.isAvailability() == true) 
			{
				Selected.setAvailability(false);
			}
			else if(Selected.isAvailability() == false) 
			{
				Selected.setAvailability(true);
			}
			System.out.println("Dostupnost byla úspěšně změněna.");
		}
		else if(Choice == 2)
		{
			System.out.println("Dostupnost nebyla změněna.");
			return;
		}
		else
		{
			System.out.println("Byla zadána neplatná volba. Vracím do hlavního menu.");
			return;
		}
		
	}
}
