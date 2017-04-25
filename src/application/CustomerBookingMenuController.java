package application;
import java.io.IOException;
import java.sql.SQLException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import application.CusGetEmployer;
import application.CusEmployer;


public class CustomerBookingMenuController {
	static int Selection;
    private CusGetEmployer getEmployer;
    MenuMain a = new MenuMain();

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
    private JFXButton checkTimetable;
    
    @FXML
    private JFXButton makeBook;
    
    @FXML
    private TableView<CusEmployer> employeeTable;
    
    @FXML
    private TableColumn<CusEmployer, Integer> empIdCol;

    @FXML
    private TableColumn<CusEmployer, String> firstNameCol;

    @FXML
    private TableColumn<CusEmployer, String> lastNameCol;
    
    
    
    @FXML
    private void initialize(){
    	firstNameCol.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    	lastNameCol.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    	empIdCol.setCellValueFactory(cellData -> cellData.getValue().empIdProperty().asObject());
    	
//    	showEmpDetails(null);
    	
    	employeeTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showEmpDetails(newValue));
    }
    
    
    
    public void setGetEmployer(CusGetEmployer getEmployer){
    	this.getEmployer = getEmployer;
        employeeTable.setItems(getEmployer.getEmployerData());

    }
    private void showEmpDetails(CusEmployer Emp) {
    	
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
    void CheckTimetable(ActionEvent event) throws IOException, NumberFormatException, SQLException {
    	Selection = 1;
    	//a.showTimetable(empID.getText());
    }
    
    
    @FXML
    void MakeBooking(ActionEvent event) throws IOException, NumberFormatException, SQLException{
    	Selection = 0;
    	//a.showTimetable(empID.getText());
    	//a.showNewBooking();
    }
	public static String tempEmpId;



}