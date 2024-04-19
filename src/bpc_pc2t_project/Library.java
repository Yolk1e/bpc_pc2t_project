package bpc_pc2t_project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library 
{
	//Konrola celych cisel. Numbers+N (N - cele cislo)
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
		
		
	
		//System.out.println(book);
	
	
		List<Book> Knihy = new ArrayList<Book>();
	
	
		Knihy.add(new Novel("Harry Potter", List.of("J. K. Rowling"), 1997, true, Novel.Genres.Fantasy));
		Knihy.add(new TextBook("Matematika", List.of("Mirek Hlava", "Michal Urban"), 1997, false, 8));
		Knihy.add(new TextBook("Matematika 2", List.of("Mirek Hlava", "Michal Urban"), 1985, false, 8));
		Knihy.add(new TextBook("Matematika 3", List.of("Mirek Hlava", "Michal Urban"), 2006, false, 8));
		Knihy.add(new TextBook("Pravděpodobnost a statistika", List.of("Mirek Hlava"), 2019, false, 8));
		Knihy.add(new Novel("Harry Potter 2", List.of("J. K. Rowling"), 1999, true, Novel.Genres.Fantasy));
		
		Scanner sc=new Scanner(System.in);
		int Option;
		boolean run=true;
	
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
							Functions.AddNovel(sc, Knihy);
						    break;
						case 2:
							Functions.AddTextBook(sc, Knihy);
							break;
						case 0:
							break;
					}
					break; //?? nemas tady na vic?
					
				case 2:
					Functions.EditBook(sc, Knihy);
					break;
				
				case 3:
					System.out.println(Knihy);
					Functions.DeleteBook(sc, Knihy);
					break;
				
				case 4:
					Functions.SetStatus(sc, Knihy);
					break;
				
				case 5:
					Functions.PrintBooks(Knihy);
					break;
					
				case 6:
					Functions.FindBookInfo(sc, Knihy);
					break;
					
				case 7:
					Functions.PrintBooksByAuthor(sc, Knihy);
					break;
					
				case 8:
					break;
					
				case 9:
					break;
					
				case 10:
					break;
					
				case 11:
					break;
					
				case 12:
					run=false;
					break;
				
			}
			
			
		}
	}

}
