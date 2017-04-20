package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;

public class TimetableController {
	
	private Connection LoginConn = null;
	private ResultSet rs = null;
	private ResultSet rs2 = null;
	private ResultSet rs3 = null;
	private Statement st = null;

	int[][] timetable = new int[31][15];
	int[][] daystable = new int[100][13];

	String weekdaysName;
	int dateCount;
	String first;
	String last;
	
	public void weekdaysDef(int weekdays) {  //Change 1~7 to Mon~Sun

		switch (weekdays) {
		case 1: {
			weekdaysName = "Mon";
			break;
		}
		case 2: {
			weekdaysName = "Tue";
			break;
		}
		case 3: {
			weekdaysName = "Wed";
			break;
		}
		case 4: {
			weekdaysName = "Thu";
			break;
		}
		case 5: {
			weekdaysName = "Fri";
			break;
		}
		case 6: {
			weekdaysName = "Sat";
			break;
		}
		case 7: {
			weekdaysName = "Sun";
			break;
		}

		}

	}

//	public void setArray(int empId) throws SQLException {  //Load the information from the database and store in the matrix
//		int i = 0;
//		LoginConn = connection.connectDB();                              // connect to the SQL
//		st = LoginConn.createStatement();                                // create statement of it
//		
//		rs = st.executeQuery("SELECT * FROM TIMETABLE WHERE EMP_UID = " + empId);
//
//		while (rs.next()) {
//
//			int x = 0;
//			timetable[i][x] = rs.getInt("Day");
//			x = x + 1;
//			timetable[i][x] = rs.getInt("Month");
//			x++;
//			timetable[i][x] = rs.getInt("Year");
//			x++;
//			timetable[i][x] = rs.getInt("T0800");
//			x++;
//			timetable[i][x] = rs.getInt("T0900");
//			x++;
//			timetable[i][x] = rs.getInt("T1000");
//			x++;
//			timetable[i][x] = rs.getInt("T1100");
//			x++;
//			timetable[i][x] = rs.getInt("T1200");
//			x++;
//			timetable[i][x] = rs.getInt("T1300");
//			x++;
//			timetable[i][x] = rs.getInt("T1400");
//			x++;
//			timetable[i][x] = rs.getInt("T1500");
//			x++;
//			timetable[i][x] = rs.getInt("T1600");
//			x++;
//			timetable[i][x] = rs.getInt("T1700");
//			x++;
//			timetable[i][x] = rs.getInt("T1800");
//			i = i+1;
//			dateCount = i;
//		}
//		rs2 = st.executeQuery("SELECT * FROM EMPLOYEE WHERE EMP_UID = " + empId);
//		first = rs2.getString("EMP_FIRST");
//		last = rs2.getString("EMP_LAST");
//	}
	
	public void setArray()
	{
		timetable[0][0] = 1;
	}
	
	

    @FXML
    private JFXButton btn00;

    @FXML
    private void edit(ActionEvent event)  throws IOException{
    	if(timetable[0][0]==1)
    	{
    		timetable[0][0] = 0;
    		btn00.setText("Unavalible");
    		btn00.getStyleClass().add("Un");
    	}
    	else if(timetable[0][0]==0)
    	{
    		timetable[0][0] = 1;
    		btn00.setText("Avalible");
    		btn00.getStyleClass().add("Av");
    	}
    }

}
