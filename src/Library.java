import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library 
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
			sc.nextLine();
			Number = NumbersN(sc);
		}
		return Number;
	}
	
	
	public static void main(String[] args) {
		
		List<Book> Knihy = new ArrayList<Book>();

		Scanner sc=new Scanner(System.in);
		int Option;
		boolean run=true;
		
		SQLDatabase sqlDatabase = new SQLDatabase();
		sqlDatabase.Connect();
		sqlDatabase.CreateTable();
		sqlDatabase.LoadData(Knihy);
		while (run) 
		{
			System.out.println("╔═══════════════════════════════════════════════╗");
			System.out.println("║  Vyberte požadovanou činnost:                 ║");
			System.out.println("║  1 .. Přidání nové knihy                      ║");
			System.out.println("║  2 .. Úprava stávající knihy                  ║");
			System.out.println("║  3 .. Smazání požadované knihy                ║");
			System.out.println("║  4 .. Nastavení dostupnosti knihy             ║");
			System.out.println("║  5 .. Seznam všech knih                       ║");
			System.out.println("║  6 .. Vyhledání knihy v seznamu               ║");
			System.out.println("║  7 .. Výpis všech knih daného autora          ║");
			System.out.println("║  8 .. Výpis všech knih daného žánru           ║");
			System.out.println("║  9 .. Seznam vypůjčených knih                 ║");
			System.out.println("║ 10 .. Uložení informací o knize do souboru    ║");
			System.out.println("║ 11 .. Načtení informací o knize ze souboru    ║");
			System.out.println("║ 12 .. Ukončení aplikace                       ║");
			System.out.println("╚═══════════════════════════════════════════════╝");
			Option=NumbersN(sc);
			
			switch(Option) 
			{
				case 1:
					System.out.println("╔═════════════════════════════════════╗");
					System.out.println("║ Vyberte jakou knihu chcete přidat:  ║");
					System.out.println("║  1 .. Román                         ║");
					System.out.println("║  2 .. Učebnice                      ║");
					System.out.println("║  0 .. Zpět do hlavního menu         ║");
					System.out.println("╚═════════════════════════════════════╝");
					Option=NumbersN(sc);
					
					switch(Option) 
					{
						case 1:
							Functions.AddNovel(Knihy);
							break;
						case 2:
							Functions.AddTextBook(Knihy);
							break;
						case 0:
							System.out.println("Vracím zpět do hlavního menu.");
							break;
					}
					break;
					
				case 2:
					Functions.EditBook(Knihy);
					break;
				
				case 3:
					Functions.DeleteBook(Knihy);
					break;
				
				case 4:
					Functions.SetStatus(Knihy);
					break;
				
				case 5:
					Functions.PrintBooks(Knihy);
					break;
					
				case 6:
					Functions.PrintBooksByName(Knihy);
					break;
					
				case 7:
					Functions.PrintBooksByAuthor(Knihy);
					break;
					
				case 8:
					Functions.PrintBooksByGenre(Knihy);
					break;
					
				case 9:
					Functions.PrintBooksByBorrowed(Knihy);
					break;
					
				case 10:
					Functions.SaveBookInFile(Knihy);
					break;
					
				case 11:
					Functions.LoadBookFromFile(Knihy);
					break;
					
				case 12:
					sqlDatabase.SavaData(Knihy);
					sqlDatabase.Disconnect();
					System.out.println("Aplikace byla ukončena.");
					run=false;
					break;
				
			}
			
			
		}
	}

}
