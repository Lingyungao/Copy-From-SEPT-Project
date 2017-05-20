package PlusOneSecond.PartC;

import java.io.IOException;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;

import PlusOneSecond.PartC.CustomerBookEmployer;
import PlusOneSecond.PartC.CustomerBookGetEmployer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * This class is working for customer view booking menu.
 *
 */
public class CustomerViewBookingMenuController {
	static int Selection;
	private CustomerCheckGetBooking CusGetCusBooking;
	MenuMain a = new MenuMain();

	@FXML
	private TableView<CustomerCheckBooking> cusViewBookTable;
	@FXML
	private TableColumn<CustomerCheckBooking, Integer> bookIdCol;
	@FXML
	private TableColumn<CustomerCheckBooking, String> empNameCol;
	@FXML
	private TableColumn<CustomerCheckBooking, String> bookingTimeCol;
	@FXML
	private Label bookId;
	@FXML
	private Label empId;
	@FXML
	private Label empName;
	@FXML
	private Label bookDate;
	@FXML
	private Label startTime;
	@FXML
	private Label endTime;
	@FXML
	private Label serviceDetail;
	@FXML
	private JFXButton Back;

	// Initialze the table, and show the summary detail on the table
	@FXML
	private void initialize() {
		bookIdCol.setCellValueFactory(cellData -> cellData.getValue().bookIdProperty().asObject());
		empNameCol.setCellValueFactory(cellData -> cellData.getValue().empNameProperty());
		bookingTimeCol.setCellValueFactory(cellData -> cellData.getValue().startTimeProperty());

		// showEmpDetails(null);

		cusViewBookTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showCusBookDetails(newValue));
	}

	public void setGetCusBooking(CustomerCheckGetBooking CusGetBooking) {
		this.CusGetCusBooking = CusGetBooking;
		cusViewBookTable.setItems(CusGetBooking.getCusBookingData());

	}

	private void showCusBookDetails(CustomerCheckBooking CusBook) {

		if (CusBook != null) {
			// Fill the labels with info from the person object.
			bookId.setText(Integer.toString(CusBook.getBookId()));
			empId.setText(Integer.toString(CusBook.getEmpId()));
			empName.setText(CusBook.getEmpName());
			bookDate.setText(CusBook.getBookDate());
			startTime.setText(CusBook.getStartTime());
			endTime.setText(CusBook.getEndTime());
			serviceDetail.setText(CusBook.getServiceName());

		} else {
			// Person is null, remove all the text.
			bookId.setText("");
			empId.setText("");
			empName.setText("");
			bookDate.setText("");
			startTime.setText("");
			endTime.setText("");
		}
	}

	@FXML
	void Back(ActionEvent event) throws IOException {
		a.showCusM();
	}

}