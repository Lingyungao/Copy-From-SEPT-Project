package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddEmployeeSQL {
	private static Connection LoginConn = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	private static int empCount;

	
	
	public static void insertEmployee(String empFirst, String empLast, String empPhone) throws Exception{
		LoginConn = connection.connectDB(); // connect to the SQL

		st = LoginConn.createStatement(); // create statement of it

		rs = st.executeQuery("SELECT COUNT(EMP_UID) FROM EMPLOYEE");

		empCount = rs.getInt("COUNT(EMP_UID)");

		empCount += 1;
		
		//insert the employee to the database
		PreparedStatement rs = LoginConn
				.prepareStatement("INSERT INTO EMPLOYEE(EMP_FIRST,EMP_LAST,EMP_PHONE,EMP_UID) VALUES(?,?,?,?)");
		rs.setString(1, empFirst);
		rs.setString(2, empLast);
		rs.setString(3, empPhone);
		rs.setInt(4, empCount);
		rs.executeUpdate();
		System.out.println("REPORT AE002");
		insertDefaultTimetable(empCount);
		System.out.println("REPORT AE003");
		
		
	}
	
	public static void insertDefaultTimetable(int empId) throws Exception{
		LoginConn = connection.connectDB();
		st = LoginConn.createStatement();
		
		
		PreparedStatement rs = LoginConn.prepareStatement(
				"INSERT INTO TIMETABLE (EMP_UID,WEEKDAYS,T0800,T0900,T1000,T1100,T1200,T1300,T1400,T1500,T1600,T1700,T1800) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");

		for (int i = 1; i < 8; i++) {

			rs.setInt(1, empId);
			rs.setInt(2, i);
			rs.setInt(3, 0);
			rs.setInt(4, 0);
			rs.setInt(5, 0);
			rs.setInt(6, 0);
			rs.setInt(7, 0);
			rs.setInt(8, 0);
			rs.setInt(9, 0);
			rs.setInt(10, 0);
			rs.setInt(11, 0);
			rs.setInt(12, 0);
			rs.setInt(13, 0);


			rs.addBatch();
		}
		rs.executeBatch();
		
		System.out.println("Save completed.");
	}
}
