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
            {"#btn00","#btn01","#btn02","#btn03","#btn04","#btn05","#btn06","#btn07","#btn08","#btn09","#btn010"},
            {"#btn10","#btn11","#btn12","#btn13","#btn14","#btn15","#btn16","#btn17","#btn18","#btn19","#btn110"},
            {"#btn20","#btn21","#btn22","#btn23","#btn24","#btn25","#btn26","#btn27","#btn28","#btn29","#btn210"},
            {"#btn30","#btn31","#btn32","#btn33","#btn34","#btn35","#btn36","#btn37","#btn38","#btn39","#btn310"},
            {"#btn40","#btn41","#btn42","#btn43","#btn44","#btn45","#btn46","#btn47","#btn48","#btn49","#btn410"},
            {"#btn50","#btn51","#btn52","#btn53","#btn54","#btn55","#btn56","#btn57","#btn58","#btn59","#btn510"},
            {"#btn60","#btn61","#btn62","#btn63","#btn64","#btn65","#btn66","#btn67","#btn68","#btn69","#btn610"}
           };
	static int userId;
    
	
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
		Label temp = (Label) scene.lookup("#UID");
		temp.setText(String.valueOf(userId));
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
	
	public void showAddEmp() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/addEmployee.fxml"));
		Pane addEmployee = loader.load();
		Scene scene = new Scene(addEmployee);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Add Employee");
	}
	
	public void showEmpMenu() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/EmployeeMenu.fxml"));
		Pane EmpMenu = loader.load();
		Scene scene = new Scene(EmpMenu);
		primaryStage.setScene(scene);
		EmployeeMenuController controller = loader.getController();
		GetEmployer getEmployer = new GetEmployer();
        controller.setGetEmployer(getEmployer);
		primaryStage.setTitle("Employee Menu");
	}
	
	public void showAddEmpConfirm() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MenuMain.class.getResource("/application/AddEmployeeConfirm.fxml"));
		Pane AddEmpConfirm = loader.load();
		Scene scene = new Scene(AddEmpConfirm);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Confirm");
	}
	
	
	public void showTimetable(String empid) throws IOException, NumberFormatException, SQLException{
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
		setTimetable(Integer.valueOf(empid));
		Label temp1 = (Label) scene.lookup("#dayB");
		temp1.setText(String.valueOf(timetable[0][0]));
		
		Label temp2 = (Label) scene.lookup("#monthB");
		temp2.setText(String.valueOf(timetable[0][1]));
		
		Label temp3 = (Label) scene.lookup("#yearB");
		temp3.setText(String.valueOf(timetable[0][2]));
		
		Label temp4 = (Label) scene.lookup("#dayE");
		temp4.setText(String.valueOf(timetable[6][0]));
		
		Label temp5 = (Label) scene.lookup("#monthE");
		temp5.setText(String.valueOf(timetable[6][1]));
		
		Label temp6 = (Label) scene.lookup("#yearE");
		temp6.setText(String.valueOf(timetable[6][2]));	
		
		for(int i = 0;i<=6;i++)
		{
			for(int j = 0;j<=10;j++)
			{
				if(timetable[i][j+3]==1)
				{
					JFXButton Btemp = (JFXButton) scene.lookup(btnIdSet[i][j]);
					Btemp.setText("Avalible");
					Btemp.setStyle("-fx-background-color:lightgreen");
				}
				else if(timetable[i][j+3]==0)
				{
					JFXButton Btemp = (JFXButton) scene.lookup(btnIdSet[i][j]);
		    		Btemp.setText("Unavalible");
		    		Btemp.setStyle("-fx-background-color:red");
				}
			}
		}
		TimetableEdit.setScene(scene);
		TimetableEdit.show();
		
		
//		scene.getStylesheets().add("/application/Timetable.css");
	}
	
	public void setTimetable(int empId) throws SQLException {
		
		ResultSet rs = null;
		Connection LoginConn = null;
		Statement st = null;
		
		int i = 0;
		LoginConn = connection.connectDB();                              // connect to the SQL
		st = LoginConn.createStatement();                                // create statement of it
		
		rs = st.executeQuery("SELECT * FROM TIMETABLE WHERE EMP_UID = " + empId);

		while (rs.next()) {

			int x = 0;
			timetable[i][x] = rs.getInt("Day");
			x = x + 1;
			timetable[i][x] = rs.getInt("Month");
			x++;
			timetable[i][x] = rs.getInt("Year");
			x++;
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
			i = i+1;
		}
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
