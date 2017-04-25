package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
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
	
	public void showCusDetailM() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/CustomerDetailMenu.fxml"));
		Pane showCusDetailPane= loader.load();
		Stage showCusDetailStage = new Stage();
		showCusDetailStage.setTitle("Edit Detail");
		showCusDetailStage.initModality(Modality.WINDOW_MODAL);
		showCusDetailStage.initOwner(primaryStage);
		Scene scene = new Scene(showCusDetailPane);
		showCusDetailStage.setScene(scene);
		showCusDetailStage.show();


	}
	
	public void showCusEditM() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/CustomerDetailEdit.fxml"));
		Pane editCusDetailPane= loader.load();
		Stage editCusDetailStage = new Stage();
		editCusDetailStage.setTitle("Register");
		editCusDetailStage.initModality(Modality.WINDOW_MODAL);
		editCusDetailStage.initOwner(primaryStage);
		Scene scene = new Scene(editCusDetailPane);
		editCusDetailStage.setScene(scene);
		editCusDetailStage.show();
		
	}
	
	public void showCusBookM() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/CustomerBookingMenu.fxml"));
		Pane EmpMenu = loader.load();
		Scene scene = new Scene(EmpMenu);
		primaryStage.setScene(scene);
		CustomerBookingMenuController controller = loader.getController();
		CustomerBookGetEmployer getEmployer = new CustomerBookGetEmployer();
        controller.setGetEmployer(getEmployer);
		primaryStage.setTitle("Customer Booking Menu");
		
	}
	
	public void viewCusBookM() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/CustomerViewBookingMenu.fxml"));
		Pane CusViewBookMenu = loader.load();
		Scene scene = new Scene(CusViewBookMenu);
		primaryStage.setScene(scene);
		CustomerViewBookingMenuController controller = loader.getController();
		CustomerCheckGetBooking CusGetBooking = new CustomerCheckGetBooking();
        controller.setGetCusBooking(CusGetBooking);
		primaryStage.setTitle("Customer Booking Menu");
		
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
