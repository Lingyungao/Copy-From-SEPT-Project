package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class NewBookingController {
	private String regNumOnly = "^[0-9]+$";
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

	public static String tempService;

	@FXML
	private JFXComboBox<String> ServiceList;

	public static int selectedBookIdbookID;
	public static String Service = "";

	public void showList() throws SQLException {
		ObservableList<service> list = FXCollections.observableArrayList();
		LoginConn = connection.connectDB(); // connect to the SQL
		st = LoginConn.createStatement(); // create statement of it
		rs = st.executeQuery("select * from SERVICE_DETAILS");
		System.out.println("init work");
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

	@FXML
	void goTimetable(ActionEvent event) throws NumberFormatException, IOException, SQLException {
		userIdCheck = userId.getText();
		// tempService = service.getText();
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
				Service = ServiceList.getSelectionModel().getSelectedItem().toString();
				a.showTimetable(EmployeeMenuController.tempEmpId, userIdCheck, goTimetable, Service, "MB");
				SaveConfirmationController.SSelection = 1;
			}
			// error msg if didnt click employee
			catch (NumberFormatException NFE) {
				System.out.println("please select one of the employee");
				a.showWarming(goTimetable);
			}
		}
	}
}
