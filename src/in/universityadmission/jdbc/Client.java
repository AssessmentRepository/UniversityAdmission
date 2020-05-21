package in.universityadmission.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Client {
	//NOTE: please add mysql conector in to the project
	static Connection con= null;
	static {
		final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		final String DB_URL = "jdbc:mysql://localhost/myworld";
		final String USER = "root";
		final String PASS = "root";
		try {
			Class.forName(JDBC_DRIVER);
			 con = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("MySQL Connected successfully...");
	}
	static Statement stat = null;
	static PreparedStatement pstat = null;
	public static void main(String[] args) throws SQLException {
			Scanner sc = new Scanner(System.in);
			System.out.println("*********************Admission System*****************" 
			+ "\nSelect  an operation" 
			+ "\n1. Create Table"
			+ "\n2. Insert into student table"
			+ "\n3. Single select by ID"
			+ "\n4. Multi select"
			+ "\n5. Update student by ID"
			+ "\n6. Delete student by ID"
			+ "\n0. Exit");			
			if (con != null) {
				int key = sc.nextInt();
				Client client = new Client();
				switch (key) {
				case 0:
					
					break;
				case 1:
					//Create studebt table with this First Name, Last Name, Contact Number, Email, Stream, Aggregate in qualifying exam
					client.createTable();
					break;
				case 2:
					String iquary="";
					Scanner inp = new Scanner(System.in);
					System.out.println("Enter ID : ");
					String id = inp.next();
					System.out.println("Enter First Name : ");
					String firstName = inp.next();
					System.out.println("Enter Last Name : ");
					String lastName = inp.next();
					System.out.println("Enter Contact Number : ");
					String contactNumber = inp.next();	
					System.out.println("Enter email : ");
					String email = inp.next();		
					System.out.println("Enter Stream : ");
					String stream = inp.next();		
					System.out.println("Enter Aggregate in qualifying exam : ");
					String aggregate = inp.next();	
					
					int rowsAffected = stat.executeUpdate(iquary);
					if (rowsAffected == 0) {
						System.out.println("not updated");
					} else {
						System.out.println("no of rows updated" + " " + rowsAffected);
					}
					break;
					
				case 3:
					//Single Select quary
					break;
				case 4:
					//Multi select Quary
					break;
				case 5:
					//Update Quary
					break;
				case 6:
					//Delact Quary
					break;

				default:
					break;
				}
			} 
	}
	
	public String createTable() throws SQLException {	
		stat = con.createStatement();
		String c = "create table student(id int,firstName varchar(50),lastName varchar(50),contactNo varchar(50),email varchar(150),stream varchar(50), aggregat varchar(3))";
		stat.executeUpdate(c);
		return "created";
	}
}

