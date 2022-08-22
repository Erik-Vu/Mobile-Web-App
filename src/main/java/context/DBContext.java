package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	public Connection getConnection() throws Exception {
		Connection conn = null;
		try {
		    // db parameters
		    String url       = "jdbc:mysql://localhost:3306/shoppingdb";
		    String user      = "root";
		    String password  = "hongquan2015";
		     
		    // create a connection to the database
		    conn = DriverManager.getConnection(url, user, password);
		    // more processing here  
		} catch(SQLException e) {
		   System.out.println(e.getMessage());
		} 
		return conn;
	}
	

}

