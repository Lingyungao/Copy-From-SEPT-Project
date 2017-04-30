package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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

	private Statement st = null;

	// int[][] timetable = new int[31][15];
	int[][] daystable = new int[100][13];

	String[][] btnIdSet = {
			{ "btn00", "btn01", "btn02", "btn03", "btn04", "btn05", "btn06", "btn07", "btn08", "btn09", "btn010" },
			{ "btn10", "btn11", "btn12", "btn13", "btn14", "btn15", "btn16", "btn17", "btn18", "btn19", "btn110" },
			{ "btn20", "btn21", "btn22", "btn23", "btn24", "btn25", "btn26", "btn27", "btn28", "btn29", "btn210" },
			{ "btn30", "btn31", "btn32", "btn33", "btn34", "btn35", "btn36", "btn37", "btn38", "btn39", "btn310" },
			{ "btn40", "btn41", "btn42", "btn43", "btn44", "btn45", "btn46", "btn47", "btn48", "btn49", "btn410" },
			{ "btn50", "btn51", "btn52", "btn53", "btn54", "btn55", "btn56", "btn57", "btn58", "btn59", "btn510" },
			{ "btn60", "btn61", "btn62", "btn63", "btn64", "btn65", "btn66", "btn67", "btn68", "btn69", "btn610" } };
	String weekdaysName;
	int dateCount;
	String first;
	String last;

	// public JFXButton setColor(JFXButton jfxbutton){
	//
	// for(int i = 0; i <= 6;i++)
	// {
	// for(int j = 0; j <= 10; j++)
	// {
	// if(jfxbutton.getId().equals(btnIdSet[i][j]))
	// {
	// if(timetable[i][j+1]==0)
	// {
	// jfxbutton.setText("Unavalible");
	// jfxbutton.setStyle("-fx-background-color:red");
	//// System.out.println(timetable[i][j+1] + " " + i + " " + j);
	//
	// }
	// else if(timetable[i][j+1]==1)
	// {
	// timetable[i][j+1] = 1;
	// jfxbutton.setText("Avalible");
	// jfxbutton.setStyle("-fx-background-color:lightgreen");
	//// System.out.println(timetable[i][j+1] + " " + i + " " + j);
	// }
	// }
	// }
	// }
	// return jfxbutton;
	// }
	//

	public void weekdaysDef(int weekdays) { // Change 1~7 to Mon~Sun

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

	// public void setArray(int empId) throws SQLException { //Load the
	// information from the database and store in the matrix
	// int i = 0;
	// LoginConn = connection.connectDB(); // connect to the SQL
	// st = LoginConn.createStatement(); // create statement of it
	//
	// rs = st.executeQuery("SELECT * FROM TIMETABLE WHERE EMP_UID = " + empId);
	//
	// while (rs.next()) {
	//
	// int x = 0;
	// timetable[i][x] = rs.getInt("Day");
	// x = x + 1;
	// timetable[i][x] = rs.getInt("Month");
	// x++;
	// timetable[i][x] = rs.getInt("Year");
	// x++;
	// timetable[i][x] = rs.getInt("T0800");
	// x++;
	// timetable[i][x] = rs.getInt("T0900");
	// x++;
	// timetable[i][x] = rs.getInt("T1000");
	// x++;
	// timetable[i][x] = rs.getInt("T1100");
	// x++;
	// timetable[i][x] = rs.getInt("T1200");
	// x++;
	// timetable[i][x] = rs.getInt("T1300");
	// x++;
	// timetable[i][x] = rs.getInt("T1400");
	// x++;
	// timetable[i][x] = rs.getInt("T1500");
	// x++;
	// timetable[i][x] = rs.getInt("T1600");
	// x++;
	// timetable[i][x] = rs.getInt("T1700");
	// x++;
	// timetable[i][x] = rs.getInt("T1800");
	// i = i+1;
	// dateCount = i;
	// }
	// rs2 = st.executeQuery("SELECT * FROM EMPLOYEE WHERE EMP_UID = " + empId);
	// first = rs2.getString("EMP_FIRST");
	// last = rs2.getString("EMP_LAST");
	// }

	@FXML
	private JFXButton btn21;

	@FXML
	private JFXButton btn65;

	@FXML
	private JFXButton btn20;

	@FXML
	private JFXButton btn64;

	@FXML
	private JFXButton btn63;

	@FXML
	private JFXButton btn62;

	@FXML
	private JFXButton btn25;

	@FXML
	private JFXButton btn69;

	@FXML
	private JFXButton btn24;

	@FXML
	private JFXButton btn68;

	@FXML
	private JFXButton btn23;

	@FXML
	private JFXButton btn67;

	@FXML
	private JFXButton btn22;

	@FXML
	private JFXButton btn66;

	@FXML
	private JFXButton btn61;

	@FXML
	private JFXButton btn60;

	@FXML
	private JFXButton btn18;

	@FXML
	private JFXButton btn17;

	@FXML
	private JFXButton btn16;

	@FXML
	private JFXButton btn15;

	@FXML
	private JFXButton btn59;

	@FXML
	private JFXButton btn19;

	@FXML
	private JFXButton btn32;

	@FXML
	private JFXButton btn31;

	@FXML
	private JFXButton btn30;

	@FXML
	private JFXButton btn010;

	@FXML
	private JFXButton btn36;

	@FXML
	private JFXButton btn210;

	@FXML
	private JFXButton btn35;

	@FXML
	private JFXButton btn34;

	@FXML
	private JFXButton btn33;

	@FXML
	private JFXButton btn410;

	@FXML
	private JFXButton btn610;

	@FXML
	private JFXButton btn29;

	@FXML
	private JFXButton btn28;

	@FXML
	private JFXButton btn27;

	@FXML
	private JFXButton btn26;

	@FXML
	private JFXButton btn43;

	@FXML
	private JFXButton btn42;

	@FXML
	private JFXButton btn41;

	@FXML
	private JFXButton btn40;

	@FXML
	private JFXButton btn03;

	@FXML
	private JFXButton btn47;

	@FXML
	private JFXButton btn02;

	@FXML
	private JFXButton btn46;

	@FXML
	private JFXButton btn110;

	@FXML
	private JFXButton btn45;

	@FXML
	private JFXButton btn01;

	@FXML
	private JFXButton btn44;

	@FXML
	private JFXButton btn00;

	@FXML
	private JFXButton btn39;

	@FXML
	private JFXButton btn38;

	@FXML
	private JFXButton btn37;

	@FXML
	private JFXButton btn10;

	@FXML
	private JFXButton btn54;

	@FXML
	private JFXButton btn53;

	@FXML
	private JFXButton btn52;

	@FXML
	private JFXButton btn51;

	@FXML
	private JFXButton btn14;

	@FXML
	private JFXButton btn58;

	@FXML
	private JFXButton btn13;

	@FXML
	private JFXButton btn57;

	@FXML
	private JFXButton btn12;

	@FXML
	private JFXButton btn56;

	@FXML
	private JFXButton btn310;

	@FXML
	private JFXButton btn11;

	@FXML
	private JFXButton btn55;

	@FXML
	private JFXButton btn510;

	@FXML
	private JFXButton btn50;

	@FXML
	private JFXButton btn07;

	@FXML
	private JFXButton btn06;

	@FXML
	private JFXButton btn05;

	@FXML
	private JFXButton btn49;

	@FXML
	private JFXButton btn04;

	@FXML
	private JFXButton btn48;

	@FXML
	private JFXButton btn09;

	@FXML
	private JFXButton btn08;

	@FXML
	private JFXButton save;

	@FXML
	private void edit(ActionEvent event) throws IOException {
		JFXButton x = (JFXButton) event.getSource();
		if (EmployeeMenuController.Selection == 1) {
			for (int i = 0; i <= 6; i++) {
				for (int j = 0; j <= 10; j++) {
					if (x.getId().equals(btnIdSet[i][j])) {
						if (MenuMain.timetable[i][j + 1] == 1) {
							MenuMain.timetable[i][j + 1] = 0;
							x.setText("Unavalible");
							x.setStyle("-fx-background-color:red");
							System.out.println(MenuMain.timetable[i][j + 1] + " " + i + " " + j);

						} else if (MenuMain.timetable[i][j + 1] == 0) {
							MenuMain.timetable[i][j + 1] = 1;
							x.setText("Avalible");
							x.setStyle("-fx-background-color:lightgreen");
							System.out.println(MenuMain.timetable[i][j + 1] + " " + i + " " + j);
						}
					}
				}
			}
		} else if (EmployeeMenuController.Selection == 0) {
			for (int i = 0; i <= 6; i++) {
				for (int j = 0; j <= 10; j++) {
					if (x.getId().equals(btnIdSet[i][j])) {
						if (MenuMain.timetable[i][j + 1] == 1) {
							MenuMain.timetable[i][j + 1] = 3;
							x.setText("new booking");
							x.setStyle("-fx-background-color:yellow");
							System.out.println(MenuMain.timetable[i][j + 1] + " " + i + " " + j);

						} else if (MenuMain.timetable[i][j + 1] == 3) {
							MenuMain.timetable[i][j + 1] = 1;
							x.setText("Avaliable");
							x.setStyle("-fx-background-color:lightgreen");
							System.out.println(MenuMain.timetable[i][j + 1] + " " + i + " " + j);
						}
					}
				}
			}
		}

	}

	@FXML
	void save(ActionEvent event) throws SQLException, IOException {
		MenuMain a = new MenuMain();
		a.showCon(save);

	}
}