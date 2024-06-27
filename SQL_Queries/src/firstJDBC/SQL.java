package firstJDBC;
import java.sql.*;

public class SQL
{
	public static void main(String args[]) throws ClassNotFoundException,SQLException
	{
		String driver="com.mysql.cj.jdbc.Driver";
		//1.Load the driver
		Class.forName(driver);
			
		//2. Creating the Connection
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/loyola","root","Dany@123");
		
		//3. Preparing the statements
		Statement st= con.createStatement();
		
		//4. Execute the statements
		st.executeUpdate("create table emp(id int, name varchar(20),sal double(8,2),designation varchar(20))");
		System.out.println("Table created");
	}
}
