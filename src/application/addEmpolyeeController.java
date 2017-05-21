package application;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class addEmpolyeeController {
	MenuMain a = new MenuMain();

	private static String regLetOnly = "^[a-zA-Z]+$";
	private static String regNumOnly = "^[0-9]+$";

	@FXML
	private JFXTextField empFirst;

	@FXML
	private Label lastCheck;

	@FXML
	private Label firstCheck;

	@FXML
	private Label phoneCheck;

	@FXML
	private JFXTextField empPhone;

	@FXML
	private JFXButton Back;

	@FXML
	private JFXButton addEmployeeNext;

	@FXML
	private JFXTextField empLast;

	@FXML
	void empFirst(ActionEvent event) {

	}

	@FXML
	void empLast(ActionEvent event) {

	}

	@FXML
	void empPhone(ActionEvent event) {

	}

	@FXML
	void addEmployeeNext(ActionEvent event) throws Exception {
		System.out.println("clicked");
		boolean empFirstPass = false;
		boolean empLastPass = false;
		boolean empPhonePass = false;
		// first name check
		if (empFirst.getText().length() < 2) {
			firstCheck.setText("First name too short. Must longer than 2 letters");
			empFirstPass = false;
		}

		else if (empFirst.getText().length() > 20) {
			firstCheck.setText("First name too long. Must shorter than 20 letters");
			empFirstPass = false;
		}

		else if (empFirst.getText().matches(regLetOnly) == false) {
			firstCheck.setText("First name only allowed input characters.");
			empFirstPass = false;
		} else {
			firstCheck.setText("¡Ì");
			empFirstPass = true;
		}

		// last name check
		if (empLast.getText().length() < 2) {
			lastCheck.setText("Last name too short. Must longer than 2 letters");
			empLastPass = false;
		}

		else if (empLast.getText().length() > 20) {
			lastCheck.setText("Last name too long. Must shorter than 20 letters");
			empLastPass = false;
		}

		else if (empLast.getText().matches(regLetOnly) == false) {
			lastCheck.setText("Last name only allowed input characters.");
			empLastPass = false;
		} else {
			lastCheck.setText("¡Ì");
			empLastPass = true;
		}

		// phone check

		if (empPhone.getText().length() < 5) {
			phoneCheck.setText("Phone number too short. Must longer than 5 letters");
			empPhonePass = false;
		}

		else if (empPhone.getText().length() > 15) {
			phoneCheck.setText("Phone number too long. Must shorter than 15 letters");
			empPhonePass = false;
		}

		else if (empPhone.getText().matches(regNumOnly) == false) {
			phoneCheck.setText("Phone number only allowed input numbers.");
			empPhonePass = false;
		} else {
			phoneCheck.setText("¡Ì");
			empPhonePass = true;
		}

		if (empFirstPass == true && empLastPass == true && empPhonePass == true) {
			System.out.println("PASSED");
			AddEmployeeSQL.insertEmployee(empFirst.getText(), empLast.getText(), empPhone.getText(), LoginSystem2.businessID);
			a.showAddEmpConfirm();
		} else {
			System.out.println("error AE001");
		}

	}

	@FXML
	void Back(ActionEvent event) throws IOException {
		a.showOwnerM();
	}

}
