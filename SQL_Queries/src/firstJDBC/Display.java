package firstJDBC;
import java.sql.*;

public class Display {
	
	public static void main(String args[]) throws ClassNotFoundException,SQLException
	{
		String driver="com.mysql.cj.jdbc.Driver";
		Class.forName(driver);
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/loyola","root","Dany@123");
		Statement st= con.createStatement();
		ResultSet rs=st.executeQuery("select * from emp");
		while(rs.next()){
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
		}
		
	}


}
