package in.sp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectDemo1 
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_db", "root", "root");
			
			PreparedStatement ps = con.prepareStatement("SELECT * FROM students");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String name1 = rs.getString("name");
				String email1 = rs.getString("email");
				String pass1 = rs.getString("password");
				String gender1 = rs.getString("gender");
				String city1 = rs.getString("city");
				
				System.out.println("Name : "+name1);
				System.out.println("Email : "+email1);
				System.out.println("Password : "+pass1);
				System.out.println("Gender : "+gender1);
				System.out.println("City : "+city1);
				
				System.out.println("===================================");
			}
			
			ps.close();
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
