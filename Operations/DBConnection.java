package rjdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;
/* This Program has JDBC Connection to DB and Fetch All Data Appear in DB.
 * JDBC : is a Basically API which is used to connect a Java Program to DB .
 * 
 * General To Step To Follow in JDBC
 * 1) Load the Diver Class
 * 2) Establish Connection to THe DB
 * 3) Create a SQL Stmt
 * 4) Execute the STMT
 * 5) Process the ResutlSet
 */
public class First {

	public static void main(String[] args) {
		             //api,vendor,IPAddress,PortNbr,DBN
		String url = "jdbc:mysql://localhost:3306/kiran";
		String un = "root"; // username
		String pswd = "root";  // password
		try {
			// 1) Load the Driver Class
			Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver class is Loaded");
            
            // 2) Establish Connection to DB
			Connection con = DriverManager.getConnection(url,un,pswd);
			System.out.println("Connection is Established");
			
			// 3) Create Sql Statement
			Statement stmt = con.createStatement();
			
			// 4) Execute Sql Queries/ Stmt
			String query = "select * from data";
			ResultSet res = stmt.executeQuery(query);
					
			// 5) Process Result
			while(res.next()==true)
			{
				int s_id = res.getInt(1);
				String name = res.getString(2);
				int age = res.getInt(3);
				String gender = res.getString(4);
				double phone  = res.getDouble(5);
				double salary = res.getDouble(6);
				
//				int s_id = res.getInt("s_id");
//				String name = res.getString("name");
//				int age = res.getInt("age");
//				String gender = res.getString("gender");
//				double phone  = res.getDouble("phone");
//				double salary = res.getDouble("salary");
				
				System.out.println(s_id +" "+name+" "+age+" "+gender+" "+phone+" "+salary);
			}
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
