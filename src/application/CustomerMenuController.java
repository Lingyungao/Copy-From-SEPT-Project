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
public class CustomerMenuController {
	
MenuMain a = new MenuMain();
	
	@FXML
	private JFXButton TimeView;
	
	@FXML
	private JFXButton EditDetail;
	
	@FXML
	private JFXButton BookingView;
	@FXML
	private JFXButton logout;
	/**
     * when user click, go to the view timetable menu.
     */
	@FXML
	 private void timeView(ActionEvent event) throws Exception {

		a.showCusBookM();
	}
	/**
     * when user click, go to the edit detail menu.
     */
	@FXML
	 private void editDetail(ActionEvent event) throws Exception {

		a.showCusDetailM();
		
	}
	/**
     * when user click, go to the booking view menu.
     */
	@FXML
	 private void BookingView(ActionEvent event) throws Exception {

		a.viewCusBookM();
		
	}
	
	/**
     * when user click, logout
     */
	@FXML
	 private void logout(ActionEvent event) throws Exception {

		a.showMainview();
		MenuMain.userId = 0;
		MenuMain.premission = 0;
		MenuMain.userName ="";
	}
	
	

}
