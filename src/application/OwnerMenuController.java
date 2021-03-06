package application;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class OwnerMenuController {

	MenuMain a = new MenuMain();

	@FXML
	private JFXButton oldBooking;

	@FXML
	private JFXButton editEmployee;

	@FXML
	private JFXButton ViewTimetable;

	@FXML
	private JFXButton newBooking;

	@FXML
	private JFXButton viewEmployee;

	@FXML
	private JFXButton editTimetable;

	@FXML
	private JFXButton viewBooking;

	@FXML
	private JFXButton addEmployee;

	@FXML
	private JFXButton logout;

	@FXML
	private void logout(ActionEvent event) throws Exception {

		a.showMainview();
		MenuMain.userId = 0;
		MenuMain.premission = 0;
		MenuMain.userName = "";
		SaveConfirmationController.SSelection = 0;

	}

	@FXML
	void addEmployee(ActionEvent event) throws IOException {
		a.showAddEmp();
	}

	@FXML
	void editEmployee(ActionEvent event) {

	}

	@FXML
	void newBooking(ActionEvent event) {

	}

	@FXML
	void editTimetable(ActionEvent event) {

	}

	@FXML
	void ViewTimetable(ActionEvent event) {

	}

	// jump to employee menu
	@FXML
	void viewEmployee(ActionEvent event) {
		try {
			a.showEmpMenu();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// jump to booking menu
	@FXML
	void viewBooking(ActionEvent event) {
		try {
			a.showViewBooking();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// jump to old booking menu
	@FXML
	void oldBooking(ActionEvent event) {
		try {
			a.showOldBooking();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// jump to viewService menu
	@FXML
	void viewService(ActionEvent event) {
		try {
			a.showViewService();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
