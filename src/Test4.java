import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test4 {

	public static void main(String[] args) {
		String username = "root";
		String password = "Root@123";
		String url = "jdbc:mysql://localhost:3306/jdbc";
		
		try {
			//load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			//creating connection
			Connection con = DriverManager.getConnection(url,username,password);
			//creating callable statement 
			//calling stored procedure 
			CallableStatement cst = con.prepareCall("{call updateusertbl(?,?)}");
			cst.setInt(1, 2);
			cst.setString(2, "Sukesh");
			//executing sql statement
			int r = cst.executeUpdate();
			if(r>0)
			{
				System.out.println("Stored procedure successfull check db");
			}
			else
			{
				System.out.println("Stored procedure failed to execute");
			}
			//closing connection
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
				
		

	}

}
