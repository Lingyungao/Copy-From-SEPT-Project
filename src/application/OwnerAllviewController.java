package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.*;
import application.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

public class OwnerAllviewController {
	MenuMain a = new MenuMain();

	@FXML
	private TableView<User> cuView;
	@FXML
	private TableColumn<User, String> cuname;
	@FXML
	private TableColumn<User, String> cudata;
	@FXML
	private JFXButton Back;
	@FXML
	private GridPane DetailGrid;
	@FXML
	private Label deNa1;
	@FXML
	private Label deNa2;
	@FXML
	private Label deID1;
	@FXML
	private Label deID2;
	@FXML
	private Label deDa1;
	@FXML
	private Label deTi1;
	@FXML
	private Label deTi2;
	@FXML
	private Label dePh1;
	@FXML
	private Label deBID1;
	@FXML
	private Button SWITCH_CUSTOMERVIEWALL;
	@FXML
	private Button ADDEMPLOYEESwitch;
	@FXML
	private Button EMPEDITSwitch;
	@FXML
	private Button EMPTIMETABLESwitch;
	@FXML
	private Button SWITCH_CUSTOMEROLDVIEW;
	@FXML
	private Label warning;

	private String weekdaysName;
	private static Connection LoginConn = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	private static ResultSet finder = null;

	public void showList() throws SQLException {
		int i = 0;

		ObservableList<User> list = FXCollections.observableArrayList();
		LoginConn = connection.connectDB(); // connect to the SQL
		st = LoginConn.createStatement(); // create statement of it
		rs = st.executeQuery(
				"select * from (booking INNER JOIN Details On booking.user_id = details.user_id) INNER JOIN employee ON booking.emp_id = employee.emp_uid WHERE booking.active = 1");
				//"select * from (booking INNER JOIN Details On booking.user_id = details.user_id) INNER JOIN Employee ON booking.Emp_id = Employee.Emp_uid");
		while (rs.next()) {
			User user = new User();// create object
			String userFirstName = rs.getString("FIRST_NAME");
			String userSecondName = rs.getString("LAST_NAME");
			user.setID(rs.getInt("USER_ID"));
			int dayID = rs.getInt("DAY");
			user.setUsername(userFirstName + " " + userSecondName);
			user.setData(user.defWeekdaysName(dayID));
			user.setBookID(rs.getInt("BOOK_ID"));
			user.setEmpName(rs.getString("EMP_FIRST"));
			user.setEmpID(rs.getInt("EMP_ID"));
			user.setStrTime(rs.getInt("START_TIME"));



			// put object on map
			cuname.setCellValueFactory(new PropertyValueFactory("username"));
			cudata.setCellValueFactory(new PropertyValueFactory("data"));
			// add user to list
			list.add(user); 
		}
		showEmpDetails(list.get(0));
        //get user attention
		cuView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				showEmpDetails((User) newValue);
			}
		});
		
        
		//set list to table
		cuView.setItems(list); 
	}
	//show detail information when check person
	private void showEmpDetails(User Emp) {

		if (Emp != null) {
			// Fill the labels with info from the person object.
			deNa1.setText(Emp.getUsername());
			deNa2.setText(Emp.getEmpName());
			deID1.setText(Integer.toString(Emp.getID()));
			deDa1.setText(Emp.getData());
			deBID1.setText(Integer.toString(Emp.getBookID()));
			deID2.setText(Integer.toString(Emp.getEmpID()));
			deTi1.setText(Integer.toString(Emp.getStrTime()) + " o'clock");
			deTi2.setText(Integer.toString(Emp.getStrTime() + 1) + " o'clock");

		} else {
			// Person is null, remove all the text.
			DetailGrid.setVisible(false);
			warning.setVisible(true);

		}
	}
    //back to owner menu
	@FXML
	void Back(ActionEvent event) throws IOException {
		a.showOwnerM();
	}
    //start
	public void initialize() throws SQLException {
		showList();
	}


}