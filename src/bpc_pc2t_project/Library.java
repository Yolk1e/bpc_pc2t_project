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
		
		//Book book = new Novel("Harry Potter and the Philosopher's Stone", List.of("J. K. Rowling"), 1997, true, Novel.Genres.Detektivní);
	
		//System.out.println(book);
	
	
	
	
	
	
		List<String> Authors = new ArrayList<String>();
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
							String Title;
							int Year;
							
														
							System.out.println("╔════════════════════════════════════════╗");
							System.out.println("║ Vyberte žánr vašeho románu z nabídky:  ║");
							System.out.println("║ 1 .. Detektivní                        ║");
							System.out.println("║ 2 .. Fantasy                           ║");
							System.out.println("║ 3 .. Scifi                             ║");
							System.out.println("║ 4 .. Venkovský                         ║");
							System.out.println("║ 5 .. Hororový                          ║");
							System.out.println("║ 0 .. Zpět do hlavního menu             ║");
							System.out.println("╚════════════════════════════════════════╝");
							Option=NumbersN(sc);
							
							switch(Option)
							{
								case 1:
									System.out.println("Zadejte název Vašeho románu, autora nebo autory, rok vydání.");
									Title=sc.next();
									Authors.add(sc.next());
									Year=sc.nextInt();
									Book book=new Novel(Title, Authors, Year, true, Novel.Genres.Detektivní);
									System.out.println(book);
									break;
								case 2:
									break;
								case 3:
									break;
								case 4:
									break;
								case 5:
									break;
								case 0:
									break;
							}
							break;
						case 2:
							break;
						case 0:
							break;
					}
					break;
					
				case 2:
					break;
				
				case 3:
					break;
				
				case 4:
					break;
				
				case 5:
					break;
					
				case 6:
					break;
					
				case 7:
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
