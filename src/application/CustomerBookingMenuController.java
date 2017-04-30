package application;

import java.io.IOException;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import application.CustomerBookGetEmployer;
import application.CustomerBookEmployer;

/**
 * This class is working on the customer view booking menu.
 *
 */
public class CustomerBookingMenuController {
	static int Selection;
	private CustomerBookGetEmployer getEmployer;
	MenuMain a = new MenuMain();

	@FXML
	private Label firstName;

	@FXML
	private JFXButton Back;

	@FXML
	private Label lastName;

	@FXML
	public Label empID;

	@FXML
	private Label empPhone;

	@FXML
	private JFXButton editDetail;

	@FXML
	private JFXButton checkBook;

	@FXML
	private JFXButton makeBook;

	@FXML
	private TableView<CustomerBookEmployer> employeeTable;

	@FXML
	private TableColumn<CustomerBookEmployer, Integer> empIdCol;

	@FXML
	private TableColumn<CustomerBookEmployer, String> firstNameCol;

	@FXML
	private TableColumn<CustomerBookEmployer, String> lastNameCol;

	@FXML
	private void initialize() {
		firstNameCol.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		lastNameCol.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
		empIdCol.setCellValueFactory(cellData -> cellData.getValue().empIdProperty().asObject());

		// showEmpDetails(null);

		employeeTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showEmpDetails(newValue));
	}

	/**
	 * Function for setup employee's detail
	 * 
	 * @param get
	 *            employer
	 */
	public void setGetEmployer(CustomerBookGetEmployer getEmployer) {
		this.getEmployer = getEmployer;
		employeeTable.setItems(getEmployer.getEmployerData());

	}

	/**
	 * Function for show employee's detail
	 * 
	 * @param employer
	 */
	private void showEmpDetails(CustomerBookEmployer Emp) {

		if (Emp != null) {
			// Fill the labels with info from the person object.
			firstName.setText(Emp.getFirstName());
			lastName.setText(Emp.getLastName());
			empPhone.setText(Emp.getPhone());
			empID.setText(Integer.toString(Emp.getEmpId()));
			tempEmpId = empID.getText();
		} else {
			// Person is null, remove all the text.
			firstName.setText("");
			lastName.setText("");
			empID.setText("");
		}
	}

	// @FXML
	// void CheckBooking(ActionEvent event) throws IOException,
	// NumberFormatException, SQLException {
	// //Selection = 1;
	// //a.showTimetable(empID.getText());
	// a.showCusBookM();
	// }

	// When user click make new booking button, go to make new book menu
	@FXML
	void MakeBooking(ActionEvent event) throws IOException, NumberFormatException, SQLException {
		Selection = 0;
		// a.showTimetable(empID.getText());
		a.cusShowNewBooking();
		// a.cusShowTimetable(CustomerBookingMenuController.tempEmpId);
	}

	public static String tempEmpId;

	// When user click back button, go to pervious menu
	@FXML
	void Back(ActionEvent event) throws IOException {
		a.showCusM();
	}

}