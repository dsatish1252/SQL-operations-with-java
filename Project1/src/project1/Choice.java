package project1;
import java.sql.*;
import java.util.*;

public class Choice {
	public static void main(String args[]) throws SQLException,ClassNotFoundException{
		Scanner sc=new Scanner(System.in);
		String driver="com.mysql.cj.jdbc.Driver";
		Class.forName(driver);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/loyola","root","Dany@123");
		PreparedStatement ps1=con.prepareStatement("insert into emp values(?,?,?,?)");
		PreparedStatement ps2=con.prepareStatement("select * from emp");
		PreparedStatement ps3=con.prepareStatement("select * from emp where id =?");
		PreparedStatement ps4=con.prepareStatement("update emp set sal=?, designation=? where id=?");
		PreparedStatement ps5=con.prepareStatement("delete from emp where id=?");
				
				
		while(true) {
			System.out.println("\t1.Add new Record \n \t2.View All Records \n \t3.View Record By ID \n \t4.Update emp  \n \t5.Delete emp by ID \n\t6.Exit");
			System.out.println("Enter Choice:");
			int ch=Integer.parseInt(sc.nextLine());
			
			switch(ch) {
			
			case 1:
				System.out.println("enter  id:");
				int id=Integer.parseInt(sc.nextLine());
				
                System.out.println("enter name:");
				String name=sc.nextLine();
				
                System.out.println("enter salary:");
				double sal=Double.parseDouble(sc.nextLine());

				System.out.println("enter designation:");
				String desg=sc.nextLine();
                
                //Load the Data into PreparedStatement Object ps1
                ps1.setInt(1,id);
                ps1.setString(2,name);
                ps1.setDouble(3,sal);
                ps1.setString(4,desg);
				
                //Execute the Query using PreparedStatement Object ps1
                int k1=ps1.executeUpdate();
                if(k1>0) {
                	System.out.println("Record Inserted Successfully....");

                }
                else {
                	System.out.println("Record Insertion Failed....");
                }
                break;
			
			case 2:
				ResultSet rs=ps2.executeQuery();
				while(rs.next()) {
                  System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getDouble(3)+"\t"+rs.getString(4));
				}
				break;
				
			case 3:
				System.out.println(" Enter Id to Retrive Particular Record from emp Table :");
				int sid=Integer.parseInt(sc.nextLine());
				
				ps3.setInt(1,sid);
				ResultSet rs1= ps3.executeQuery();
				if(rs1.next()) {
					System.out.println(rs1.getInt(1)+"\t"+rs1.getString(2)+"\t"+rs1.getDouble(3)+"\t"+rs1.getString(4));
				}
				else {
					System.out.println("Invalid ID....... pls Enter Valid ID....");
				}
				
				break;
				
			case 4:
				System.out.println("Enter ID to Update Record : ");
				int uid= Integer.parseInt(sc.nextLine());
			   ps3.setInt(1,uid);
			   ResultSet rs3=ps3.executeQuery();
			   if(rs3.next()) {
				   System.out.println("Older Salary: "+rs3.getDouble(3));
				   System.out.println("Enter New Salary :");
                   double usal=Double.parseDouble(sc.nextLine());

                   System.out.println("Older Designation: "+rs3.getString(4));
				   System.out.println("Enter New Designation :");
                   String udesg=sc.nextLine();

                   ps4.setDouble(1,usal);
                   ps4.setString(2,udesg);
                   ps4.setInt(3,uid);

                   int k2=ps4.executeUpdate();
                   if(k2>0) {
                	   System.out.println("Record Updated Successfully....");
                   }
               }
                   else {
                	   System.out.println("Record Updation Failed....");
                   }
                   
                   break;
				   
			   
			case 5:
                System.out.println("Enter ID to Delete the Record ");
				int did=Integer.parseInt(sc.nextLine());
				
                ps5.setInt(1,did);
                int k3=ps5.executeUpdate();
                if(k3>0) {
                	System.out.println("Record Deleted Successfully....");

                }
                else {
                	System.out.println("Id is not available in emp table....");
                }
                break;

			case 6:
				System.out.println("Operations on DB has Stopped....");
                System.exit(0);

		}

	}

}
}