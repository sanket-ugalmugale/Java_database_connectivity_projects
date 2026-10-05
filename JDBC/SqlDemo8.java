//Date (String to java.sql.Date)

import java.sql.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.ParseException;

class SqlDemo8
{
	private static final String insert_query = "insert into studentdate values(?,?,?)";
 
	public static void main(String[] args) throws SQLException, ParseException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/department","root","root");

		PreparedStatement ps = con.prepareStatement(insert_query);

		Scanner sc = new Scanner(System.in);

		System.out.print("Roll no: ");
		int rollno = sc.nextInt();

		System.out.print("name: ");
		String name = sc.next();
		
		System.out.print("Enter Date(dd-MM-yyyy): ");
		String s1 = sc.next();

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		java.util.Date ud = sdf.parse(s1);

		long ms = ud.getTime();
	
		java.sql.Date sd = new java.sql.Date(ms);

		ps.setInt(1,rollno);
		ps.setString(2,name);		
		ps.setDate(3,sd);

		int result = ps.executeUpdate();

		if(result == 0)	
		{
			System.out.println("no record inserted");
		}
		else
		{
			System.out.println(result + " record inserted");
		}

		ps.close();
		con.close();
	}
}