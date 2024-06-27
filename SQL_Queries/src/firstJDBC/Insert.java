package firstJDBC;
import java.sql.*;

public class Insert {
	public static void main(String args[]) throws ClassNotFoundException,SQLException
	{
		String driver="com.mysql.cj.jdbc.Driver";
		Class.forName(driver);
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/loyola","root","Dany@123");
		Statement st= con.createStatement();
		int k=st.executeUpdate("insert into emp values(101,'Ashok',75000,'Team Leader')");
		if(k>0) {
			System.out.println("Record inserted successfully");
		}
	}
}
