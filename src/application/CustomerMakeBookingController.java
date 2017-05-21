package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * This class is working on customer make a booking.
 *
 */
public class CustomerMakeBookingController {
	// Regular for check user's input
	private String regNumOnly = "^[0-9]+";
	private static Connection LoginConn = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	public static String userIdCheck;
	MenuMain a = new MenuMain();

	@FXML
	private JFXButton goTimetable;

	@FXML
	private JFXTextField userId;

	@FXML
	private Label errorMsg;


	@FXML
	public static String tempService;
	
	@FXML
	private JFXComboBox<String> ServiceList;
	
	public static String service = "";
	
	public void showList() throws SQLException {
		ObservableList<service> list = FXCollections.observableArrayList();
		LoginConn = connection.connectDB(); // connect to the SQL
		st = LoginConn.createStatement(); // create statement of it
		rs = st.executeQuery("select * from SERVICE_DETAILS");
		while (rs.next()) {
			service service = new service();// create object
			String ServiceName = rs.getString("SER_NAME");
			// int ServiceID = rs.getInt("SER_ID");
			service.setServiceName(ServiceName);
			// service.setServiceID(ServiceID);
			list.add(service);
			ServiceList.getItems().addAll(ServiceName);
		}
	}
	
	public void initialize() throws SQLException {
		showList();
	}

	/**
	 * Show the current employee's timetable
	 */
//	@FXML
//	void goTimetable(ActionEvent event) throws Exception {
//		// Get current customer's user ID
//		userIdCheck = Integer.toString(LoginSystem2.returnId);
//		// Get which service that the customer want to book
//		tempService = service.getText();
//		Boolean passCheck = false;
//		int userIdCheck2 = Integer.parseInt(userIdCheck);
//		// Connect to database
//		LoginConn = connection.connectDB();
//		st = LoginConn.createStatement();
//		// Running SQL sentence.
//		rs = st.executeQuery("SELECT COUNT(USER_ID) FROM USERS");
//
//		int userCount = rs.getInt("COUNT(USER_ID)");
//
//		// Check the user input is valid or not.
//		// If not, show error message.
//		if (userIdCheck.matches(regNumOnly) == false) {
//			errorMsg.setText("Customer ID only allowed to input numbers.");
//		} else if (userIdCheck2 > userCount) {
//			errorMsg.setText("Customer ID not exsist.");
//		} else if (tempService == "") {
//			errorMsg.setText("Please enter the service.");
//		} else {
//			// Get the service's content
//			tempService = service.getText();
//			try {
//				// try to show the timetable
//				a.showTimetable(CustomerBookingMenuController.tempEmpId,userIdCheck,goTimetable,tempService,"MB");
//				SaveConfirmationController.SSelection = 0;
//			} catch (NumberFormatException NFE) {
//				System.out.println("please select one of the employee");
//				a.showWarming(goTimetable);
//			}
//		}
//	}
	
	@FXML
	void goTimetable(ActionEvent event) throws NumberFormatException, IOException, SQLException {
		// Get current customer's user ID
		userIdCheck = Integer.toString(LoginSystem2.returnId);
		Boolean passCheck = false;
		int userIdCheck2 = 0;
		int userCount = 0;
		// user id check
		try {
			userIdCheck2 = Integer.parseInt(userIdCheck);
		} catch (NumberFormatException NFE) {
			errorMsg.setText("Please enter the number on Customer ID.");
		}
		try {
			LoginConn = connection.connectDB();
			st = LoginConn.createStatement();

			rs = st.executeQuery("SELECT COUNT(USER_ID) FROM USERS");

			userCount = rs.getInt("COUNT(USER_ID)");
		} catch (SQLException SE) {
			errorMsg.setText("Invaild input for Customer ID");
		}
		// user id is exist check
		if (userIdCheck.matches(regNumOnly) == false) {
			errorMsg.setText("Customer ID only allowed to input numbers.");
		} else if (userIdCheck2 > userCount) {
			errorMsg.setText("Customer ID not exist.");

		} else {
			try {
				service = ServiceList.getSelectionModel().getSelectedItem().toString();
				a.showTimetable(CustomerBookingMenuController.tempEmpId, userIdCheck, goTimetable, service, "MB");
				SaveConfirmationController.SSelection = 2;
				EmployeeMenuController.Selection = 2;
				
			}
			// error msg if didnt click employee
			catch (NumberFormatException NFE) {
				System.out.println("please select one of the employee");
				a.showWarming(goTimetable);
			}
		}
	}
}