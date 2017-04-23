package test;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test extends Application {
    private static Connection LoginConn = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static String firstName;
    private static Stage stage;
    public static Scene SCENE_SAMPLE;
    public static Scene SCENE_DEMO;

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        SCENE_SAMPLE = new Scene(FXMLLoader.load(getClass().getResource("../layout/Sample.fxml")));
        SCENE_DEMO = new Scene(FXMLLoader.load(getClass().getResource("../layout/Sample2.fxml")));
        stage.setScene(SCENE_SAMPLE);
        SCENE_SAMPLE.getStylesheets().add("css/application.css");

        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void switchScene(Scene scene) {
        //stage.close();
        stage.setScene(scene);
        scene.getStylesheets().add("css/application.css");
        stage.show();
    }
}