import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;

public class Test5 {

	public static void main(String[] args) {
		String username = "root";
		String password = "Root@123";
		String url = "jdbc:mysql://localhost:3306/jdbc";
		
		try {
			//load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			//creating connection
			Connection con = DriverManager.getConnection(url,username,password);
			//creating statement
			CallableStatement cst = con.prepareCall("{?=call addition(?,?)}");
			//executing sql statement
			cst.registerOutParameter(1, Types.INTEGER);
			cst.setInt(2, 40);
			cst.setInt(3, 60);
			
			int rs = cst.executeUpdate();
			if(rs>0)
			{
				System.out.println("Function executed successfully");
				System.out.println("Addition  = "+cst.getInt(1));
			}
			else
			{
				System.out.println("Function failed to execute");
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
