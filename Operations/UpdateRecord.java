package rjdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;
public class UpdateData {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/kiran";
		String un = "root"; // username
		String pswd = "root";  
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,un,pswd);
			Statement stmt = con.createStatement();
			// Update Query
			String query  = "update data SET salary = 70000 where s_id=2";
			// Executes query passed & returns number of records effected
			int i = stmt.executeUpdate(query);
			System.out.println("update success :"+ i);

		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}

	}

}
