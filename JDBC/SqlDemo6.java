//DDl --> create, drop, alter, truncate

import java.sql.*;
import java.util.*;

class SqlDemo6
{
	public static void main(String args [])
	{
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Scanner sc = null;
		String query = null;

		try
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/department", "root", "root");	

			sc = new Scanner(System.in);
			System.out.println("Enter Nonselect DDL Query:");
			query = sc.nextLine();

			if(con != null)
			{
				stmt = con.createStatement();
			}

			if(stmt != null)
			{
				int count = stmt.executeUpdate(query);

				if(count == 00)
				{
					System.out.println("succesfull");
				}
				else
				{
					System.out.println("failed");
				}
			}	
		}
		
		catch(SQLException se)
		{
			se.printStackTrace();
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}

		finally
		{
			try
			{
				if(rs != null)
				{	
					rs.close();
				}

				if(stmt != null)
				{
					stmt.close();
				}

				if(con != null)
				{
					con.close();
				}
			
				if(sc != null)
				{
					sc.close();
				}
			}
			
			catch(SQLException se)
			{
				se.printStackTrace();
			}
		}
		
	}
}