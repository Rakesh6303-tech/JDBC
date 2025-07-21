/* Batch Processing : allows you to execute multiple queries at once by hitting the database only once.
                      this increases efficiency  because. without {BP} you would need to individually send n Queries,
                      resulting in hit to the DB n times.
  */


package rjdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;
public class BatchingProcessing {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/kiran";
		String un = "root"; // username
		String pswd = "root";  // password
		try {			
			Class.forName("com.mysql.cj.jdbc.Driver");      
			Connection con = DriverManager.getConnection(url,un,pswd);
			Statement stmt = con.createStatement();
			// Insert Record Insert into DB
			String query1 = "INSERT INTO data (s_id,name,age,gender,salary,phone)VALUES(5,'balayya',19,'male',23000,9876453729)";
			String query2 = "INSERT INTO data (s_id,name,age,gender,salary,phone)VALUES(6,'madhu',13,'male',30000,8907652431)";
			String query3 = "INSERT INTO data (s_id,name,age,gender,salary,phone)VALUES(7,'harry',33,'male',400000,8564789304)";	
			// Sql stmts are added to the using the addBatch()
			stmt.addBatch(query1);
			stmt.addBatch(query2);
			stmt.addBatch(query3);
			
			int res [] = stmt.executeBatch();
		
            System.out.println("Batch Execution Result:");
            for (int count : res) {
                System.out.println("Affected Rows: " + count);
            }
            stmt.close();
            con.close();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
