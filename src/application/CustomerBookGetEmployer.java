package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * This class is working on list the employee detail when the customer make a
 * booking.
 *
 */
public class CustomerBookGetEmployer {

	private static Connection LoginConn = null;
	private static ResultSet rs = null;
	private static Statement st = null;

	private ObservableList<CustomerBookEmployer> employerData = FXCollections.observableArrayList();

	public CustomerBookGetEmployer() {

		try {
			// Connect to the Database
			LoginConn = connection.connectDB();
			st = LoginConn.createStatement();
			// Create statement of it
			rs = st.executeQuery("SELECT * FROM EMPLOYEE");

			// While loop for get all employees
			while (rs.next()) {
				String first = rs.getString("EMP_FIRST");
				String last = rs.getString("EMP_LAST");
				String phone = rs.getString("EMP_PHONE");
				int empId = rs.getInt("EMP_UID");
				System.out.println("REPORT 004");
				// Add employer to the list
				employerData.add(new CustomerBookEmployer(first, last, phone, empId));
				System.out.println("finished MainApp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ObservableList<CustomerBookEmployer> getEmployerData() {
		return employerData;
	}
}
