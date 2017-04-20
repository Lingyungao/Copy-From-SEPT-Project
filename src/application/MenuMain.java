package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class MenuMain extends Application {
    private static Stage primaryStage;
    private static Pane mainLayout;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("System");
            showMainview();
            
//			Parent root = FXMLLoader.load(getClass().getResource("/application/Menu.fxml"));
//			Scene scene = new Scene(root);
//			primaryStage.setScene(scene);
//			primaryStage.setTitle("System");
//			primaryStage.show();
            
	}
	
	
	public void showMainview() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/Menu.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	
	public void showLogin() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/Login.fxml"));
		AnchorPane loginmenu = loader.load();
		Scene scene = new Scene(loginmenu);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Login");
	}
	
	public void showRegister() throws IOException
	{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/Register.fxml"));
		Pane Registermenu= loader.load();
		Stage RegisterStage = new Stage();
		RegisterStage.setTitle("Register");
		RegisterStage.initModality(Modality.WINDOW_MODAL);
		RegisterStage.initOwner(primaryStage);
		Scene scene = new Scene(Registermenu);
		RegisterStage.setScene(scene);
		RegisterStage.show();
	}
	
	public void showOwnerM() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/OwnerMenu.fxml"));
		Pane Ownermenu = loader.load();
		Scene scene = new Scene(Ownermenu);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Owner Menu");
	}
	
	public void showCusM() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/CustomerMenu.fxml"));
		Pane Customermenu = loader.load();
		Scene scene = new Scene(Customermenu);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Customer Menu");
	}
	public void showTimetable() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/Timetable.fxml"));
		Pane Timetable = loader.load();
		Scene scene = new Scene(Timetable);
		scene.getStylesheets().add("/application/Timetable.css");
		primaryStage.setScene(scene);
		primaryStage.setTitle("Timetable");
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
