//Batch Processing --> Statement(I)

import java.sql.*;

class SqlDemo14
{
	public static void main(String[] args) throws SQLException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/department","root","root");

		Statement stmt = con.createStatement();

		stmt.addBatch("insert into student values(11,'Shrawan',19,'Mumbai')");
		stmt.addBatch("insert into student values(12,'Ganesh',20,'Nagpur')");
		stmt.addBatch("insert into student values(13,'Sai',21,'Nashik')");

		int result[] = stmt.executeBatch();

		for(int i=0 ; i < result.length ; i++)
		{
			if(result[i] == 0)
			{
				System.out.println(i + " record affected");
			}

			else
			{
				System.out.println((i+1) + " record affected");	
			}
		}	

		stmt.close();
		con.close();
	}
}