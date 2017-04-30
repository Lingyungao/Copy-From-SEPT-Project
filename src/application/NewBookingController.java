package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

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

	@FXML
	private JFXTextField service;

	public static String tempService;

	@FXML
	void goTimetable(ActionEvent event) throws NumberFormatException, IOException, SQLException {
		userIdCheck = userId.getText();
		tempService = service.getText();
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
		} else if (tempService == "") {
			errorMsg.setText("Please enter the service.");

		} else {
			tempService = service.getText();
			try {
				a.showTimetable(EmployeeMenuController.tempEmpId, goTimetable);
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
