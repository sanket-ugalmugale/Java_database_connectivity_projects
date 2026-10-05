//Scrollable ResultSet

import java.sql.*;

class SqlDemo12
{
	public static void main(String args[]) throws SQLException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/department","root","root");

		String query = "select * from student";

		PreparedStatement ps = con.prepareStatement(query, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);

		ResultSet rs = ps.executeQuery();

		if(rs.first())
		{
			if(rs.isFirst())
			{
				System.out.println("First Record:");
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
			}
		}

		if(rs.next())
		{
			System.out.println("\nSecond Record:");
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
		}

		if(rs.last())
		{
			if(rs.isLast())
			{
				System.out.println("\nLast Record:");
				System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
			}
		}	

		if(rs.previous())
		{
			System.out.println("\nSecond Last Record:");
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
		}

		if(rs.absolute(-5))
		{
			System.out.println("\nFifth Last Record:");
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
		}

		if(rs.absolute(5))
		{
			System.out.println("\nFifth Record:");
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
		}
		

		if(rs.relative(2))
		{
			System.out.println("\nSecond Record after the row where RS is standing:");
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
		}

		if(rs.relative(-4))
		{
			System.out.println("\nForth Record before the row where RS is standing:");
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
		}

		rs.close();
		ps.close();
		con.close();

	}
}