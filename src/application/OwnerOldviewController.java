
package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

public class OwnerOldviewController {
	MenuMain a = new MenuMain();

	@FXML
	private TableView cuView;
	@FXML
	private TableColumn cuname;
	@FXML
	private TableColumn cudata;
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
	private Label serviceDetail;
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

	private static Connection LoginConn = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	ObservableList<User> list = FXCollections.observableArrayList();

	// Initialze the table, and show the summary detail on the table
	public void showList() throws SQLException {

		LoginConn = connection.connectDB(); // connect to the SQL
		st = LoginConn.createStatement(); // create statement of it

		rs = st.executeQuery(
				//"select * from (booking INNER JOIN Details On booking.user_id = details.user_id) INNER JOIN employee ON booking.emp_id = employee.emp_uid WHERE booking.active = 0");
				//"select * from (booking INNER JOIN Details On booking.user_id = details.user_id) INNER JOIN employee ON booking.emp_id = employee.emp_uid INNER JOIN SERVICE on Booking.BOOK_id = SERVICE.BOOK_ID WHERE booking.active = 0");
				"select booking.BOOK_ID, booking.USER_ID \"USER_UID\", EMP_ID, DAY, START_TIME, END_TIME, ACTIVE, DETAILS.USER_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NO, ADDRESS, EMP_FIRST, EMP_LAST, EMP_PHONE, EMP_UID, BOOK_BUS.BOOK_ID \"BOOKBUS_BID\", BOOK_SER, BOOKING.BOOK_ID, BUS_ID from (booking INNER JOIN Details On booking.user_id = details.user_id) INNER JOIN employee ON booking.emp_id = employee.emp_uid INNER JOIN SERVICE on Booking.BOOK_id = SERVICE.BOOK_ID CROSS JOIN BOOK_BUS WHERE booking.book_id = BOOK_BUS.BOOK_ID AND booking.active = 0 and book_bus.bus_id = \"" + LoginSystem2.businessID + "\";");
		while (rs.next()) {
			User user = new User();// create object
			String userFirstName = rs.getString("FIRST_NAME");
			String userSecondName = rs.getString("LAST_NAME");

			user.setUsername(userFirstName + " " + userSecondName);
			user.setUserSecName(rs.getString("LAST_NAME"));
			user.setID(rs.getInt("USER_ID"));
			int dayID = rs.getInt("DAY");

			user.setData(user.defWeekdaysName(dayID));
			user.setBookID(rs.getInt("BOOKBUS_BID"));
			user.setEmpName(rs.getString("EMP_FIRST"));
			user.setEmpID(rs.getInt("EMP_ID"));
			user.setStrTime(rs.getInt("START_TIME"));
			user.setUserService(rs.getString("BOOK_SER"));


			// put value on map
			cuname.setCellValueFactory(new PropertyValueFactory("username"));
			cudata.setCellValueFactory(new PropertyValueFactory("data"));
			// save to list
			list.add(user);
		}
		System.out.println(list.size());
		if (list.size() != 0) {
			showEmpDetails(list.get(0));
		} else
			showEmpDetails(null);

		cuView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				showEmpDetails((User) newValue);
			}
		});
		// set list to table
		cuView.setItems(list); //
	}

	private int bookId;

	// show detail information when check person
	private void showEmpDetails(User Emp) {

		if (Emp != null) {
			// Fill the labels with info from the person object.
			deNa1.setText(Emp.getUsername());
			deNa2.setText(Emp.getEmpName());
			deID1.setText(Integer.toString(Emp.getID()));
			deDa1.setText(Emp.getData());
			bookId = Emp.getBookID();
			deBID1.setText(Integer.toString(Emp.getBookID()));
			deID2.setText(Integer.toString(Emp.getEmpID()));
			deTi1.setText(Integer.toString(Emp.getStrTime()) + " o'clock");
			deTi2.setText(Integer.toString(Emp.getStrTime() + 1) + " o'clock");
			serviceDetail.setText(Emp.getUserService());


		} else {
			// Person is null, remove all the text.
			DetailGrid.setVisible(false);
			warning.setVisible(true);
		}
	}

	// back to owner menu
	@FXML
	void Back(ActionEvent event) throws IOException {
		a.showOwnerM();
	}

	// start
	public void initialize() throws SQLException {
		showList();
	}

	@FXML
	private Label inActiveMsg;

	@FXML
	void inActive(ActionEvent event) throws SQLException {
		Connection LoginConn = null;
		Statement st = null;

		LoginConn = connection.connectDB(); // connect to the SQL
		st = LoginConn.createStatement();

		ResultSet rs2 = st.executeQuery("SELECT * FROM BOOKING WHERE BOOK_ID = " + bookId);
		int empId = rs2.getInt("EMP_ID");
		int day = rs2.getInt("DAY");
		String startTime = rs2.getString("START_TIME");
		String startTimeS;
		if (Integer.valueOf(startTime) < 10) {
			startTime = "0" + startTime;
		}

		ResultSet rs3 = st.executeQuery(
				"SELECT T" + startTime + "00 FROM TIMETABLE WHERE EMP_UID =" + empId + " AND WEEKDAYS = " + day);
		int timeCheck = rs3.getInt("T" + startTime + "00");

		if (timeCheck == 2) {
			System.out.println("This slot has been booked already. Please check in employee's timetable");
		} else if (timeCheck == 0 || timeCheck == 1) {
			PreparedStatement rs = LoginConn.prepareStatement("UPDATE BOOKING SET ACTIVE=1 WHERE BOOK_ID =?");
			rs.setInt(1, bookId);
			rs.executeUpdate();

			PreparedStatement rs4 = LoginConn
					.prepareStatement("UPDATE TIMETABLE SET T" + startTime + "00 = 2 WHERE EMP_UID =? AND WEEKDAYS =?");
			rs4.setInt(1, empId);
			rs4.setInt(2, day);
			rs4.executeUpdate();

			inActiveMsg.setText("Re-active done.");
		}

	}

}