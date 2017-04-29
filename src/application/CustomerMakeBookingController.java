package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class CustomerMakeBookingController {
	private String regNumOnly = "^[0-9]+";
	private static Connection LoginConn = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	public static String userIdCheck;
    MenuMain a = new MenuMain();

    @FXML
    private JFXButton goTimetable;

    @FXML
    private JFXTextField userId;

    @FXML
    private Label errorMsg;
    
    @FXML
    private JFXTextField service;
    
    @FXML
    public static String tempService;
    
    @FXML
    void goTimetable(ActionEvent event) throws Exception{
    	userIdCheck = Integer.toString(LoginSystem2.returnId);
    	tempService = service.getText();
    	Boolean passCheck = false;
    	int userIdCheck2 = Integer.parseInt(userIdCheck);
		LoginConn = connection.connectDB();
		st = LoginConn.createStatement();
		
		rs = st.executeQuery("SELECT COUNT(USER_ID) FROM USERS");

		int userCount = rs.getInt("COUNT(USER_ID)");
    	
    	if(userIdCheck.matches(regNumOnly) == false){
    		errorMsg.setText("Customer ID only allowed to input numbers.");
    	}
    	else if(userIdCheck2 > userCount){
    		errorMsg.setText("Customer ID not exsist.");
    	}else if(tempService == ""){
    		 errorMsg.setText("Please enter the service.");
    	}else{
    		tempService = service.getText();
    		try{
    		a.showTimetable(CustomerBookingMenuController.tempEmpId,goTimetable);
    		}
        	catch(NumberFormatException NFE){
        		System.out.println("please select one of the employee");
        		a.showWarming(goTimetable);
    	}	
    }
}
}