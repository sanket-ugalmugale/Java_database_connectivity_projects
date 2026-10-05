//Retrieve Date (java.sql.Date to String)

import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.FormatException;

class SqlDemo9
{
	public static void main(String[] args) throws SQLException, FormatException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/department","root","root");

		String query = "select * from studentdate where rollno = ?";

		PreparedStatement ps = con.prepareStatement(query);

		Scanner sc = new Scanner(System.in);
		int roll = sc.nextInt();

		ps.setInt(1,roll);

		ResultSet rs = ps.executeQuery();

		if(rs.next())
		{
			int rollno = rs.getInt("rollno");
			String name = rs.getString("name");

			java.sql.Date sd = rs.getDate("dob");

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); 

			String date = sdf.format(sd);

			System.out.println("Roll no: " +rollno);
			System.out.println("Name: " +name);
			System.out.println("Date of Birth: " +date);
		}
		else
		{
			System.out.println("Record not Found");
		}

		rs.close();
		ps.close();
		con.close();
	}
}