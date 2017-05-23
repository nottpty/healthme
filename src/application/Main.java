package application;

import java.sql.*;

/**
 * Main class that create application.
 * 
 * @author Narut Poovorakit
 *
 * @version 20.05.2017
 */
public class Main {
	public static void main(String[] args) {
		Connection c = null;
	    Statement stmt = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      c = DriverManager.getConnection("jdbc:sqlite:user.db");
	      System.out.println("Opened database successfully");

	      stmt = c.createStatement();
	      String sql = "CREATE TABLE USER " +
	                   "(NAME           TEXT    NOT NULL, " +
	                   " PASSWORD       TEXT    NOT NULL, " +
	                   " GENDER         TEXT    NOT NULL, " + 
	                   " ACTIVITY       TEXT    NOT NULL, " +
	                   " AGE        INT)"; 
	      stmt.executeUpdate(sql);
	      stmt.close();
	      c.close();
	      System.out.println("Table created successfully");
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    }
	    LoginUI loginUI = new LoginUI();
	    loginUI.run();
//	    StartUI startPage = new StartUI();
//		startPage.run();
	}
}
