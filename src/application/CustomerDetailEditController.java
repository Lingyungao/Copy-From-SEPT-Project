package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

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

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;



public class CustomerDetailEditController {
	
	private static Connection LoginConn = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	private static String firstName;
	private static String lastName;
	private static String email;
	private static String phoneNo;
	private static String address;

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField cusPhoneField;
    @FXML
    private TextField cusAddressField;
    @FXML
    private TextField cusEmailField;
    
    
    
    
    @FXML
	 private void initialize(){
		 DisplayDetails();
		 firstNameField.setText(firstName);
		 lastNameField.setText(lastName);
		 cusPhoneField.setText(phoneNo);
		 cusAddressField.setText(address);
		 cusEmailField.setText(email);
	    }
	
	@FXML
	public static void DisplayDetails() {
		try {
			// Start functions

			// Connection LoginConn = null;
			LoginConn = connection.connectDB(); // connect to the SQL
			st = LoginConn.createStatement(); // create statement of it
			rs = st.executeQuery("SELECT * FROM DETAILS where USER_ID = " + LoginSystem2.userId);

			firstName = rs.getString("FIRST_NAME");
			lastName = rs.getString("LAST_NAME");
			email = rs.getString("EMAIL");
			phoneNo = rs.getString("PHONE_NO");
			address = rs.getString("ADDRESS");
		} catch (Exception e) {
			System.out.println("NO!!");
			e.printStackTrace();

		}
	}
	
	@FXML
    private void saveChange() {
		
	}
	
	@FXML
    private void cancleChange() {
		
	}


}