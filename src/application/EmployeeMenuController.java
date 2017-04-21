package application;
import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

public class EmployeeMenuController {

    @FXML
    private Label firstName;

    @FXML
    private Label lastName;

    @FXML
    private Label empID;

    @FXML
    private TableColumn<?, ?> empIdCol;

    @FXML
    private Label empPhone;

    @FXML
    private JFXButton editDetail;

    @FXML
    private JFXButton editTimetable;

    @FXML
    private TableColumn<?, ?> firstNameCol;

    @FXML
    private TableColumn<?, ?> lastNameCol;

    @FXML
    void editTimetable(ActionEvent event) {

    }

    @FXML
    void editDetail(ActionEvent event) {

    }

}
