package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class GetEmployer {

	private static Connection LoginConn = null;
	private static ResultSet rs = null;
	private static Statement st = null;

	private ObservableList<Employer> employerData = FXCollections.observableArrayList();

	public GetEmployer() {
		System.out.println("REPORT 001");
		try {
			LoginConn = connection.connectDB(); // connect to the SQL

			System.out.println("REPORT 002");

			st = LoginConn.createStatement();
			// create statement of it
			System.out.println("REPORT 001");

			rs = st.executeQuery("SELECT EMP_FIRST, EMP_LAST, EMP_PHONE, EMPLOYEE.EMP_UID \"EMPLOYEE_UID\", EMP_BUS.BUS_ID FROM EMPLOYEE CROSS JOIN EMP_BUS WHERE EMPLOYEE.EMP_UID = EMP_BUS.EMP_UID AND EMP_BUS.BUS_ID = \"" + LoginSystem2.businessID + "\";");
			System.out.println("REPORT 003");
			// to get employer
			while (rs.next()) {
				String first = rs.getString("EMP_FIRST");
				String last = rs.getString("EMP_LAST");
				String phone = rs.getString("EMP_PHONE");
				int empId = rs.getInt("EMPLOYEE_UID");
				System.out.println("REPORT 004");

				employerData.add(new Employer(first, last, phone, empId));
				System.out.println("finished MainApp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public ObservableList<Employer> getEmployerData() {
		return employerData;
	}
}
