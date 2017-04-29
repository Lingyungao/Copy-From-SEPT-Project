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
	    private void login(ActionEvent event) throws Exception {

	    	
	    		String user = username.getText();
	    		String pass = password.getText();
				if(LoginSystem2.login(user, pass) == 2){
					System.out.println("2");
                    a.showCusM();
				}
				if(LoginSystem2.login(user, pass) == 3){
					System.out.println("3");
				    a.showOwnerM();
				}
				if(LoginSystem2.login(user, pass) == 1){
					System.out.println("1");
//					a.showFail();
				}

	    }

	    @FXML
	    void register(ActionEvent event) throws IOException {
	    	   	a.showRegister(); 
	    }

}
