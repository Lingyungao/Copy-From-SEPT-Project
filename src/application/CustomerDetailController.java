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

public class CustomerDetailController {
	MenuMain a = new MenuMain();
	
	private static Connection LoginConn = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	private static int reId;
	private static String firstName;
	private static String lastName;
	private static String email;
	private static String phoneNo;
	private static String address;
	private static boolean passCheckC;
	private static String password;
	private static String username;
	private static int userIpt;
	private static boolean whileCheck;
	
	@FXML
	private javafx.scene.control.Button editCustomerDetail;
	
	@FXML
	private javafx.scene.control.Button backButton;
	
	@FXML
	private Label firstNameLable;
	
	@FXML
	private Label lastNameLable;
	
	@FXML
	private Label cusPhoneLable;
	
	@FXML
	private Label cusAddressLable;
	
	@FXML
	private Label cusEmailLable;
	
	
	
	@FXML
	 private void editCustomerDetail() throws Exception {
		a.showCusEditM();
	}
	
	 @FXML
	 private void initialize(){
		 DisplayDetails();
		 firstNameLable.setText(firstName);
		 lastNameLable.setText(lastName);
		 cusPhoneLable.setText(phoneNo);
		 cusAddressLable.setText(address);
		 cusEmailLable.setText(email);
	    }
	
	@FXML
	public static void DisplayDetails() {
		try {
			// Start functions

			// Connection LoginConn = null;
			LoginConn = connection.connectDB(); // connect to the SQL
			st = LoginConn.createStatement(); // create statement of it
			rs = st.executeQuery("SELECT * FROM DETAILS where USER_ID = " + LoginSystem2.returnId);

			firstName = rs.getString("FIRST_NAME");
			lastName = rs.getString("LAST_NAME");
			email = rs.getString("EMAIL");
			phoneNo = rs.getString("PHONE_NO");
			address = rs.getString("ADDRESS");
		} catch (Exception e) {
			
			e.printStackTrace();

		}
	}
	
	@FXML
	private void showCustomerDetails() {
		if (LoginSystem2.returnId > 0){
			firstNameLable.setText(firstName);
			lastNameLable.setText(lastName);
			cusPhoneLable.setText(phoneNo);
			cusAddressLable.setText(address);
			cusEmailLable.setText(email);
		}else{
			firstNameLable.setText("");
			lastNameLable.setText("");
			cusPhoneLable.setText("");
			cusAddressLable.setText("");
			cusEmailLable.setText("");
		}
	}
	
	@FXML
    private void editCustomerBack() {
		// get a handle to the stage
	    Stage stage = (Stage) backButton.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	
	

}