package application;

import java.io.IOException;
import java.sql.SQLException;

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

public class RegisterController {
	
	MenuMain a = new MenuMain();
	RegisterSystem r = new RegisterSystem();
	
	@FXML
    private JFXTextField UserID_F;
	
	@FXML
    private JFXPasswordField Password_F;
	
	@FXML
	private JFXPasswordField Confirm_F;
	
	@FXML
	private Label UserID_C;
	
	@FXML
	private Label Password_C;
	
	@FXML
	private Label Confirm_C;
	
	@FXML
    private void Register(ActionEvent event) throws IOException {
		
		
		if(Password_F==Confirm_F) //check is same or not between the Password and the Confiretion
		{
			try{
			r.Register(UserID_F.getText(), Password_F.getText());
//			a.showSuccee();
			}
			catch(SQLException Se)
			{
//			a.showFail();
			}
		}
		else // if Different let the Confirm Label change colour or do other thing to remian
		{
			
		}
		
	}
	
	
}
