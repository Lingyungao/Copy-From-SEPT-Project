package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CustomerBookGetEmployer {
	
	private static Connection LoginConn = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	
	private ObservableList<CustomerBookEmployer> employerData = FXCollections.observableArrayList();
	
	
	public CustomerBookGetEmployer() {
		System.out.println("REPORT 001");
		try {
		LoginConn = connection.connectDB(); // connect to the SQL

		System.out.println("REPORT 002");

			st = LoginConn.createStatement();
		 // create statement of it
			System.out.println("REPORT 001");

		rs = st.executeQuery("SELECT * FROM EMPLOYEE");
		System.out.println("REPORT 003");

		while(rs.next()){
			String first = rs.getString("EMP_FIRST");
			String last = rs.getString("EMP_LAST");
			String phone = rs.getString("EMP_PHONE");
			int empId = rs.getInt("EMP_UID");
			System.out.println("REPORT 004");

			employerData.add(new CustomerBookEmployer(first,last,phone,empId));
			System.out.println("finished MainApp");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public ObservableList<CustomerBookEmployer> getEmployerData(){
		return employerData;
	}
}
