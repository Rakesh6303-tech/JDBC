/*
  Adding Multiple Records By using Batch-Processing
*/
package rjdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
public class InsertMultipleRecords {
	public static void main(String[] args) {
		String url ="jdbc:mysql://localhost:3306/kiran";
		String un = "root";
		String up = "root";
		String query = "Insert into data(s_id,name,age,gender,salary,phone)values (?,?,?,?,?,?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,un,up);
			PreparedStatement pstmt = con.prepareStatement(query);
			   con.setAutoCommit(false);
            String s;			
do {
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
	pstmt.addBatch();
	System.out.println("Would you like to insert one more record? Please yes or No");
	s =scan.next();
  
  }while(s.equalsIgnoreCase("yes"));
   int [] updatecount = pstmt.executeBatch();
     con.commit(); 
		}
		
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

	}

}
