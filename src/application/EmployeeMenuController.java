package application;
import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import application.GetEmployer;
import application.Employer;
public class EmployeeMenuController {
    private GetEmployer getEmployer;

    @FXML
    private Label firstName;

    @FXML
    private Label lastName;

    @FXML
    private Label empID;


    @FXML
    private Label empPhone;

    @FXML
    private JFXButton editDetail;

    @FXML
    private JFXButton editTimetable;
    
    @FXML
    private TableView<Employer> employeeTable;
    
    @FXML
    private TableColumn<Employer, Integer> empIdCol;

    @FXML
    private TableColumn<Employer, String> firstNameCol;

    @FXML
    private TableColumn<Employer, String> lastNameCol;
    
    
    
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
            empID.setText(Integer.toString(Emp.getEmpId()));
        } else {
            // Person is null, remove all the text.
            firstName.setText("");
            lastName.setText("");
           empID.setText("");
        }
    }
    
    

    @FXML
    void editTimetable(ActionEvent event) {
    	
    }

    @FXML
    void editDetail(ActionEvent event) {

    }

}
