//homework

import java.sql.*;

class SqlDemo4
{
	public static void main(String[] args) throws SQLException
	{
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/department","root","root");

		Statement stmt = con.createStatement();

		//ResultSet rs = stmt.executeQuery("select * from emp where job in ('clerk', 'manager', 'salesman') order by job");
		//ResultSet rs = stmt.executeQuery("select * from student where city in ('shevgaon', 'mumbai', 'nashik') order by city");
		//ResultSet rs = stmt.executeQuery("select * from emp where deptno in (30)");
		//ResultSet rs = stmt.executeQuery("select empno, ename, job, sal, deptno from emp order by ename"); //for such query take index no sequentialy
		ResultSet rs = stmt.executeQuery("select dname from dept where deptno in (10, 20)");

		while(rs.next())
		{
			//System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(6));
			//System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getInt(3) + "\t" + rs.getString(4));
			//System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(6) + "\t" + rs.getInt(8));
			//System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4) + "\t" + rs.getInt(5));
			System.out.println(rs.getString(1));
		}

		rs.close();
		stmt.close();
		con.close();
	}
}