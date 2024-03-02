package in.sp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteDemo
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Email");

		String email1 = sc.nextLine();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_db", "root", "root");
			
			PreparedStatement ps = con.prepareStatement("DELETE FROM students WHERE email=?");
			ps.setString(1, email1);
			
			int count = ps.executeUpdate();
			
			if(count > 0)
			{
				System.out.println("student deleted successfully");
			}
			else
			{
				System.out.println("student not deleted due to some error");
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
