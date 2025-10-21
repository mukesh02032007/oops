package oops;
import java.sql.*;

public class Summa {

	public static void main(String[] args) {
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","232007");
			System.out.println("Tc1:connected to database");
			Statement s=con.createStatement();
			ResultSet r=s.executeQuery("select * from students");
			System.out.println("Tc2:Students record:");
			while(r.next()) {
				System.out.println("ID:"+r.getString(1)+",Name:"+r.getString(2)+",Dept:"+r.getString(3));
			}
			Statement s2=con.createStatement();
			ResultSet r2=s2.executeQuery("");
			while(r.next()) {
				System.out.println("ID:"+r2.getString(1)+",Name:"+r2.getString(2)+",Dept:"+r2.getString(3));
			}
			
		}catch(SQLException e) {
			System.out.println("Tc5:SQL Exception");
		}
		catch(ClassNotFoundException e) {
			System.out.println("Tc3:driver not found");
		}
	}

}
