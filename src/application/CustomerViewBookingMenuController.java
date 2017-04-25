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

public class CustomerViewBookingMenuController {
	static int Selection;
    private CusGetBooking CusGetCusBooking;
    MenuMain a = new MenuMain();
    
    @FXML
    private TableView<CusBooking> cusViewBookTable;
    @FXML
    private TableColumn<CusBooking, Integer> bookIdCol;
    @FXML
    private TableColumn<CusBooking, String> empNameCol;
    @FXML
    private TableColumn<CusBooking, String> bookingTimeCol;
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
    private void initialize(){
    	bookIdCol.setCellValueFactory(cellData -> cellData.getValue().bookIdProperty().asObject());
    	empNameCol.setCellValueFactory(cellData -> cellData.getValue().empNameProperty());
    	bookingTimeCol.setCellValueFactory(cellData -> cellData.getValue().startTimeProperty());
    	
//    	showEmpDetails(null);
    	
    	cusViewBookTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showCusBookDetails(newValue));
    }
    
    public void setGetCusBooking(CusGetBooking CusGetBooking){
    	this.CusGetCusBooking = CusGetBooking;
    	cusViewBookTable.setItems(CusGetBooking.getCusBookingData());

    }
    
private void showCusBookDetails(CusBooking CusBook) {
    	
        if (CusBook != null) {
            // Fill the labels with info from the person object.
        	bookId.setText(Integer.toString(CusBook.getBookId()));
        	empId.setText(Integer.toString(CusBook.getEmpId()));
        	empName.setText(CusBook.getEmpName());
        	bookDate.setText(CusBook.getBookDate());
        	startTime.setText(CusBook.getStartTime());
        	endTime.setText(CusBook.getEndTime());
        	
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
    
}