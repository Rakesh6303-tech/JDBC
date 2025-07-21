package rjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.*;
public class AddData {
	public static void main(String[] args) {
	         	             //api,vendor,IPAddress,PortNbr,DBN
				String url = "jdbc:mysql://localhost:3306/kiran";
				String un = "root"; // username
				String pswd = "root";  // password
				try {	
					Class.forName("com.mysql.cj.jdbc.Driver");      
					Connection con = DriverManager.getConnection(url,un,pswd);
					Statement stmt = con.createStatement();
					// Insert Record Insert into DB
					String query = "INSERT INTO data (s_id,name,age,gender,salary,phone)VALUES(4,'rakesh',23,'male',650000,6303155035)";
					// Executes query passed & returns number of records effected
					int i = stmt.executeUpdate(query);
					System.out.println(i);
					System.out.println("Data is Executed Successfully");
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
