package application;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BookedController {
	

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label ServiceLabel;

    @FXML
    private Label ElastNameLabel;

    @FXML
    private Label EndTime;

    @FXML
    private Label cusEmailLabel;

    @FXML
    private Label StartTime;

    @FXML
    private Label cusPhoneLabel;

    @FXML
    private Label EfirstNameLabel;

    @FXML
    private Label cusAddressLabel;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label day;

    @FXML
    private JFXButton Exit;
    
    @FXML
    void Back(ActionEvent event) throws IOException {
    	Stage stage = (Stage) Exit.getScene().getWindow();
    	stage.close();
	}

}
