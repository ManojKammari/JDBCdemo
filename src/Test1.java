import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Test1 {

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
			Statement st = con.createStatement();
			//executing sql statement
			int upds = st.executeUpdate("insert into jdbc.user_tbl values(4,'komali',550,'Kerala')");
			
			if(upds > 0)
			{
				System.out.println("Data inserted successfully check DB");
			}
			else
			{
				System.out.println("Data failed to insert");
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
