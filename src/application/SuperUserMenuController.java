package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

/**
 * This class is working on the customer main menu.
 *
 */
public class SuperUserMenuController {

	MenuMain a = new MenuMain();

	@FXML
	private JFXButton BusinessView;

	@FXML
	private JFXButton BusinessAdd;
	@FXML
	private JFXButton logout;

	/**
	 * when user click, go to the view business.
	 */
	@FXML
	private void BusinessView(ActionEvent event) throws Exception {

		a.showSuperUserBusinessView();
	}

	/**
	 * when user click, go to the edit business.
	 */
	@FXML
	private void BusinessAdd(ActionEvent event) throws Exception {

		a.showSuperUserBusinessAdd();

	}



	/**
	 * when user click, logout
	 */
	@FXML
	private void logout(ActionEvent event) throws Exception {

		a.showMainview();
		MenuMain.userId = 0;
		MenuMain.premission = 0;
		MenuMain.userName = "";
	}

}
