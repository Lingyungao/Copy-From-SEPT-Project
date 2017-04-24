package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import javafx.scene.text.Text;



public class CustomerDetailEditController {
	
	private static Connection LoginConn = null;
	private static ResultSet rs = null;
	private static ResultSet rs2 = null;
	private static Statement st = null;
	private static Statement st2 = null;
	private static String firstName;
	private static String lastName;
	private static String email;
	private static String phoneNo;
	private static String address;
	private int phoneNumber;

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
    private TextField cusPassEditField;
    @FXML
    private TextField cusPassConfField;
    @FXML
    private Text cusInfoText;
    @FXML 
    private javafx.scene.control.Button cusBackButton;
    
    
    
    
    @FXML
	 private void initialize(){
		 DisplayDetails();
		 firstNameField.setText(firstName);
		 lastNameField.setText(lastName);
		 cusPhoneField.setText(phoneNo);
		 cusAddressField.setText(address);
		 cusEmailField.setText(email);
		 cusPassEditField.setText("");
		 cusPassConfField.setText("");
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
    private void saveChange() throws Exception {
		// Connection LoginConn = null;
		try{
			if(firstNameField.getText() == "" || lastNameField.getText() == "" || cusPhoneField.getText() == "" || cusAddressField.getText() == "" || cusEmailField.getText() == ""){
				cusInfoText.setText("Please Input All information, before you submit!");
			}
			if(HandleException.UserNameInputCheck(firstNameField.getText()) == false){
				cusInfoText.setText("Sorry! first name length cannot less than 3 or more than 17, and character only!");	
				throw new Exception("Sorry! first name length cannot less than 3 or more than 17, and character only!");
			}
			if(HandleException.UserNameInputCheck(lastNameField.getText()) == false){
				cusInfoText.setText("Sorry! last name length cannot less than 3 or more than 17, and character only!");	
				throw new Exception("Sorry! last name length cannot less than 3 or more than 17, and character only!");
			}
			if(HandleException.UserFuncPhoneInputCheck(cusPhoneField.getText()) == false){
				cusInfoText.setText("Sorry, Phone number length cannot less than 5 or more than 15, and number only!");
				throw new Exception("Sorry, Phone number length cannot less than 5 or more than 15, and number only!");
			}
			if(HandleException.UserFuncAddressInputCheck(cusAddressField.getText()) == false){
				cusInfoText.setText("Address length between 15 to 150, and cannot only input number or characters!");
				throw new Exception("Address length between 15 to 150, and cannot only input number or characters!");
			}
			if(HandleException.EmailInputCheck(cusEmailField.getText()) == false){
				cusInfoText.setText("Sorry, The email is not valid. Please input valid email. e.g: 123@gmail.com");
				throw new Exception("Sorry, The email is not valid. Please input valid email. e.g: 123@gmail.com");
			}
			if(!cusPassEditField.getText().equals(cusPassConfField.getText())){
				cusInfoText.setText("Sorry, The password that your input is not same, please try again!");
				throw new Exception("Sorry, The password that your input is not same, please try again!");
			}
			if(HandleException.PasswordInputCheck(cusPassEditField.getText()) == false){
				cusInfoText.setText("The password needs include number, symbol and character, the length between 5 to 17!");
				throw new Exception("The password needs include number, symbol and character, the length between 5 to 17!");
			}
			FirstNameChange(firstNameField.getText());
			LastNameChange(lastNameField.getText());
			PhoneNumberChange(Integer.parseInt(cusPhoneField.getText()));
			AddressChange(cusAddressField.getText());
			EmailChange(cusEmailField.getText());
			PasswordChange(cusPassEditField.getText());
			cusInfoText.setText("Change succeed!");

		}
		catch (Exception e){
			
		}
	}
	
	@FXML
    private void cancleChange() {
		// get a handle to the stage
	    Stage stage = (Stage) cusBackButton.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	
	public static void FirstNameChange(String firstName) throws Exception {
		//Check the First name is valid or not
		
		//if the user do not input anything, show an error message
		if (firstName.equals("")) {
			throw new Exception("Please input First Name.");
		} else {
			//connect database
			LoginConn = connection.connectDB();
			//update first name
			PreparedStatement rs = LoginConn.prepareStatement("UPDATE DETAILS SET FIRST_NAME = ? WHERE USER_ID = ?");
			rs.setString(1, firstName);
			rs.setInt(2, LoginSystem2.returnId);
			rs.executeUpdate();
			//show successful message
			System.out.println("First Name changed successful");
		}

	}
	
	public static void LastNameChange(String lastName) throws Exception {

		if (lastName.equals("")) {
			throw new Exception("Please input Last Name.");
		} else {
			//connect database
			LoginConn = connection.connectDB();
			//update last name
			PreparedStatement rs = LoginConn.prepareStatement("UPDATE DETAILS SET LAST_NAME = ? WHERE USER_ID = ?");
			rs.setString(1, lastName);
			rs.setInt(2, LoginSystem2.returnId);
			rs.executeUpdate();
			//show successful message
			System.out.println("Last Name changed successful");
		}

	}
	
	public static void PhoneNumberChange(int phonenumber) throws Exception {

		if (phonenumber == 0) {
			throw new Exception("Please input Phone number.");
		} else {
			//connect database
			LoginConn = connection.connectDB();
			//update phone number
			PreparedStatement rs = LoginConn.prepareStatement("UPDATE DETAILS SET PHONE_NO = ? WHERE USER_ID = ?");
			rs.setInt(1, phonenumber);
			rs.setInt(2, LoginSystem2.returnId);
			rs.executeUpdate();
			//show successful message
			System.out.println("Phone Number changed successful");
		}

	}
	
	public static void AddressChange(String address) throws Exception {
		
		if (address.equals("")) {
			throw new Exception("Please input Address.");
		} else {
			//connect database
			LoginConn = connection.connectDB();
			//update address
			PreparedStatement rs = LoginConn.prepareStatement("UPDATE DETAILS SET ADDRESS = ? WHERE USER_ID = ?");
			rs.setString(1, address);
			rs.setInt(2, LoginSystem2.returnId);
			rs.executeUpdate();
			//show successful message
			System.out.println("Address changed successful!");
		}

	}
	
	public static void EmailChange(String email) throws Exception {

		if (address.equals("")) {
			throw new Exception("Please input Email Address.");
		} else {
			//connect database
			LoginConn = connection.connectDB();
			//update address
			PreparedStatement rs = LoginConn.prepareStatement("UPDATE DETAILS SET EMAIL = ? WHERE USER_ID = ?");
			rs.setString(1, email);
			rs.setInt(2, LoginSystem2.returnId);
			rs.executeUpdate();
			//show successful message
			System.out.println("Email changed successful!");
		}

	}
	
	public static void PasswordChange(String password) throws Exception {
		
		//if the user do not input anything, show an error message
		if (password.equals("")) {
			throw new Exception("Please input Password.");
		} else {
			//connect database
			LoginConn = connection.connectDB();
			//update the password
			PreparedStatement rs = LoginConn.prepareStatement("UPDATE USERS SET PASSWORD = ? WHERE USER_ID = ?");
			rs.setString(1, password);
			rs.setInt(2, LoginSystem2.returnId);
			rs.executeUpdate();
			//show successful message
			System.out.println("Password changed");
		}

	}


}