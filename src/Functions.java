import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Functions 
{
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
			sc = new Scanner(System.in);
			Number = NumbersN(sc);
		}
		return Number;
	}
	
	static void AddNovel(List<Book> Library) 
	{
		String Title;
	    int Year;
	    
	    System.out.println("Zadejte název románu:");
	    Scanner sc = new Scanner(System.in);
	    Title = sc.nextLine();
	    
	    System.out.println("Zadejte autora/autory románu (oddělené čárkou):");
	    String[] AuthorsInput = sc.nextLine().split(",");
	    List<String> Authors = new ArrayList<>();
	    for (String Author : AuthorsInput)
	        Authors.add(Author.trim());
	    
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
			switch(sc.nextInt()) {
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
	    return;
	}
	
	static void AddTextBook(List<Book> Library) 
	{
		String Title;
	    int Year;
	    
	    System.out.println("Zadejte název učebnice:");
	    Scanner sc = new Scanner(System.in);
	    Title = sc.nextLine();
	    
	    System.out.println("Zadejte autora/autory učebnice (oddělené čárkou):");
	    String[] AuthorsInput = sc.nextLine().split(",");
	    List<String> Authors = new ArrayList<>();
	    for (String Author : AuthorsInput)
	        Authors.add(Author.trim());
	    
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
	    return;
	}
	
	static void EditBook(List<Book> Library) 
	{
		System.out.println("Zadejte název knihy, kterou chcete upravit:");
		Scanner sc = new Scanner(System.in);
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
	
		switch (sc.nextInt()) 
		{
			case 1:
				System.out.println("Zadejte jméno/jména autorů, oddělené čárkou:");
				sc = new Scanner(System.in);
				String[] AuthorsInput = sc.nextLine().split(",");
				
			    List<String> Authors = new ArrayList<>();
			    for (String Author : AuthorsInput)
			        Authors.add(Author.trim());
			    
			    Selected.setAuthor(Authors);
			    System.out.println("Autor/autoři byli úspěšně změněni");
			    break;
			
			case 2:
				System.out.println("Zadejte nový rok vydáni knihy:");
				Selected.setReleaseYear(sc.nextInt());
				System.out.println("Rok vydání byl úspěšně změněn.");
				break;
				
			case 3:
				System.out.println("V aktuální chvíli je tato kniha: " + (Selected.isAvailability() ? "K dispozici" : "Vypůjčena") + ".");
				System.out.println("Chcete tento stav změnit na: " + (Selected.isAvailability() ? "Vypůjčena" : "K dispozici") + "?" );
				System.out.println("╔═══════════╗");
				System.out.println("║ 1 .. Ano  ║");
				System.out.println("║ 2 .. Ne   ║");
				System.out.println("╚═══════════╝");

				if(sc.nextInt() == 1)
				{
					if(Selected.isAvailability() == true) 
						Selected.setAvailability(false);
					else if(Selected.isAvailability() == false) 
						Selected.setAvailability(true);
					System.out.println("Dostupnost byla úspěšně změněna.");
				}
				else if(sc.nextInt() == 2)
					System.out.println("Dostupnost nebyla změněna.");
				else
					System.out.println("Byla zadána neplatná volba. Vracím do hlavního menu.");
				break;
			default:
				System.out.println("Byla zadána neplatná volba. Vracím do hlavního menu.");
				
		}
		
	}
	
	static void SetStatus(List<Book> Library) 
	{
		System.out.println("Zadejte název knihy, kterou chcete upravit:");
		Scanner sc = new Scanner(System.in);
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
		
		System.out.println("V aktuální chvíli je tato kniha: " + (Selected.isAvailability() ? "K dispozici" : "Vypůjčena") + ".");
		System.out.println("Chcete tento stav změnit na: " + (Selected.isAvailability() ? "Vypůjčena" : "K dispozici") + "?" );
		System.out.println("╔═══════════╗");
		System.out.println("║ 1 .. Ano  ║");
		System.out.println("║ 2 .. Ne   ║");
		System.out.println("╚═══════════╝");

		if(sc.nextInt() == 1) 
		{
			if(Selected.isAvailability() == true) 
				Selected.setAvailability(false);
			else if(Selected.isAvailability() == false) 
				Selected.setAvailability(true);
			System.out.println("Dostupnost byla úspěšně změněna.");
		}
		else if(sc.nextInt() == 2)
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
		
	static void DeleteBook(List<Book> Library) 
	{
		System.out.println("Zadejte název knihy, kterou chcete odstranit:");
		Scanner sc = new Scanner(System.in);
		String Title = sc.nextLine();
			
		Book Selected = null;
		for (Book Book : Library) 
		{
			if(Book.getTitle().compareToIgnoreCase(Title) == 0) 
			{
				Selected = Book;
				Library.remove(Book);
				System.out.println("Kniha s Vámi zadaným názvem " + Title + " byla odstraněna.");
				break;
			}	
		}
			
		if (Selected == null) 
		{
			System.out.println("Kniha s Vámi zadaným názvem " + Title + " nebyla nalezena!");
			return;
		}
	}
	
	static void PrintBooks(List<Book> Library) 
	{
		if (Library.isEmpty())
		{
			System.out.println("V knihovně nebyli nalezeny žádné knihy.");
			return;
		}
		
		Collections.sort(Library, Comparator.comparing(Book::getTitle));
		
		for (Book Book : Library) 
		{
			System.out.print(Book.getTitle() + " od " + String.join(", ", Book.getAuthor()));
			if (Book instanceof Novel) 
			{
				System.out.print(", Žánr: " + ((Novel) Book).getGenre());
			}
			else if (Book instanceof TextBook)
			{
				System.out.print(", Ročník: " + ((TextBook) Book).getGrade());
			}
			System.out.print(", Rok vydání: " + Book.getReleaseYear() + ", Dostupnost: " + (Book.isAvailability() ? "K dispozici" : "Vypůjčena") + "\n");
		}
	}
	
	static void PrintBooksByName(List<Book> Library) 
	{
		System.out.println("Zadejte název knihy, o které chcete zjistit informace:");
		Scanner sc = new Scanner(System.in);
		String Title = sc.nextLine();
			
		Book Selected = null;
		for (Book Book : Library) 
		{
			if(Book.getTitle().compareToIgnoreCase(Title) == 0) 
			{
				Selected = Book;
				System.out.print(Book.getTitle() + " od " + String.join(", ", Book.getAuthor()));
				if (Book instanceof Novel) 
				{
					System.out.print(", Žánr: " + ((Novel) Book).getGenre());
				}
				else if (Book instanceof TextBook)
				{
					System.out.print(", Ročník: " + ((TextBook) Book).getGrade());
				}
				System.out.print(", Rok vydání: " + Book.getReleaseYear() + ", Dostupnost: " + (Book.isAvailability() ? "K dispozici" : "Vypůjčena") + "\n");
				break;
			}	
		}
			
		if (Selected == null) 
		{
			System.out.println("Kniha s Vámi zadaným názvem " + Title + " nebyla nalezena!");
			return;
		}
	}
	
	static void PrintBooksByAuthor (List<Book> Library)
	{
		System.out.println("Zadejte jméno autora, o kterém chcete zjistit jeho vydané knihy:");
		Scanner sc = new Scanner(System.in);
		String Author = sc.nextLine();
		
		Collections.sort(Library, Comparator.comparingInt(Book::getReleaseYear));
		
		boolean AuthorFound = false;
		for (Book Book : Library) 
		{	
			for (String BookAuthor : Book.getAuthor()) 
			{
	            if (BookAuthor.equalsIgnoreCase(Author))  
				{
					AuthorFound = true;
					System.out.print(Book.getTitle() + " od " + String.join(", ", Book.getAuthor()));
					if (Book instanceof Novel) 
					{
						System.out.print(", Žánr: " + ((Novel) Book).getGenre());
					}
					else if (Book instanceof TextBook)
					{
						System.out.print(", Ročník: " + ((TextBook) Book).getGrade());
					}
					System.out.print(", Rok vydání: " + Book.getReleaseYear() + ", Dostupnost: " + (Book.isAvailability() ? "K dispozici" : "Vypůjčena") + "\n");
					break;
				}
			}
		}
	            
		if (!AuthorFound)
		{
			System.out.println("Kniha s Vámi zadaným autorem " + Author + " nebyla nalezena!");
			return;
		}
	}
	
	static void PrintBooksByGenre(List<Book> Library)
	{
		Scanner sc = new Scanner(System.in);
		boolean BookOfGenre = false;
		Novel.Genres Genre = null;
		boolean validChoice = false;
	    do {
	    	System.out.println("╔════════════════════════════════════════╗");
			System.out.println("║ Vyberte žánr který chcete vypsat:      ║");
			System.out.println("║ 1 .. Detektivní                        ║");
			System.out.println("║ 2 .. Fantasy                           ║");
			System.out.println("║ 3 .. Scifi                             ║");
			System.out.println("║ 4 .. Venkovský                         ║");
			System.out.println("║ 5 .. Hororový                          ║");
			System.out.println("╚════════════════════════════════════════╝");

			switch(NumbersN(sc)) {
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
	    
	    System.out.println("Všechny knihy žánru " + Genre + ":");
	    
	    for (Book Book : Library) 
	    {
	    	if (Book instanceof Novel) 
	    	{
	    		if (((Novel) Book).getGenre().equals(Genre)) 
	    		{
	    			BookOfGenre = true;
	    			System.out.print(Book.getTitle() + " od " + String.join(", ", Book.getAuthor()));
	    			System.out.print(", Rok vydání: " + Book.getReleaseYear() + ", Dostupnost: " + (Book.isAvailability() ? "K dispozici" : "Vypůjčena") + "\n");
	    		}    			
	    	}
	    }
	    if (!BookOfGenre) 
	    {
	    	System.out.println("Nebyla nalezena žádná kniha s tímto žánrem.");
	    }
	}
	
	static void PrintBooksByBorrowed (List<Book> Library) 
	{
		boolean BorrowedBooks = false;
		System.out.println("Seznam vypůjčených knih:");
		for (Book Book : Library) 
		{
			if (!Book.isAvailability()) 
			{
				BorrowedBooks = true;
				System.out.print(Book.getTitle() + " od " + String.join(", ", Book.getAuthor()));
				if (Book instanceof Novel) 
				{
					System.out.println(", Typ knihy: Román");
				}
				else if (Book instanceof TextBook) 
				{
					System.out.println(", Typ knihy: Učebnice");
				}
			}
		}
		
		if (!BorrowedBooks) 
		{
			System.out.println("Nebyla nalezena žádná vypůjčené kniha.");
		}
	}
	
	static void SaveBookInFile(List<Book> Library) 
	{
		System.out.println("Zadejte název knihy, o kterou chcete uložit do souboru:");
		Scanner sc = new Scanner(System.in); 
		boolean BookFounded = false;
		String Title = sc.nextLine();
		
		for (Book Book : Library) 
		{
			if (Book.getTitle().compareToIgnoreCase(Title) == 0) 
			{
				BookFounded = true;
				try (FileWriter Writer = new FileWriter(Title + ".txt"))
				{
					Writer.write(Book.getTitle() + " od " + String.join(", ", Book.getAuthor()));
					if (Book instanceof Novel) 
					{
						Writer.write(", Žánr: " + ((Novel) Book).getGenre());
					}
					else if (Book instanceof TextBook)
					{
						Writer.write(", Ročník: " + ((TextBook) Book).getGrade());
					}
					Writer.write(", Rok vydání: " + Book.getReleaseYear() + ", Dostupnost: " + (Book.isAvailability() ? "K dispozici" : "Vypůjčena") + "\n");
					System.out.println("Kniha " + Title + " byla uložena do souboru " + Title + ".txt.");
					Writer.close();
				}
				catch (IOException e) 
				{
					System.out.println("Chyba při zápisu do souboru " + Title + ".txt.");
					e.printStackTrace();
				}
				break;
			}
		}
		
		if (!BookFounded) 
		{
			System.out.println("Kniha s Vámi zadaným názvem " + Title + " nebyla nalezena!");
		}
	}
	
	static void LoadBookFromFile(List<Book> Library) 
	{
		System.out.println("Zadejte název knihy, o které chcete načíst informace ze souboru:");
		Scanner sc = new Scanner(System.in); 
		String Filename = (sc.nextLine() + ".txt");
		BufferedReader Reader = null;
		try
		{
			Reader = new BufferedReader(new FileReader(Filename));
			String line = Reader.readLine();
			while(line != null)
			{
				String Title = line.split( " od ")[0];
				String AuthorsPart = line.split( " od ")[1];
				String AuthorsOnly = "", TypePart = "", Genre = "", grade = "";
				
				if(AuthorsPart.contains("Ročník"))
				{
					AuthorsOnly = AuthorsPart.split( ", Ročník: ")[0];
					TypePart = line.split(", Ročník: ")[1];
					grade = TypePart.split(",")[0];
				}
				else
				{
					AuthorsOnly = AuthorsPart.split( ", Žánr: ")[0];
					TypePart = line.split(", Žánr: ")[1];
					Genre = TypePart.split(",")[0];
				}
				
				List<String> Authors = new ArrayList<>();
				for (String Author : AuthorsOnly.split(", "))
					Authors.add(Author);
					
				String Year = line.split(", Rok vydání: ")[1];
				int ReleaseYear = Integer.parseInt(Year.split(", Dostupnost: ")[0]);
				boolean Availability = line.split(", Dostupnost: ")[1].equalsIgnoreCase("K dispozici");
				
				if (Genre != "") 
				{
					Library.add(new Novel(Title, Authors, ReleaseYear, Availability, Novel.Genres.valueOf(Genre)));
				}
				else
				{
					int Grade = Integer.parseInt(grade.split(",")[0]);
					Library.add(new TextBook(Title, Authors, ReleaseYear, Availability, Grade));
				}
				System.out.println("Kniha " + Title + " byla úspěšně přidána.");
				return;
			}
			Reader.close();
		}
		catch (IOException e) 
		{
			System.out.println("Chyba při čtení ze souboru " + Filename);
		}
	}
}
