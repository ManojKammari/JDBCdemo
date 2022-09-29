import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test2 {

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
			String sql = "select * from user_tbl";
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+ " "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getString(4));
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


