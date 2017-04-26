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


//empty control form board
//work with emptyScene.fxml
public class EmployeeMenuController implements Initializable {
	MenuMain a = new MenuMain();

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
	static int Selection;
    private GetEmployer getEmployer;

    @FXML
    private Label firstName;

    @FXML
    private Label lastName;

    @FXML
    public Label empID;


    @FXML
    private Label empPhone;

    @FXML
    private JFXButton editDetail;

    @FXML
    private JFXButton editTimetable;
    
    @FXML
    private JFXButton makeBook;
    
    @FXML
    private TableView<Employer> employeeTable;
    
    @FXML
    private TableColumn<Employer, Integer> empIdCol;

    @FXML
    private TableColumn<Employer, String> firstNameCol;

    @FXML
    private TableColumn<Employer, String> lastNameCol;
    

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		SWITCH_CUSTOMERVIEWALL.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					a.showAllBooking();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		SWITCH_CUSTOMEROLDVIEW.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					a.showOldBooking();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		ADDEMPLOYEESwitch.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					a.showAddEmp();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		EMPEDITSwitch.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					a.showEmpMenu();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		EMPTIMETABLESwitch.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					a.showEmpMenu();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}
	

    
    
    @FXML
    private void initialize(){
    	firstNameCol.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    	lastNameCol.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    	empIdCol.setCellValueFactory(cellData -> cellData.getValue().empIdProperty().asObject());
    	
//    	showEmpDetails(null);
    	
    	employeeTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showEmpDetails(newValue));
    }
    
    
    
    public void setGetEmployer(GetEmployer getEmployer){
    	this.getEmployer = getEmployer;
        employeeTable.setItems(getEmployer.getEmployerData());

    }
    private void showEmpDetails(Employer Emp) {
    	
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
    
    

    @FXML
    void editTimetable(ActionEvent event) throws IOException, NumberFormatException, SQLException {
    	Selection = 1;
    	a.showTimetable(empID.getText());
    }
    
    
    @FXML
    void MakeBook(ActionEvent event) throws IOException, NumberFormatException, SQLException{
    	Selection = 0;
    	//a.showTimetable(empID.getText());
    	a.showNewBooking();
    }
	public static String tempEmpId;

    @FXML
    void editDetail(ActionEvent event) {

    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}