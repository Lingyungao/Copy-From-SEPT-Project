package application;

import java.io.IOException;
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
public class SuperUserBusinessAddController {
	
	MenuMain a = new MenuMain();

	private static Connection LoginConn = null;
	private static ResultSet rs = null;
	private static ResultSet rs2 = null;
	private static Statement st = null;
	private static Statement st2 = null;
	private static String businessName;
	private static String businessAddress;
	private int businessPhoneNumber;
	private static String businessDesc;
	public static int BusCount;

	@FXML
	private TextField regBusNameField;
	@FXML
	private TextField regBusAddressField;
	@FXML
	private TextField regBusPhoneField;
	@FXML
	private TextField regBusDescField;
	

	@FXML
	private com.jfoenix.controls.JFXButton closeButton;

	@FXML
	private Text cusInfoText;

    @FXML
    private TextField regID;
	
    @FXML
    private JFXPasswordField regPW;

    @FXML
    private JFXPasswordField regPWC;

	/**
	 * initialize the JavaFX table make sure the table is empty
	 */
	@FXML
	private void initialize() {
		GetBusID();
		regBusNameField.setText("");
		regBusAddressField.setText("");
		regBusPhoneField.setText("");
		regBusDescField.setText("");
	}

	/**
	 * Get the max user's id for register new user
	 */
	@FXML
	public static void GetBusID() {
		try {
			LoginConn = connection.connectDB();
			st = LoginConn.createStatement(); // create statement of it
			rs = st.executeQuery("SELECT * FROM BUSINESS order by BUS_ID desc limit 0,1;");
			BusCount = rs.getInt("BUS_ID");
		} catch (Exception e) {

			BusCount=0;
			
		}
	}
	
	public int GetUserID() throws SQLException {
		Connection LoginConn = connection.connectDB();
		Statement  st = LoginConn.createStatement(); // create statement of it
		ResultSet  rs = st.executeQuery("SELECT COUNT(USER_ID) FROM USERS");
		int	userCount = rs.getInt("COUNT(USER_ID)");
		return userCount+1;
	}
	
	

	/**
	 * Register user function. insert username, password to user table. insert
	 * firstname, lastname, and other information to detail table.
	 */
	@FXML
	private void regUser() throws Exception {
		// Connection LoginConn = null;
		// Check user's input is valid or not by using CusHandleException class
		// If not, throw exception
		try {
			if (regBusNameField.getText() == "" || regBusAddressField.getText() == "" || regBusPhoneField.getText() == ""
					|| regBusDescField.getText() == "") {
				cusInfoText.setText("Please Input All information, before you submit!");
			}
			if (BusHandleException.BusNameInputCheck(regBusNameField.getText()) == false) {
				cusInfoText.setText("Sorry! Username length cannot less than 3 or more than 30!");
				throw new Exception("Sorry! Username length cannot less than 3 or more than 30!");
			}
			if (BusHandleException.BusDescInputCheck(regBusDescField.getText()) == false) {
				cusInfoText.setText("Sorry! Username length cannot less than 3 or more than 150!");
				throw new Exception("Sorry! Username length cannot less than 3 or more than 150!");
			}
			if (BusHandleException.BusFuncPhoneInputCheck(regBusPhoneField.getText()) == false) {
				cusInfoText.setText("Sorry, Phone number length cannot less than 5 or more than 15, and number only!");
				throw new Exception("Sorry, Phone number length cannot less than 5 or more than 15, and number only!");
			}
			if (BusHandleException.BusFuncAddressInputCheck(regBusAddressField.getText()) == false) {
				cusInfoText.setText("Address length between 15 to 150, and cannot only input number or characters!");
				throw new Exception("Address length between 15 to 150, and cannot only input number or characters!");
			}
			
			if (regPW.getText().equals(regPWC.getText())== false) {
				cusInfoText.setText("password and comfirmation is not same!");
				throw new Exception("password and comfirmation is not same!");
			}
			
			int i = 0;
			
			try{
			i = GetUserID();
			}
			catch(SQLException SE)
			{
				i = 1;
				System.out.println("Not user in table now");
			}
			
			PreparedStatement rs = LoginConn
					.prepareStatement("INSERT INTO BUSINESS(BUS_ID, BUS_NAME, BUS_PHONE, BUS_ADDRESS, BUS_DESC) VALUES(?,?,?,?,?)");
			rs.setString(2, regBusNameField.getText());
			rs.setString(3, regBusPhoneField.getText());
			rs.setString(4, regBusAddressField.getText());
			rs.setString(5, regBusDescField.getText());
			// excuteQuery for query. excuteUpdate for editing the database
			// Insert user name and password to the user table
			rs.executeUpdate();

//			PreparedStatement rs2 = LoginConn.prepareStatement(
//					"INSERT INTO DETAILS(USER_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NO,ADDRESS) VALUES(?,?,?,?,?,?)");
//			rs2.setInt(1, userCount2);
//			rs2.setString(2, regFirstNameField.getText());
//			rs2.setString(3, regLastNameField.getText());
//			rs2.setString(4, regEmailField.getText());
//			rs2.setString(5, regPhoneField.getText());
//			rs2.setString(6, regAddressField.getText());
//			// Insert firstname, lastname, and other inofrmation to detail
//			// table.
//			rs2.executeUpdate();
			
			PreparedStatement rs1 = LoginConn
					.prepareStatement("INSERT INTO USERS(USERNAME,PASSWORD,USER_ID,PERMISSION) VALUES(?,?,?,2)");
			rs1.setString(1, regID.getText());
			rs1.setString(2, regPW.getText());
			rs1.setInt(3, i);
			rs1.executeUpdate();
			
			PreparedStatement rs4 = LoginConn.prepareStatement(
					"INSERT INTO USERS_BUS(USER_ID,BUS_ID) VALUES(?,?)");
			rs4.setInt(1, i);
			rs4.setInt(2, BusCount+1);
			rs4.executeUpdate();

			cusInfoText.setText("Add Business succeed!");

		} catch (Exception e) {

		}
	}

	@FXML
	private void login() throws IOException {
		a.showSuperUserMenu();
	}

}