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
import application.business;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;

public class SuperUserBusinessViewController {
	MenuMain a = new MenuMain();

	@FXML
	private TableView<business> cuView;
	@FXML
	private TableColumn<business, String> cuname;
	@FXML
	private TableColumn<business, String> cudata;
	@FXML
	private JFXButton Back;
	@FXML
	private GridPane DetailGrid;
	@FXML
	private Label buID;
	@FXML
	private Label buNa;
	@FXML
	private Label buPh;
	@FXML
	private Label buDe;
	@FXML
	private Label buAd;
	@FXML
	private Label warning;

	private static Connection LoginConn = null;
	private static Statement st = null;
	private static ResultSet rs = null;

	public static int selectedBookIdbookID;
	ObservableList<business> list = FXCollections.observableArrayList();

	public void showList() throws SQLException {
		int datacount = 0;

		LoginConn = connection.connectDB(); // connect to the SQL
		st = LoginConn.createStatement(); // create statement of it
		rs = st.executeQuery(
				"select * from BUSINESS");
				//"select * from (booking INNER JOIN Details On booking.user_id = details.user_id) INNER JOIN Employee ON booking.Emp_id = Employee.Emp_uid");
		while (rs.next()) {
			business business = new business();// create object
			String BusinessName = rs.getString("BUS_NAME");
			int BusinessID = rs.getInt("BUS_ID");
			String BusinessDesc = rs.getString("BUS_DESC");
			String BusinessAddress = rs.getString("BUS_ADDRESS");
			int BusinessPhone = rs.getInt("BUS_PHONE");
			
			//Set-up Business information
			business.setBusinessName(BusinessName);
			business.setBusinessID(BusinessID);
			business.setBusinessAddress(BusinessAddress);
			business.setBusinessPhone(BusinessPhone);
			business.setBusinessDesc(BusinessDesc);
			datacount++;



			// put object on map
			cuname.setCellValueFactory(new PropertyValueFactory("BusinessName"));
			cudata.setCellValueFactory(new PropertyValueFactory("BusinessID"));
			// add user to list
			list.add(business); 
		}
		System.out.println(list.size());
		if (list.size() != 0) {
			showBusinessDetails(list.get(0));
		} else
			showBusinessDetails(null);

		cuView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				showBusinessDetails((business) newValue);
			}
		});
		// set list to table
		cuView.setItems(list); //
	}
	//show detail information when check person
	private void showBusinessDetails(business bus) {

		if (bus != null) {
			// Fill the labels with info from the person object.
			buNa.setText(bus.getBusinessName());
			buAd.setText(bus.getBusinessAddress());
			buPh.setText(Integer.toString(bus.getBusinessPhone()));
			buDe.setText(bus.getBusinessDesc());
			buID.setText(Integer.toString(bus.getBusinessID()));
			selectedBookIdbookID = bus.getBusinessID();
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
		a.showSuperUserMenu();
	}
    //start
	public void initialize() throws SQLException {
		showList();
		list.add(null);
	}

    @FXML
    private Label inActiveMsg;
   
    
    

}