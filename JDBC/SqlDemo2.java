//insert, update, delete 

import java.sql.*;

class SqlDemo2
{
	public static void main(String[] args) throws SQLException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/department","root","root");

		Statement stmt = con.createStatement();

		//int result = stmt.executeUpdate("insert into student values(3, 'Sanket', 21, 'Shevgaon')");

		//int result = stmt.executeUpdate("update student set name = 'Tanya' where id = 2");

		//int result = stmt.executeUpdate("delete from student where id = 2");

		if(result == 0)
		{
			System.out.println("No record inserted");
			//System.out.println("No record updated");
			//System.out.println("No record deleted");
		}
		else
		{
			System.out.println(result + " record inserted");
			//System.out.println(result + " record updated");
			//System.out.println(result + " record deleted");
		}

		stmt.close();
		con.close();
	}
}