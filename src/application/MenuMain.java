package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

public class MenuMain extends Application {
	private static Stage primaryStage;
	private static Pane mainLayout;
	static int[][] timetable = new int[31][15];
	String[][] btnIdSet = {
			{ "#btn00", "#btn01", "#btn02", "#btn03", "#btn04", "#btn05", "#btn06", "#btn07", "#btn08", "#btn09",
					"#btn010" },
			{ "#btn10", "#btn11", "#btn12", "#btn13", "#btn14", "#btn15", "#btn16", "#btn17", "#btn18", "#btn19",
					"#btn110" },
			{ "#btn20", "#btn21", "#btn22", "#btn23", "#btn24", "#btn25", "#btn26", "#btn27", "#btn28", "#btn29",
					"#btn210" },
			{ "#btn30", "#btn31", "#btn32", "#btn33", "#btn34", "#btn35", "#btn36", "#btn37", "#btn38", "#btn39",
					"#btn310" },
			{ "#btn40", "#btn41", "#btn42", "#btn43", "#btn44", "#btn45", "#btn46", "#btn47", "#btn48", "#btn49",
					"#btn410" },
			{ "#btn50", "#btn51", "#btn52", "#btn53", "#btn54", "#btn55", "#btn56", "#btn57", "#btn58", "#btn59",
					"#btn510" },
			{ "#btn60", "#btn61", "#btn62", "#btn63", "#btn64", "#btn65", "#btn66", "#btn67", "#btn68", "#btn69",
					"#btn610" } };
	static int userId = 0;
	static int premission = 0;
	static String userName = "";
	
	
	
	
	public void showSuperUserBusinessView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/SuperUserBusinessView.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		scene.getStylesheets().add("/application/application.css");
		System.out.println(scene.getStylesheets());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public void showSuperUserBusinessAdd() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/SuperUserBusinessAdd.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		scene.getStylesheets().add("/application/application.css");
		System.out.println(scene.getStylesheets());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public void showViewService() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/OwnerServiceView.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		scene.getStylesheets().add("/application/application.css");
		System.out.println(scene.getStylesheets());
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void showDeleteService(int serviceId) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/DeleteService.fxml"));
		Pane newBooking = loader.load();
		Stage newBookingEdit = new Stage();
		newBookingEdit.setTitle("User select");
		newBookingEdit.initModality(Modality.WINDOW_MODAL);
		newBookingEdit.initOwner(primaryStage);

		Scene scene = new Scene(newBooking);

