package PlusOneSecond.PartC;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginController {
	MenuMain a = new MenuMain();
	@FXML
	private JFXPasswordField password;

	@FXML
	private JFXButton login;

	@FXML
	private JFXTextField username;

	@FXML
	private JFXButton register;

	@FXML
	private Label errorMsg;

	@FXML
	private void login(ActionEvent event) throws Exception {

		String user = username.getText();
		String pass = password.getText();
		try {
			int temp = 0;
			temp = LoginSystem2.login(user, pass);
			if (temp == 2) {
				System.out.println("2");
				a.showCusM();
			} else if (temp == 3) {
				System.out.println("3");
				a.showOwnerM();
			} else if (temp == 1) {
				System.out.println("1");
				// a.showFail();
			}
		} catch (NullPointerException NE) {
			errorMsg.setText("wrong username or password");
			System.out.println("The account is not exist or you do not register an account");
		}

	}

	@FXML
	void register(ActionEvent event) throws IOException {
		a.showRegister();
	}

}
