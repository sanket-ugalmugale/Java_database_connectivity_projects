//select

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet;

class SqlDemo1
{
	public static void main(String [] args) throws SQLException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/department","root","root");

		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery("select * from student");

		while(rs.next())
		{
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
		}

		rs.close();
		stmt.close();
		con.close();		
	}
}