		newBookingEdit.setScene(scene);
		newBookingEdit.show();
	}
	public void showCusEditM(JFXButton temp) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/CustomerDetailEdit.fxml"));
		Pane editCusDetailPane = loader.load();
		Stage editCusDetailStage = new Stage();
		editCusDetailStage.setTitle("Register");
		editCusDetailStage.initModality(Modality.WINDOW_MODAL);
		Stage stage = (Stage) temp.getScene().getWindow();
		editCusDetailStage.initOwner(stage);
		Scene scene = new Scene(editCusDetailPane);
		scene.getStylesheets().add("/application/application.css");

		editCusDetailStage.setScene(scene);
		editCusDetailStage.show();

	}

	public void cusShowNewBooking() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/CustomerMakeBooking.fxml"));
		Pane newBooking = loader.load();
		Stage newBookingEdit = new Stage();
		newBookingEdit.setTitle("User select");
		newBookingEdit.initModality(Modality.WINDOW_MODAL);
		newBookingEdit.initOwner(primaryStage);
		Scene scene = new Scene(newBooking);
		scene.getStylesheets().add("/application/application.css");

		newBookingEdit.setScene(scene);
		newBookingEdit.show();
	}

	public void viewCusBookM() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/CustomerViewBookingMenu.fxml"));
		Pane CusViewBookMenu = loader.load();
		Scene scene = new Scene(CusViewBookMenu);
		scene.getStylesheets().add("/application/application.css");

		primaryStage.setScene(scene);
		CustomerViewBookingMenuController controller = loader.getController();
		CustomerCheckGetBooking CusGetBooking = new CustomerCheckGetBooking();
		controller.setGetCusBooking(CusGetBooking);
		primaryStage.setTitle("Customer Booking Menu");

	}

	public void showCusDetailM() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/CustomerDetailMenu.fxml"));
		Pane showCusDetailPane = loader.load();
		Stage showCusDetailStage = new Stage();
		showCusDetailStage.setTitle("Edit Detail");
		showCusDetailStage.initModality(Modality.WINDOW_MODAL);
		showCusDetailStage.initOwner(primaryStage);
		Scene scene = new Scene(showCusDetailPane);
		scene.getStylesheets().add("/application/application.css");

		showCusDetailStage.setScene(scene);
		showCusDetailStage.show();

	}

	public void showCusBookM() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/CustomerBookingMenu.fxml"));
		Pane EmpMenu = loader.load();
		Scene scene = new Scene(EmpMenu);
		scene.getStylesheets().add("/application/application.css");

		primaryStage.setScene(scene);
		CustomerBookingMenuController controller = loader.getController();
		CustomerBookGetEmployer getEmployer = new CustomerBookGetEmployer();
		controller.setGetEmployer(getEmployer);
		primaryStage.setTitle("Customer Booking Menu");

	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("System");
		showMainview();

		// Parent root =
		// FXMLLoader.load(getClass().getResource("/application/Menu.fxml"));
		// Scene scene = new Scene(root);
		// primaryStage.setScene(scene);
		// primaryStage.setTitle("System");
		// primaryStage.show();

	}

	public void showViewBooking() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/OwnerAllview.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		scene.getStylesheets().add("/application/application.css");
		System.out.println(scene.getStylesheets());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void showOldBooking() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/OwnerOldview.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		scene.getStylesheets().add("/application/application.css");
		System.out.println(scene.getStylesheets());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void showMainview() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("/application/Menu.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout);
		scene.getStylesheets().add("/application/application.css");

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void showLogin() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/Login.fxml"));
		AnchorPane loginmenu = loader.load();
		Scene scene = new Scene(loginmenu);
		scene.getStylesheets().add("/application/application.css");

		primaryStage.setScene(scene);
		primaryStage.setTitle("Login");
	}

	public void showRegister() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/Register.fxml"));
		Pane Registermenu = loader.load();
		Stage RegisterStage = new Stage();
		RegisterStage.setTitle("Register");
		RegisterStage.initModality(Modality.WINDOW_MODAL);
		RegisterStage.initOwner(primaryStage);
		Scene scene = new Scene(Registermenu);
		scene.getStylesheets().add("/application/application.css");
		RegisterStage.setScene(scene);
		RegisterStage.show();
	}

	public void showOwnerM() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/OwnerMenu.fxml"));
		Pane Ownermenu = loader.load();
		Scene scene = new Scene(Ownermenu);
		scene.getStylesheets().add("/application/application.css");
		Label temp = (Label) scene.lookup("#UID");
		temp.setText(String.valueOf(userId));
		temp = (Label) scene.lookup("#NameL");
		temp.setText(userName);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Owner Menu");
	}

	public void showCusM() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/CustomerMenu.fxml"));
		Pane Customermenu = loader.load();
		Scene scene = new Scene(Customermenu);
		primaryStage.setScene(scene);
		scene.getStylesheets().add("/application/application.css");

		primaryStage.setTitle("Customer Menu");
	}

	public void showAddEmp() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/addEmployee.fxml"));
		Pane addEmployee = loader.load();
		Scene scene = new Scene(addEmployee);
		primaryStage.setScene(scene);
		scene.getStylesheets().add("/application/application.css");

		primaryStage.setTitle("Add Employee");
	}

	public void showEmpMenu() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/EmployeeMenu.fxml"));
		Pane EmpMenu = loader.load();
		Scene scene = new Scene(EmpMenu);
		scene.getStylesheets().add("/application/application.css");

		primaryStage.setScene(scene);
		EmployeeMenuController controller = loader.getController();
		GetEmployer getEmployer = new GetEmployer();
		controller.setGetEmployer(getEmployer);
		primaryStage.setTitle("Employee Menu");
	}

	public void showAddEmpConfirm() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/AddEmployeeConfirm.fxml"));
		Pane AddEmpConfirm = loader.load();
		Scene scene = new Scene(AddEmpConfirm);
		scene.getStylesheets().add("/application/application.css");

		primaryStage.setScene(scene);
		primaryStage.setTitle("Confirm");
	}

	public void showTimetable(String empid,String CusId,JFXButton NWB,String Service,String mode) throws IOException, NumberFormatException, SQLException {
		setTimetable(Integer.valueOf(empid));
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/Timetable.fxml"));
		Pane Timetable = loader.load();
		Stage TimetableEdit = new Stage();
		TimetableEdit.setTitle("Timetable");
		TimetableEdit.initModality(Modality.WINDOW_MODAL);
		TimetableEdit.initOwner(primaryStage);
		Scene scene = new Scene(Timetable);
		Label temp = (Label) scene.lookup("#IdLabel");
		temp.setText(empid);
		
		if(mode.equals("MB"))
		{
			temp = (Label) scene.lookup("#SeviceLabel");
			temp.setText(Service);
			temp.setVisible(true);
			
			temp = (Label) scene.lookup("#ModeLabel");
			temp.setText("Making booking");
			
			temp = (Label) scene.lookup("#CusIdLabel");
			temp.setText(CusId);
			
			Stage stage = (Stage) NWB.getScene().getWindow();
			stage.close();
		}
		
		else
		{   
			temp = (Label) scene.lookup("#ModeLabel");
			temp.setText("Adding time");
		}
		
		for (int i = 0; i <= 6; i++) {
			for (int j = 0; j <= 10; j++) {
				if (timetable[i][j + 1] == 1) {
					JFXButton Btemp = (JFXButton) scene.lookup(btnIdSet[i][j]);
					Btemp.setText("Avalible");
					Btemp.setStyle("-fx-background-color:lightgreen");
				} else if (timetable[i][j + 1] == 0) {
					JFXButton Btemp = (JFXButton) scene.lookup(btnIdSet[i][j]);
					Btemp.setText("Unavalible");
					Btemp.setStyle("-fx-background-color:red");
				} else if (timetable[i][j + 1] == 2) {
					JFXButton Btemp = (JFXButton) scene.lookup(btnIdSet[i][j]);
					Btemp.setText("Booked");
					Btemp.setStyle("-fx-background-color:yellow");
				}
			}
		}

		TimetableEdit.setScene(scene);
		TimetableEdit.show();

		// scene.getStylesheets().add("/application/Timetable.css");
	}

	public void setTimetable(int empId) throws SQLException {

		ResultSet rs = null;
		Connection LoginConn = null;
		Statement st = null;

		int i = 0;
		LoginConn = connection.connectDB(); // connect to the SQL
		st = LoginConn.createStatement(); // create statement of it

		rs = st.executeQuery("SELECT * FROM TIMETABLE WHERE EMP_UID = " + empId);

		while (rs.next()) {

			int x = 0;
			timetable[i][x] = rs.getInt("WEEKDAYS");
			x = x + 1;
			timetable[i][x] = rs.getInt("T0800");
			x++;
			timetable[i][x] = rs.getInt("T0900");
			x++;
			timetable[i][x] = rs.getInt("T1000");
			x++;
			timetable[i][x] = rs.getInt("T1100");
			x++;
			timetable[i][x] = rs.getInt("T1200");
			x++;
			timetable[i][x] = rs.getInt("T1300");
			x++;
			timetable[i][x] = rs.getInt("T1400");
			x++;
			timetable[i][x] = rs.getInt("T1500");
			x++;
			timetable[i][x] = rs.getInt("T1600");
			x++;
			timetable[i][x] = rs.getInt("T1700");
			x++;
			timetable[i][x] = rs.getInt("T1800");
			i = i + 1;
		}
	}

	public void showNewBooking() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/NewBooking.fxml"));
		Pane newBooking = loader.load();
		Stage newBookingEdit = new Stage();
		newBookingEdit.setTitle("User select");
		newBookingEdit.initModality(Modality.WINDOW_MODAL);
		newBookingEdit.initOwner(primaryStage);

		Scene scene = new Scene(newBooking);

		newBookingEdit.setScene(scene);
		newBookingEdit.show();
	}
	public void showNewService() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/NewService.fxml"));
		Pane newService = loader.load();
		Stage newServiceEdit = new Stage();
		newServiceEdit.setTitle("Add New Service");
		newServiceEdit.initModality(Modality.WINDOW_MODAL);
		newServiceEdit.initOwner(primaryStage);
		Scene scene = new Scene(newService);
		newServiceEdit.setScene(scene);
		newServiceEdit.show();
	}


	public void showCon(JFXButton temp) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/SaveConfirmation.fxml"));
		Pane Confirmation = loader.load();
		Stage stage = (Stage) temp.getScene().getWindow();
		Scene scene = new Scene(Confirmation);
		scene.getStylesheets().add("/application/application.css");

		stage.setScene(scene);
	}

	public void showWarming(JFXButton SourceB) throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/Warming.fxml"));
		AnchorPane Warming = loader.load();
		Stage WarmingStage = new Stage();
		WarmingStage.setTitle("Warming!!");
		WarmingStage.initModality(Modality.WINDOW_MODAL);
		Stage stage = (Stage) SourceB.getScene().getWindow();
		WarmingStage.initOwner(stage);
		Scene scene = new Scene(Warming);
		scene.getStylesheets().add("/application/application.css");
		WarmingStage.setScene(scene);
		WarmingStage.show();
	}
	


	public static void main(String[] args) {
		launch(args);
	}

}
