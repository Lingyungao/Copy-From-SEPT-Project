package application;

import java.io.IOException;
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

/**
 * This class is working for get customer detail.
 *
 */
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
    private JFXButton Back;
    
	@FXML
	private JFXButton editCustomerDetail;
	
	@FXML
	private JFXButton backButton;
	
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
	
	
	// Edit customer detail function, show Edit customer detail menu.
	@FXML
	 private void editCustomerDetail() throws Exception {
		a.showCusEditM(editCustomerDetail);
	}
	
	// Initialize the tables, and make sure when customer click the edit button
	// it will show the regional information.
	 @FXML
	 private void initialize(){
		 DisplayDetails();
		 firstNameLable.setText(firstName);
		 lastNameLable.setText(lastName);
		 cusPhoneLable.setText(phoneNo);
		 cusAddressLable.setText(address);
		 cusEmailLable.setText(email);
	    }
	
	/**
	 * Display current detail on the detail window.
	 * 
	 */
	@FXML
	public static void DisplayDetails() {
		try {
			// Start functions
			// Connection LoginConn = null;
			// Connect to the database
			LoginConn = connection.connectDB(); 
			// create statement of it
			st = LoginConn.createStatement(); 
			// Run SQL
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
	/**
     * Show customer's detail. 
     * If customer is not exist, does not show anything.
     */
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
	
	/**
     * When user click edit button, go to edit detail window.
     */
	@FXML
    private void editCustomerBack() {
		// get a handle to the stage
	    Stage stage = (Stage) backButton.getScene().getWindow();
	    // do what you have to do
	    stage.close();
	}
	
	/**
     * When user click back button, go to previous window.
     */
    @FXML
    void Back(ActionEvent event) throws IOException {
    	a.showCusM();
    }


}
