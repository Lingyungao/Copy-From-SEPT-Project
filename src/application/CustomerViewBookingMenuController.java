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
    private CusGetEmployer getEmployer;
    MenuMain a = new MenuMain();
    
    @FXML
    private TableView<CusEmployer> employeeTable;
    @FXML
    private TableColumn<CusEmployer, Integer> bookIdCol;
    @FXML
    private TableColumn<CusEmployer, String> empNameCol;
    @FXML
    private TableColumn<CusEmployer, String> bookingTimeCol;
    @FXML
    private Label bookID;
    @FXML
    private Label employeeID;
    @FXML
    private Label employeeName;
    @FXML
    private Label bookDate;
    @FXML
    private Label startTime;
    @FXML
    private Label endTime;
    
    
}
