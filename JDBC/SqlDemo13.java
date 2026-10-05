//Updatable ResultSet

import java.sql.*;
import java.util.*;

class SqlDemo13
{
	public static void main(String[] args) throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Roll No: ");
		int id = sc.nextInt();

		System.out.print("Enter Name: ");
		String name = sc.next();

		System.out.print("Enter Age: ");
		int age = sc.nextInt();

		System.out.print("Enter City: ");
		String city = sc.next();
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/department","root","root");

		String query = "select * from student";

		PreparedStatement ps = con.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

		ResultSet rs = ps.executeQuery();

		//insert
		/*rs.moveToInsertRow();	

		rs.updateInt(1,id);
		rs.updateString(2,name);
		rs.updateInt(3,age);
		rs.updateString(4,city);

		rs.insertRow();*/



		//update
		/*rs.absolute(7);	

		rs.updateInt(1,id);
		rs.updateString(2,name);
		rs.updateInt(3,age);
		rs.updateString(4,city);

		rs.updateRow();*/
		
		rs.last();
		rs.deleteRow();

		rs.beforeFirst();
		while(rs.next())
		{
			System.out.println(rs.getInt(1) +"\t"+
						rs.getString(2) +"\t\t"+
						rs.getInt(3) +"\t"+
						rs.getString(4)
						);
		}

		rs.close();
		ps.close();
		con.close();
		
	}
}