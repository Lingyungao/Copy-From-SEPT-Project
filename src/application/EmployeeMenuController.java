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
    }
    
    
    public void setMainApp(GetEmployer getEmployer){
    	this.getEmployer = getEmployer;
        employeeTable.setItems(getEmployer.getEmployerData());

    }
    
    

    @FXML
    void editTimetable(ActionEvent event) {
    	
    }

    @FXML
    void editDetail(ActionEvent event) {

    }

}
