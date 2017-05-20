package PlusOneSecond.PartC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;

public class NewBookingController2 {
	MenuMain a = new MenuMain();


	@FXML
	private JFXTextField userId;

	@FXML
	private Label errorMsg;

	@FXML
	private JFXTextField service;
	@FXML
	private JFXComboBox<String> ServiceList;
	public static String tempService;

	@FXML
	private JFXButton Back;
	@FXML
	private GridPane DetailGrid;

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

	public static int selectedBookIdbookID;
	public static String sss = "";
	
	public void showList() throws SQLException {
		ObservableList<service> list = FXCollections.observableArrayList();
		LoginConn = connection.connectDB(); // connect to the SQL
		st = LoginConn.createStatement(); // create statement of it
		rs = st.executeQuery(
				"select * from SERVICE_DETAILS");
		System.out.println("init work");
		while (rs.next()) {
			service service = new service();// create object
			String ServiceName = rs.getString("SER_NAME");
			int ServiceID = rs.getInt("SER_ID");
			service.setServiceName(ServiceName);
		//	service.setServiceID(ServiceID);
			list.add(service); 
		    ServiceList.getItems().addAll(ServiceName);		
		}
//		ServiceList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener(){

//			@Override
//			public void changed(ObservableValue arg0, Object oldValue, Object newValue) {
//				// TODO Auto-generated method stub
//				showServiceDetails((service) newValue);			
//			}
			
//		});

}	

	
	
	
	
	//show detail information when check person
	private void showServiceDetails(service ser) {
		
		
		
		System.out.println(ser.getServiceName());

	}
    //back to owner menu
	@FXML
	void Back(ActionEvent event) throws IOException {
		//a.showOwnerM();

		
	}
	
    @FXML
    void goTimetable(ActionEvent event) {
		sss = ServiceList.getSelectionModel().getSelectedItem().toString();

    	System.out.println("sss is "+ sss );
	//	warning.setText(sss);
    }
    //start
	public void initialize() throws SQLException {
		showList();
	}


    

    

}
