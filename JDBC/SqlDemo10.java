//insert photo --> system to database

import java.sql.*;
import java.util.*;
import java.io.*;

class SqlDemo10
{
	public static void main(String[] args) throws SQLException, IOException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/department","root","root");

		String query = "insert into studentblob values(?,?,?)";

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter rollno: ");
		int rollno = sc.nextInt();

		System.out.print("Enter name: ");
		String name = sc.next();

		System.out.print("Enter photo path: ");
		String path = sc.next();

		PreparedStatement ps = con.prepareStatement(query);

		FileInputStream fis = new FileInputStream(path);

		ps.setInt(1, rollno);
		ps.setString(2, name);
		ps.setBinaryStream(3, fis);
		
		int result = ps.executeUpdate();

		if(result == 0)
		{
			System.out.println("Insertion failed.");
		}
		else
		{
    			System.out.println("Record inserted successfully.");
		}
    	
		fis.close();
		ps.close();
		con.close();
	}
}
