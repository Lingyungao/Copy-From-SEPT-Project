package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class NewServiceController {
	private String regNumOnly = "^[0-9]+$";
	private static Connection LoginConn = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	public static String userIdCheck;
	MenuMain a = new MenuMain();

	@FXML
	private JFXButton AddService;

	@FXML
	private Label errorMsg;

	@FXML
	private JFXTextField service;

	public static String tempService;

	@FXML
	void AddService(ActionEvent event) throws NumberFormatException, IOException, SQLException {
		LoginConn = connection.connectDB(); // connect to the SQL
		st = LoginConn.createStatement(); // create statement of it
		tempService = service.getText();
		//get user input
		rs = st.executeQuery(
				"select * from COUNT(SERVICE_DETAILS)");
		int datacount = rs.getInt("COUNT(SERVICE_DETAILS)");
		//DATACOUNT is use to get new ID
		
		PreparedStatement psmt = LoginConn.prepareStatement("INSERT INTO SERVICE_DETAILS(SER_NAME,SER_ID) VALUES(?,?)");
		psmt.setInt(1,datacount+1);
		psmt.setString(2, "");
		psmt.executeUpdate();
		System.out.println("REPORT NS001");
}
}
