package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CusGetBooking {
	
	private static Connection LoginConn = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	
	private ObservableList<CusBooking> CusBookingData = FXCollections.observableArrayList();
	
	
	public CusGetBooking() {
		System.out.println("REPORT 001");
		try {
		LoginConn = connection.connectDB(); // connect to the SQL

		System.out.println("REPORT 002");

			st = LoginConn.createStatement();
		 // create statement of it
			System.out.println("REPORT 001");

		rs = st.executeQuery("select * from (booking INNER JOIN Details On booking.user_id = details.user_id) INNER JOIN Employee ON booking.Emp_id = Employee.Emp_uid");
		System.out.println("REPORT 003");

		while(rs.next()){
			int bookId = rs.getInt("BOOK_ID");
			int empId = rs.getInt("EMP_ID");
			String empName = rs.getString("EMP_LAST");
			String bookDate = rs.getString("DAY");
			String startTime = rs.getString("START_TIME");
			String endTime = rs.getString("START_TIME");
			System.out.println("REPORT 004");

			CusBookingData.add(new CusBooking(bookId,empId,empName,bookDate,startTime,endTime));
			System.out.println("finished MainApp");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public ObservableList<CusBooking> getCusBookingData(){
		return CusBookingData;
	}
}
