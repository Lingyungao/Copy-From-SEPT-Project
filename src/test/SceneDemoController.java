package test;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class SceneDemoController implements Initializable {
    @FXML
    private Button btBack;
    private Button btCome ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Test.switchScene(Test.SCENE_SAMPLE);
            }
        });
        btCome.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Test.switchScene(Test.SCENE_SAMPLE);
            }
        });
    }
}
