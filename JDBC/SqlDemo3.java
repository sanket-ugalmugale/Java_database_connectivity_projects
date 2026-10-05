//take input from user and insert it into table

import java.sql.*;
import java.io.*;
import java.util.*;

class SqlDemo3 
{
	//logic 1
	/*public static void main(String[] args) throws SQLException, IOException
	{
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter id: ");
		int id = sc.nextInt();
	
		System.out.print("Enter Name: ");
		String name = sc.next();
		
		System.out.print("Enter Age: ");
		int age = sc.nextInt();
		
		System.out.print("Enter City: ");
		String city = sc.next();
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/department", "root", "root");
	
		Statement stmt = con.createStatement();

		int result = stmt.executeUpdate("insert into student values(" +id+ ",'" +name+ "'," +age+ ",'" +city+ "')" );

		System.out.println(result + " record inserted");

		stmt.close();
		con.close();
	}*/




	//logic 2
	public static void main(String[] args) throws SQLException, IOException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/department", "root", "root");
	
		Statement stmt = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter id: ");
		int id = sc.nextInt();
	
		System.out.print("Enter Name: ");
		String name = sc.next();
		name = "'" +name+ "'";
		
		System.out.print("Enter Age: ");
		int age = sc.nextInt();
		
		System.out.print("Enter City: ");
		String city = sc.next();
		city = "'" +city+ "'";

		String query = "insert into student values(" +id+ "," +name+ "," +age+ "," +city+ ")";		

		int result = stmt.executeUpdate(query);
	
		System.out.println(result + " record inserted");

		stmt.close();
		con.close();
	}
}