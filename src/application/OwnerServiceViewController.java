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

public class OwnerServiceViewController {
	MenuMain a = new MenuMain();

	@FXML
	private TableView<service> cuView;
	@FXML
	private TableColumn<service, String> cuname;
	@FXML
	private TableColumn<service, String> cudata;
	@FXML
	private JFXButton Back;
	@FXML
	private GridPane DetailGrid;
	@FXML
	private Label seID;
	@FXML
	private Label seNa;
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
	ObservableList<service> list = FXCollections.observableArrayList();

	public void showList() throws SQLException {
		int datacount = 0;

		LoginConn = connection.connectDB(); // connect to the SQL
		st = LoginConn.createStatement(); // create statement of it
		rs = st.executeQuery(
				"select * from SERVICE_DETAILS cross join SER_D_BUS CROSS JOIN business where SERVICE_DETAILS.SER_ID = SER_D_BUS.SER_ID and business.BUS_ID = SER_D_BUS.BUS_ID and BUSINESS.BUS_ID = \"" + LoginSystem2.businessID + "\";");
				//"select * from SERVICE_DETAILS");
				//"select * from (booking INNER JOIN Details On booking.user_id = details.user_id) INNER JOIN Employee ON booking.Emp_id = Employee.Emp_uid");
		while (rs.next()) {
			service service = new service();// create object
			String ServiceName = rs.getString("SER_NAME");
			int ServiceID = rs.getInt("SER_ID");
			service.setServiceName(ServiceName);
			service.setServiceID(ServiceID);
			datacount++;



			// put object on map
			cuname.setCellValueFactory(new PropertyValueFactory("ServiceName"));
			cudata.setCellValueFactory(new PropertyValueFactory("ServiceID"));
			// add user to list
			list.add(service); 
		}
		System.out.println(list.size());
		if (list.size() != 0) {
			showServiceDetails(list.get(0));
		} else
			showServiceDetails(null);

		cuView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				showServiceDetails((service) newValue);
			}
		});
		// set list to table
		cuView.setItems(list); //
	}
	//show detail information when check person
	private void showServiceDetails(service ser) {

		if (ser != null) {
			// Fill the labels with info from the person object.
			seNa.setText(ser.getServiceName());
			seID.setText(Integer.toString(ser.getServiceID()));
			selectedBookIdbookID = ser.getServiceID();
			System.out.println("selectedBookIdbookID"+selectedBookIdbookID );
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
	public void initialize() throws SQLException{
		showList();
	}

    @FXML
    private Label inActiveMsg;
    
    @FXML
    void AddService(ActionEvent event) throws SQLException, IOException {

 		a.showNewService();
 
    }
    @FXML
    void DeleteService(ActionEvent event) throws SQLException, IOException {
		a.showDeleteService(selectedBookIdbookID);        
    }
    
    

}