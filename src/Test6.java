import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test6 {

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
			st.addBatch("insert into user_tbl values(6,'kumar',520,'Mumbai')");
			st.addBatch("insert into user_tbl values(7,'Rahul',550,'Hyderabad')");
			st.addBatch("delete from user_tbl where userid=7");
			st.addBatch("update user_tbl set username='bahubali' where userid=6");
			
			
			int[] a = st.executeBatch();
			for(int i=0;i<a.length;i++)
			{
				if(a[i]>0) {
				System.out.println("successfull query : "+a[i]);
				}
				else
				{
					System.out.println("Query failed : "+a[i]);
				}
			}
			//closing connection
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage()+e.getStackTrace()+e.getLocalizedMessage());
		}
				
		

	}

}
