import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
//prepared statement demo
public class Test3 {
	public static void main(String[] args) {

		String username = "root";
		String password = "Root@123";
		String url = "jdbc:mysql://localhost:3306/jdbc";

		try {
			// load driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			// creating connection
			Connection con = DriverManager.getConnection(url, username, password);
			
			// creating statement
			String sql = "select * from jdbc.user_tbl";
			PreparedStatement pst = con.prepareStatement(sql);
			//settiing data
			//pst.setInt(1, 1);
			// executing sql statement
			ResultSet rs = pst.executeQuery(sql);
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
			}

			// closing connection
			con.close();
			
			Connection con2 = DriverManager.getConnection(url, username, password);
			String sql1 = "insert into user_tbl values(?,?,?,?)";
			PreparedStatement pst1 = con2.prepareStatement(sql1);
			pst1.setInt(1,5);
			pst1.setString(2, "Chitti");
			pst1.setInt(3, 600);
			pst1.setString(4, "Mumbai");
			int r = pst1.executeUpdate();
			if(r>0)
			{
				System.out.println("Data inserted successfully check DB");
			}
			else
			{
				System.out.println("Data failed to insert");
			}
			
			con2.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
