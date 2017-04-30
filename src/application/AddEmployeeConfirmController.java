package application;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class AddEmployeeConfirmController {
	MenuMain a = new MenuMain();

	@FXML
	private JFXButton ok;

	@FXML
	void confirmOK(ActionEvent event) throws IOException {
		a.showOwnerM();
		// BACK TO OWNER MENU
	}

}
