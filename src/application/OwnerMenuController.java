package application;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class OwnerMenuController{
	
	MenuMain a = new MenuMain();
	
    @FXML
    private JFXButton oldBooking;

    @FXML
    private JFXButton editEmployee;

    @FXML
    private JFXButton ViewTimetable;

    @FXML
    private JFXButton newBooking;

    @FXML
    private JFXButton viewEmployee;

    @FXML
    private JFXButton editTimetable;

    @FXML
    private JFXButton viewBooking;

    @FXML
    private JFXButton addEmployee;

    @FXML
    void addEmployee(ActionEvent event) throws IOException {
    	a.showAddEmp();
    }

    @FXML
    void editEmployee(ActionEvent event) {

    }

    @FXML
    void newBooking(ActionEvent event) {

    }

    @FXML
    void editTimetable(ActionEvent event) {

    }

    @FXML
    void ViewTimetable(ActionEvent event) {

    }

    @FXML
    void viewEmployee(ActionEvent event) {

    }

    @FXML
    void viewBooking(ActionEvent event) {

    }

    @FXML
    void oldBooking(ActionEvent event) {

    }

}
