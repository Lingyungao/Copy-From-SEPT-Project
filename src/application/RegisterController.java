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


/**
 * This class is working for register new customer.
 *
 */
public class RegisterController {
	
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
	public static int userCount;
	public static int userCount2;

	@FXML
    private TextField regUsernameField;
    @FXML
    private TextField regFirstNameField;
    @FXML
    private TextField regLastNameField;
    @FXML
    private TextField regAddressField;
    @FXML
    private TextField regEmailField;
    @FXML
    private TextField regPhoneField;
    @FXML
    private TextField regPassField;
    @FXML
    private TextField regConfField;
    @FXML 
    private com.jfoenix.controls.JFXButton closeButton;
    
    @FXML
    private Text cusInfoText;
    
    
    /**
     * initialize the JavaFX table
     * make sure the table is empty
     */
    @FXML
	 private void initialize(){
    	 GetUserID();
    	 regUsernameField.setText("");
		 regFirstNameField.setText("");
		 regLastNameField.setText("");
		 regPhoneField.setText("");
		 regAddressField.setText("");
		 regEmailField.setText("");
		 regPassField.setText("");
		 regConfField.setText("");
	    }
	
    /**
     * Get the max user's id for register new user
     */
	@FXML
	public static void GetUserID() {
		try {
			LoginConn = connection.connectDB();
			st = LoginConn.createStatement(); // create statement of it
			rs = st.executeQuery("SELECT COUNT(USER_ID) FROM USERS");
			userCount = rs.getInt("COUNT(USER_ID)");
			userCount2 = userCount + 1;
		} catch (Exception e) {
			
			e.printStackTrace();

		}
	}
	
	/**
     * Register user function.
     * insert username, password to user table.
     * insert firstname, lastname, and other information to detail table.
     */
	@FXML
    private void regUser() throws Exception {
		// Connection LoginConn = null;
		// Check user's input is valid or not by using CusHandleException class
		// If not, throw exception
		try{
			if(regFirstNameField.getText() == "" || regLastNameField.getText() == "" || regPhoneField.getText() == "" || regAddressField.getText() == "" || regEmailField.getText() == ""){
				cusInfoText.setText("Please Input All information, before you submit!");
			}
			if(CusHandleException.UserNameInputCheck(regUsernameField.getText()) == false){
				cusInfoText.setText("Sorry! Username length cannot less than 3 or more than 17, and character only!");	
				throw new Exception("Sorry! Username length cannot less than 3 or more than 17, and character only!");
			}
			if(CusHandleException.UserNameInputCheck(regFirstNameField.getText()) == false){
				cusInfoText.setText("Sorry! first name length cannot less than 3 or more than 17, and character only!");	
				throw new Exception("Sorry! first name length cannot less than 3 or more than 17, and character only!");
			}
			if(CusHandleException.UserNameInputCheck(regLastNameField.getText()) == false){
				cusInfoText.setText("Sorry! last name length cannot less than 3 or more than 17, and character only!");	
				throw new Exception("Sorry! last name length cannot less than 3 or more than 17, and character only!");
			}
			if(CusHandleException.UserFuncPhoneInputCheck(regPhoneField.getText()) == false){
				cusInfoText.setText("Sorry, Phone number length cannot less than 5 or more than 15, and number only!");
				throw new Exception("Sorry, Phone number length cannot less than 5 or more than 15, and number only!");
			}
			if(CusHandleException.UserFuncAddressInputCheck(regAddressField.getText()) == false){
				cusInfoText.setText("Address length between 15 to 150, and cannot only input number or characters!");
				throw new Exception("Address length between 15 to 150, and cannot only input number or characters!");
			}
			if(CusHandleException.EmailInputCheck(regEmailField.getText()) == false){
				cusInfoText.setText("Sorry, The email is not valid. Please input valid email. e.g: 123@gmail.com");
				throw new Exception("Sorry, The email is not valid. Please input valid email. e.g: 123@gmail.com");
			}
			if(!regPassField.getText().equals(regConfField.getText())){
				cusInfoText.setText("Sorry, The password that your input is not same, please try again!");
				throw new Exception("Sorry, The password that your input is not same, please try again!");
			}
			if(CusHandleException.PasswordInputCheck(regPassField.getText()) == false){
				cusInfoText.setText("The password needs include number, symbol and character, the length between 5 to 17!");
				throw new Exception("The password needs include number, symbol and character, the length between 5 to 17!");
			}
			PreparedStatement rs = LoginConn
					.prepareStatement("INSERT INTO USERS(USERNAME,PASSWORD,USER_ID,PERMISSION) VALUES(?,?,?,1)");
			rs.setString(1, regUsernameField.getText());
			rs.setString(2, regPassField.getText());
			rs.setInt(3, userCount2);
			// excuteQuery for query. excuteUpdate for editing the database
			// Insert user name and password to the user table
			rs.executeUpdate();
			
			PreparedStatement rs2 = LoginConn.prepareStatement(
					"INSERT INTO DETAILS(USER_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NO,ADDRESS) VALUES(?,?,?,?,?,?)");
					rs2.setInt(1, userCount2);
					rs2.setString(2, regFirstNameField.getText());
					rs2.setString(3, regLastNameField.getText());
					rs2.setString(4, regEmailField.getText());
					rs2.setString(5, regPhoneField.getText());
					rs2.setString(6, regAddressField.getText());
					// Insert firstname, lastname, and other inofrmation to detail table.
					rs2.executeUpdate();
			
			cusInfoText.setText("Register succeed!");

		}
		catch (Exception e){
			
		}
	}
	
	@FXML
    private void login() {
		// get a handle to the stage
	    Stage stage = (Stage) closeButton.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	



}