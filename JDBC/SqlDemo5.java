//DML --> select / nonselect (update, delete, insert)

import java.sql.*;
import java.util.*;

class SqlDemo5
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
			System.out.println("Enter Query(Select / Nonselect):");
			query = sc.nextLine();

			if(con != null)
			{
				stmt = con.createStatement();


			}

			if(stmt != null)
			{
				boolean result = stmt.execute(query);

				if(result == true)
				{
					rs = stmt.getResultSet();

					while(rs.next())
					{
						System.out.println(rs.getInt(1) +"\t"+ rs.getString(2) +"\t"+ rs.getInt(3) +"\t"+ rs.getString(4));
					}
				}
				else
				{
					int count = stmt.getUpdateCount();
					System.out.println(count + " rows affected.");
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