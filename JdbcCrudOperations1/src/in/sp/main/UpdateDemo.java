package in.sp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateDemo
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Email for updation");
		String email1 = sc.nextLine();

		System.out.println("Enter Your Gender for updation");
		String gender1 =sc.nextLine() ;

		System.out.println("Enter Your City for updation");
		
		String city1 = sc.nextLine();
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_db", "root", "root");
			
			PreparedStatement ps = con.prepareStatement("UPDATE students SET gender=?, city=? WHERE email=?");
			ps.setString(1, gender1);
			ps.setString(2, city1);
			ps.setString(3, email1);
			
			int count = ps.executeUpdate();
			
			if(count > 0)
			{
				System.out.println("student updated successfully");
			}
			else
			{
				System.out.println("student not updated due to some error");
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