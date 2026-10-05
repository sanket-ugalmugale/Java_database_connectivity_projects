//Batch Processing --> PreparedStatement(I)

import java.sql.*;

class SqlDemo15
{
	public static void main(String[] args) throws SQLException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/department","root","root");

		PreparedStatement ps = con.prepareStatement("insert into student values(?,?,?,?)");

		//first record
		ps.setInt(1,14);
		ps.setString(2,"Shreyash");
		ps.setInt(3,14);
		ps.setString(4,"Nashik");
		ps.addBatch();


		//second record
		ps.setInt(1,15);
		ps.setString(2,"Shivam");
		ps.setInt(3,11);
		ps.setString(4,"Nashik");
		ps.addBatch();

		int[] result = ps.executeBatch();

		if(result.length == 0)
		{
			System.out.println(result.length + " rows affected");
		}
		else
		{
			System.out.println(result.length + " rows affected");
		}

		ps.close();
		con.close();
	}
}