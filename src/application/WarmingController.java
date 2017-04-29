package application;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class WarmingController {

    @FXML
    private JFXButton Close;

    @FXML
    void CloseW(ActionEvent event) {
	    Stage stage = (Stage) Close.getScene().getWindow();
	    stage.close();

    }

}

