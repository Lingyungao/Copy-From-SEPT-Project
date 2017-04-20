package application;

import java.io.IOException;

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

public class MenuController {
	
	MenuMain a = new MenuMain();
	
	@FXML
    private JFXButton Login;
	
	@FXML
    private JFXButton Register;
	
	@FXML
    private void goLogin(ActionEvent event) throws IOException {
		a.showTimetable();
		}
	
	@FXML
	private void goRegister(ActionEvent event) throws IOException{
		a.showRegister();
	}
}
