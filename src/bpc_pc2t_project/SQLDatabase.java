package bpc_pc2t_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SQLDatabase {
	
	private Connection conn;
	
	public boolean Connect() {
		conn = null;
		try {conn = DriverManager.getConnection("jdbc:sqlite:myDB.db");
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	public void Disconnect() {
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public boolean CreateTable() {
		if (conn == null)
			return false;
		
		String query = "CREATE TABLE IF NOT EXISTS Books (" +
				"id integer PRIMARY KEY," +
				"title VARCHAR(255) NOT NULL," +
                "author VARCHAR(255) NOT NULL," +
                "release_year INT NOT NULL," +
                "type VARCHAR(255) NOT NULL," +
                "genre VARCHAR(255)," +
                "grade INT," +
                "availability BOOLEAN NOT NULL)";
		
		try {
			Statement stmt = conn.createStatement();
			stmt.execute(query);
			return true;
		}
		catch (SQLException e) {
		    System.out.println(e.getMessage());
	    }
		return false;
		

	}
	
	public void SavaData(List <Book> Library) {
		DeleteAllData();
		String query = "INSERT INTO Books (title,author,release_year,type,genre,grade,availability) VALUES (?,?,?,?,?,?,?)";
		try {
			for (Book Book : Library) {
					PreparedStatement pstmt = conn.prepareStatement(query); 
					pstmt.setString(1, Book.getTitle());
					System.out.println(Book.getTitle());
					pstmt.setString(2, String.join(", ", Book.getAuthor()));
					System.out.println(Book.getAuthor());
					pstmt.setInt(3, Book.getReleaseYear());
					System.out.println(Book.getReleaseYear());
				if (Book instanceof Novel) {
					pstmt.setString(4, "Novel");
					
					pstmt.setString(5, Novel.getGenre().toString());
					System.out.println(Novel.getGenre().toString());
					pstmt.setNull(6, Types.INTEGER);
				}
				else {
					pstmt.setString(4, "TextBook");
					pstmt.setString(5, null);
					pstmt.setInt(6, TextBook.getGrade());
				}
				pstmt.setBoolean(7, Book.isAvailability());
				System.out.println(Book.isAvailability());
				pstmt.executeUpdate();
			}
			System.out.println("Data byla uložena do databáze.");
		}
		catch (SQLException e) {
	        System.out.println("Chyba při ukládání dat do databáze.");
	    }
	}
	
	public void LoadData (List<Book> Library) {
		String query = "SELECT id,title,author,release_year,type,genre,grade,availability FROM Books";
		try {
				PreparedStatement pstmt = conn.prepareStatement(query);
				ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt(1));
				String Title = rs.getString(2);
				System.out.println(Title);
				String[] AuthorsInput = rs.getString(3).split(", ");
			    List<String> Authors = Arrays.asList(AuthorsInput);
				System.out.println(Authors);
			    int ReleaseYear = rs.getInt(4);
				System.out.println(ReleaseYear);
			    Boolean Availability = rs.getBoolean(8);
				System.out.println(Availability);
			    if ("Novel".equals(rs.getString(5))) 
				{
			    	Novel.Genres Genre = Novel.Genres.valueOf(rs.getString(6));
					System.out.println(Genre);
			    	Library.add(new Novel(Title, Authors, ReleaseYear, Availability, Genre));
				}
				else
				{
					int Grade = rs.getInt(7);
					System.out.println(Grade);
					Library.add(new TextBook(Title, Authors, ReleaseYear, Availability, Grade));
				}
			}
			System.out.println("Data byla načtena z databáze.");
		}
		catch (SQLException e) {
	        System.out.println("Chyba při načítání dat z databáze.");
	    }
	}
	
	public void DeleteAllData() {
	    String query = "DELETE FROM Books";
	    try {
	        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	            pstmt.executeUpdate();
	        } 
	    } catch (SQLException e) {
	        System.out.println("Chyba při mazání dat z databáze: " + e.getMessage());
	    }
	}
}
