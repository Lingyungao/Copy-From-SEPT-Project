package ViewCustomerTest;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {
    public static String mainViewID = "MainView";
    public static String mainViewRes = "Sample.fxml";

    public static String loginViewID = "LoginView";
    public static String loginViewRes = "Sample.fxml";

    private StageController stageController;



    @Override
    public void start(Stage primaryStage) {
        //�½�һ��StageController������
        stageController = new StageController();

        //������̨��������������
        stageController.setPrimaryStage("primaryStage", primaryStage);

        //����������̨��ÿ������һ����̨
        stageController.loadStage(loginViewID, loginViewRes, StageStyle.UNDECORATED);
        stageController.loadStage(mainViewID, mainViewRes);

        //��ʾMainView��̨
        stageController.setStage(mainViewID);
    }


    public static void main(String[] args) {
        launch(args);
    }
}