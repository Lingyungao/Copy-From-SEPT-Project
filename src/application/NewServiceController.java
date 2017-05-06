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
				"select * from SERVICE_DETAILS");
		int datacount = 0;
		//DATACOUNT is use to get new ID
		while (rs.next()) {datacount++;}
		
		String sql = "INSERT INTO SERVICE_DETAILS(SER_NAME,SER_ID) VALUES("+(datacount+1)+","+tempService+")";
		String sqltest = "INSERT INTO SERVICE_DETAILS(SER_NAME,SER_ID) VALUES(6,temp)";

		System.out.println(sql);
		System.out.println(sqltest);

		PreparedStatement psmt = LoginConn.prepareStatement(sql);
		psmt.execute();
		System.out.println("REPORT AS001");
}
}
