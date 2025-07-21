Prepared Statement : A PS executes sql queries by allowing Dynamic Insertion of values Into the Query. 
                      And which is used when Query is in Complete.
  Using Setters : set the actual values for the parameters in the prepared statement using setters.

  Different Types : 
                   Integer -setInt(int parameter index, int x)
                   String -setString(int parameter index, String x)
                   Long   -setLong(Long parameter index, Long x)
  Example : 
            pstmt.setint(1,scan.nextInt());
  
package rjdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class PreparedStmts {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/kiran";
		String un = "root";
		String up = "root";
		// Incomplete Query
		String query = "INSERT INTO data (s_id,name,age,gender,salary,phone)VALUES(?,?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url,un,up);
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter s_id");
			// Setting Actual Parameters 
			pstmt.setInt(1,scan.nextInt());
			System.out.println("Enter name");
			pstmt.setString(2, scan.next());
			System.out.println("Enter age");
			pstmt.setInt(3, scan.nextInt());
			System.out.println("Enter gender");
			pstmt.setString(4, scan.next());
			System.out.println("Enter salary");
			pstmt.setInt(5, scan.nextInt());
			System.out.println("Enter phone");
			pstmt.setLong(6, scan.nextLong());			
			int i = pstmt.executeUpdate();			
			System.out.println("Successfully Inserted "+ i + " row");		
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
