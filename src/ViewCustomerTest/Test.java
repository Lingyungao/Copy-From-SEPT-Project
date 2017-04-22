package ViewCustomerTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.InputStream;  
import java.util.logging.Level;  
import java.util.logging.Logger;  
import javafx.fxml.JavaFXBuilderFactory;  
import javafx.scene.layout.AnchorPane;  


public class Test extends Application {
private static Connection LoginConn = null;
private static Statement st = null;
private static ResultSet rs = null;
private static String firstName;
private Stage stage;  
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;  
        Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add("test/application.css");

        stage.show();
    }


    public void letsgoPB(){  
        try {  
              replaceSceneContent("Sample.fxml");  
          } catch (Exception ex) {  
              Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);  
          }  
      }  
    
    private void replaceSceneContent(String fxml) throws Exception {  
        Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        scene.getStylesheets().add("test/application.css");

        stage.show(); 
    }  
    
    
    public static void main(String[] args) {
        launch(args);
    }
}



/*
int bookingID;
int cusID;
String cusName;
int empID;
String empName;
int dayID;
int monthID;
int yearID;
int startTime;
int endTime;
int active;

try {
	LoginConn = connection.connectDB(); // connect to the SQL
	st = LoginConn.createStatement(); // create statement of it
	rs = st.executeQuery(
			"select * from (booking INNER JOIN Details On booking.user_id = details.user_id) INNER JOIN employee ON booking.emp_id = employee.emp_uid WHERE booking.month < 4");
	while (rs.next()) {
		bookingID = rs.getInt("BOOK_ID");
		cusID = rs.getInt("USER_ID");
		empID = rs.getInt("EMP_ID");
		cusName = rs.getString("FIRST_NAME");
		empName = rs.getString("EMP_FIRST");
		dayID = rs.getInt("DAY");
		monthID = rs.getInt("Month");
		yearID = rs.getInt("Year");
		startTime = rs.getInt("START_TIME");
//		endTime = rs.getInt("END_TIME");
		active = rs.getInt("ACTIVE");

		endTime = startTime + 1;
		if (active == 1) {
			System.out.println("-------------------------------------");
			System.out.println("Booking ID:       " + bookingID);
			System.out.println("Customer name:    " + cusName);
			System.out.println("Customer ID:      " + cusID);
			System.out.println("Employee name     " + empName);
			System.out.println("Employee ID:      " + empID);
			System.out.println("Booking day:      " + dayID + "/" + monthID + "/" + yearID);
			System.out.println("Starting time:    " + startTime + " o'clock");
			System.out.println("Ending time:      " + endTime + " o'clock");

		}
	}
} catch (Exception exc) {
	exc.printStackTrace();
}*/