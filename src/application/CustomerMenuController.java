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

public class CustomerMenuController {
	
MenuMain a = new MenuMain();
	
	@FXML
	private JFXButton TimeView;
	
	@FXML
	private JFXButton EditDetail;
	
	@FXML
	 private void timeView(ActionEvent event) throws Exception {
		a.showCusDetailM();
	}
	
	@FXML
	 private void editDetail(ActionEvent event) throws Exception {
		a.showCusDetailM();
		
	}
	
	

}
