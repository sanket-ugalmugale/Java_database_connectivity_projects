//PreaparedStatement

import java.sql.*;
import.java.util.*;

class SqlDemo7
{
	private static final String insert_query = "insert into student values(?,?,?,?)";
	//private static final String update_query = "update student set name = ? where id = ?";
	//private static final String delete_query = "delete from student where id = ?";	

	public static void main(String[] args) throws SQLException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/department","root","root");

		PreparedStatement ps = con.prepareStatement(insert_query);

		//insert
		ps.setInt(1,9);
		ps.setString(2,"swapnil");
		ps.setInt(3,25);
		ps.setString(4,"pune");

		//update
		//ps.setString(1,"Shubham"); ps.setInt(2,9);

		//delete
		//ps.setInt(1,9);

		int result = ps.executeUpdate();

		if(result == 0)
		{
			System.out.println("no record updated");
		}
		else
		{
			System.out.println(result+" record updated");
		}

		ps.close();
		con.close();
	}
}