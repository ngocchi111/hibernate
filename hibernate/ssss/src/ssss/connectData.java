package ssss;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import com.sun.jdi.connect.spi.Connection;

public class connectData {
		 
	    private static Connection con;
	    private static String URL= "jdbc:mysql://localhost:3306/qlsv";
	    private static String USER = "root";
	    private static String PASSWORD ="ngocchi123";
	 
	    public static Connection getConnection() {
	        con = null;
            
	        try {
	            // driver register
	            System.out.print(1);
	            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	           // Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.print(2);
	            con = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
	            System.out.print(3);
	        } catch (SQLException ex) {
	        	System.out.print("can not connect");
	        }
	        return (con);
	    }
	 
	    public static void freeConnection() {
	        try {
	            con.close();
	        } catch (IOException ex) {
	        	 Logger.Level.ALL.getName();
	        }
	    }
	 
}
