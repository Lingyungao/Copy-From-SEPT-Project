package ViewCustomerTest;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by CatScan on 2016/6/21.
 */
public class LoginViewController implements ControlledStage, Initializable {
    StageController myController;

    public void setStageController(StageController stageController) {
        this.myController = stageController;
    }

    public void initialize(URL location, ResourceBundle resources) {

    }

    public void goToMain(){
        myController.setStage(MainApp.mainViewID);
    }
}