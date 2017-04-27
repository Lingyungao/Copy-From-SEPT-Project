package application;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

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

public class addEmpolyeeController implements Initializable {
	MenuMain a = new MenuMain();

	private static String regLetOnly = "^[a-zA-Z]+$";
	private static String regNumOnly = "^[0-9]+$";
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
    private JFXTextField empFirst;
    @FXML
    private Label lastCheck;
    @FXML
    private Label firstCheck;
    @FXML
    private Label phoneCheck;
    @FXML
    private JFXTextField empPhone;
    @FXML
    private Button addEmployeeNext;
    @FXML
    private JFXTextField empLast;


    @FXML
    void empFirst(ActionEvent event) {   	
    }
    @FXML
    void empLast(ActionEvent event) {
    }
    @FXML
    void empPhone(ActionEvent event) {
    }
    @FXML
    void addEmployeeNext(ActionEvent event) throws Exception {
    	System.out.println("clicked");
    	boolean empFirstPass = false;
    	boolean empLastPass = false;
    	boolean empPhonePass = false;
    	//first name check
    	if(empFirst.getText().length() < 2){
    		firstCheck.setText("First name too short. Must longer than 2 letters");
    		empFirstPass = false;
    	}    	
    	else if(empFirst.getText().length() > 20){
    		firstCheck.setText("First name too long. Must shorter than 20 letters");
    		empFirstPass = false;
    	}   	
    	else if (empFirst.getText().matches(regLetOnly) == false) {
    		firstCheck.setText("First name only allowed input characters.");
    		empFirstPass = false;
    	}
    	else{
    		firstCheck.setText("¡Ì");
        	empFirstPass = true;
    	}
    	//last name check
    	if(empLast.getText().length() < 2){
    		lastCheck.setText("Last name too short. Must longer than 2 letters");
    		empLastPass = false;
    	}    	
    	else if(empLast.getText().length() > 20){
    		lastCheck.setText("Last name too long. Must shorter than 20 letters");
    		empLastPass = false;
    	}   	
    	else if (empLast.getText().matches(regLetOnly) == false) {
    		lastCheck.setText("Last name only allowed input characters.");
    		empLastPass = false;
    	}
    	else{
    		lastCheck.setText("¡Ì");
    		empLastPass = true;
    	}
    	
    	//phone check
    	
    	if(empPhone.getText().length() < 5){
    		phoneCheck.setText("Phone number too short. Must longer than 5 letters");
    		empPhonePass = false;
    	}
    	
    	else if(empPhone.getText().length() > 15){
    		phoneCheck.setText("Phone number too long. Must shorter than 15 letters");
    		empPhonePass = false;
    	}
    	
    	else if (empPhone.getText().matches(regNumOnly) == false) {
    		phoneCheck.setText("Phone number only allowed input numbers.");
    		empPhonePass = false;
    	}
    	else{
    		phoneCheck.setText("¡Ì");
    		
    		empPhonePass = true;
    	}
    	
    	if(empFirstPass == true && empLastPass == true && empPhonePass == true ){
    		System.out.println("PASSED");
    		AddEmployeeSQL.insertEmployee(empFirst.getText(),empLast.getText(),empPhone.getText());
    		a.showAddEmpConfirm();
    	}else{
    		System.out.println("error AE001");
    	}
    	
    }
    

    @FXML
    void Back(ActionEvent event) throws IOException {
   // 	a.showOwnerM();
    }


    
    
    //all right button here
    //PS:copy to all page,do not fucking change
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
}