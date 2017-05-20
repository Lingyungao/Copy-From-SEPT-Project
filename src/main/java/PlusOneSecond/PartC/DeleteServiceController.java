package PlusOneSecond.PartC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class DeleteServiceController {
	private String regNumOnly = "^[0-9]+$";
	private static Connection LoginConn = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	public static String userIdCheck;
	MenuMain a = new MenuMain();
	private static int datacount=0;
	int id = OwnerServiceViewController.selectedBookIdbookID;


	@FXML
	private JFXButton AddService;

	@FXML
	private Label errorMsg;

	@FXML
	private JFXTextField service;

	public static String tempService;

	@FXML
	void DeleteServiceYes(ActionEvent event) throws NumberFormatException, IOException, SQLException {
		LoginConn = connection.connectDB(); // connect to the SQL
		st = LoginConn.createStatement(); // create statement of it
		rs = st.executeQuery(
				"select * from (SERVICE_DETAILS)");

		System.out.println("selectedBookIdbookID FROM DEL"+id);
		PreparedStatement psmt = LoginConn.prepareStatement("DELETE FROM SERVICE_DETAILS WHERE SER_ID = "+id);
		psmt.executeUpdate();
		System.out.println("REPORT NS001");
 		a.showViewService();
}
	@FXML
	void DeleteServiceNo(ActionEvent event) throws NumberFormatException, IOException, SQLException {
		 }
}
