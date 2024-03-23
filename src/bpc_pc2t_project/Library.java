package bpc_pc2t_project;

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
		
		/*Book book = new Novel("Harry Potter and the Philosopher's Stone", List.of("J. K. Rowling"), 1997, true, Novel.Genres.Fantasy);
	
		System.out.println(book);*/
	
	
	
	
	
	
	
		Scanner sc=new Scanner(System.in);
		int Option;
		boolean run=true;
	
		while (run) 
		{
			System.out.println("╔═══════════════════════════════════════════════╗");
			System.out.println("║  Vyberte pozadovanou cinnost:                 ║");
			System.out.println("║  1 .. Pridani nove knihy                      ║");
			System.out.println("║  2 .. Uprava stavajici knihy                  ║");
			System.out.println("║  3 .. Smazani pozadovane knihy                ║");
			System.out.println("║  4 .. Nastaveni dostupnosti knihy             ║");
			System.out.println("║  5 .. Seznam vsech knih                       ║");
			System.out.println("║  6 .. Vyhledani knihy v seznamu               ║");
			System.out.println("║  7 .. Vypis vsech knih daneho autora          ║");
			System.out.println("║  8 .. Vypis vsech knih daneho zanru           ║");
			System.out.println("║  9 .. Seznam vypujcenych knih                 ║");
			System.out.println("║ 10 .. Ulozeni informaci o knize do souboru    ║");
			System.out.println("║ 11 .. Nacteni informaci o knize ze souboru    ║");
			System.out.println("║ 12 .. Ukonceni aplikace                       ║");
			System.out.println("╚═══════════════════════════════════════════════╝");
			Option=NumbersN(sc);
			
			switch(Option) 
			{
				case 1:
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
