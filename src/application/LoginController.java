package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.stage.Window;


public class LoginController {
	MenuMain a = new MenuMain();
	private static Connection LoginConn = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	@FXML
	private JFXPasswordField password;

	@FXML
	private JFXButton login;

	@FXML
	private JFXTextField username;

	@FXML
	private JFXButton register;

	@FXML
	private Label errorMsg;
	
	@FXML
	private JFXComboBox<String> BusinessList;
	
	
	public void showList() throws SQLException {
		ObservableList<business> list = FXCollections.observableArrayList();
		LoginConn = connection.connectDB(); // connect to the SQL
		st = LoginConn.createStatement(); // create statement of it
		rs = st.executeQuery("select * from BUSINESS");
		System.out.println("init work");
		while (rs.next()) {
			business business = new business();// create object
			String BusinessName = rs.getString("BUS_NAME");
			// int BusinessID = rs.getInt("SER_ID");
			business.setBusinessName(BusinessName);
			// business.setBusinessID(BusinessID);
			list.add(business);
			BusinessList.getItems().addAll(BusinessName);
		}
	}

	
	public void initialize() throws SQLException {
		showList();
	}
	
	@FXML
	private void login(ActionEvent event) throws Exception {

		String user = username.getText();
		String pass = password.getText();
		try {
			int temp = 0;
			temp = LoginSystem2.login(user, pass);
			if (temp == 2) {
				System.out.println("2");
				a.showCusM();
			} else if (temp == 3) {
				System.out.println("3");
				a.showOwnerM();
			} else if (temp == 1) {
				System.out.println("1");
				// a.showFail();
			}
		} catch (NullPointerException NE) {
			errorMsg.setText("wrong username or password");
			System.out.println("The account is not exist or you do not register an account");
		}

	}

	@FXML
	void register(ActionEvent event) throws IOException {
		a.showRegister();
	}

}
