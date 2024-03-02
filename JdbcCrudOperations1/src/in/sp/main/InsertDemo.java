package in.sp.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertDemo
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Details:Name-Email-Password-Gender-City");
		
		String name1 = sc.nextLine();
		String email1 = sc.nextLine();
		String pass1 = sc.nextLine();
		String gender1 =sc.nextLine() ;
		String city1 = sc.nextLine();
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo_db", "root", "root");
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO students VALUES(?,?,?,?,?)");
			ps.setString(1, name1);
			ps.setString(2, email1);
			ps.setString(3, pass1);
			ps.setString(4, gender1);
			ps.setString(5, city1);
			
			int count = ps.executeUpdate();
			
			if(count > 0)
			{
				System.out.println("student inserted successfully");
			}
			else
			{
				System.out.println("student not inserted due to some error");
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