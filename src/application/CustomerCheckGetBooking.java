package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class is working on the customer get booking.
 *
 */
public class CustomerCheckGetBooking {
	
	private static Connection LoginConn = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	int tempET = 0;
	private ObservableList<CustomerCheckBooking> CusBookingData = FXCollections.observableArrayList();
	
	
	public CustomerCheckGetBooking() {
		
		try {
		// connect to database
		LoginConn = connection.connectDB();
		st = LoginConn.createStatement();

		// create statement of it
		rs = st.executeQuery("select * from (booking INNER JOIN Details On booking.user_id = details.user_id) INNER JOIN Employee ON booking.Emp_id = Employee.Emp_uid WHERE booking.user_id = " + LoginSystem2.returnId);
		
		// Using while loop to get all booking details
		while(rs.next()){
			int bookId = rs.getInt("BOOK_ID");
			int empId = rs.getInt("EMP_ID");
			String empName = rs.getString("EMP_LAST");
			String bookDate = rs.getString("DAY");
			String startTime = rs.getString("START_TIME");
			String endTime = rs.getString("START_TIME");
			tempET = Integer.parseInt(endTime);
			tempET = tempET + 1;
			endTime = Integer.toString(tempET);
			
			// add these details to the view booking detail window
			CusBookingData.add(new CustomerCheckBooking(bookId,empId,empName,bookDate,startTime,endTime));
			System.out.println("finished MainApp");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public ObservableList<CustomerCheckBooking> getCusBookingData(){
		return CusBookingData;
	}
}
