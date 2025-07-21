package rjdbc;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class DeleteRecord {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/kiran";
		String un = "root"; // UN
		String pswd = "root";  // UP
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,un,pswd);
			Statement stmt = con.createStatement();
			// Delete Query
			String query  = "delete from data where s_id = 9";
			// Executes query passed & returns number of records effected
			int i = stmt.executeUpdate(query);
			System.out.println("Delete success :"+ i);

		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	}

