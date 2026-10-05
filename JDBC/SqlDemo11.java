//photo --> database to file system

import java.sql.*;
import java.io.*;
import org.apache.commons.io.IOUtils;

class SqlDemo11
{
	public static void main(String[] args) throws SQLException, IOException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/department","root","root");

		PreparedStatement ps = con.prepareStatement("select * from studentblob where rollno = ?");

		ps.setInt(1,1);

		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			int rollno = rs.getInt(1);
			String name = rs.getString(2);

			InputStream is = rs.getBinaryStream(3);
	
			FileOutputStream fos  = new FileOutputStream("abc.png");

			IOUtils.copy(is,fos);

			System.out.println("roll no: " +rollno);
			System.out.println("name: " +name);
			System.out.println("image saved successfully.");

			fos.close();
			is.close();
		}

		else
		{
			System.out.println("Record not found.");
		}

		rs.close();
		ps.close();
		con.close();
	}
}
