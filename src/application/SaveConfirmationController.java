package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class SaveConfirmationController {
	static int SSelection = 0;

	@FXML
	private JFXButton NoSave;

	@FXML
	private JFXButton Save;

	@FXML
    //Click "yes" to save
	void save(ActionEvent event) throws SQLException {
		String temp1 = "";
		String temp2 = "";

		if (SSelection == 1) {
			temp1 = EmployeeMenuController.tempEmpId;
			temp2 = NewBookingController.userIdCheck;
		} else {
			temp1 = CustomerBookingMenuController.tempEmpId;
			temp2 = CustomerMakeBookingController.userIdCheck;
		}

		Connection LoginConn = null;
		Statement st = null;

		LoginConn = connection.connectDB(); // connect to the SQL
		st = LoginConn.createStatement();

		PreparedStatement rs = LoginConn.prepareStatement(
				"UPDATE TIMETABLE SET  T0800=?, T0900=?, T1000=?, T1100=?, T1200=?, T1300=?, T1400=?, T1500=?, T1600=?, T1700=?, T1800=? "
						+ " WHERE WEEKDAYS=?"

						+ " AND EMP_UID=? ");

		for (int i = 0; i < 7; i++) {

			rs.setInt(1, MenuMain.timetable[i][1]);
			rs.setInt(2, MenuMain.timetable[i][2]);
			rs.setInt(3, MenuMain.timetable[i][3]);
			rs.setInt(4, MenuMain.timetable[i][4]);
			rs.setInt(5, MenuMain.timetable[i][5]);
			rs.setInt(6, MenuMain.timetable[i][6]);
			rs.setInt(7, MenuMain.timetable[i][7]);
			rs.setInt(8, MenuMain.timetable[i][8]);
			rs.setInt(9, MenuMain.timetable[i][9]);
			rs.setInt(10, MenuMain.timetable[i][10]);
			rs.setInt(11, MenuMain.timetable[i][11]);

			for (int j = 1; j < 12; j++) {
				if (MenuMain.timetable[i][j] == 3) // to make new booking
				{
					rs.setInt(j, MenuMain.timetable[i][j] - 1);
				}
			}

			rs.setInt(12, MenuMain.timetable[i][0]);
			rs.setString(13, temp1);
			// rs.setInt(16, MenuMain.timetable[i][16]);
			rs.addBatch();
		}
		rs.executeBatch();
		// System.out.println("save done.");

		if (EmployeeMenuController.Selection == 0) {
			// System.out.println("booking save function on");
			ResultSet rs3 = st.executeQuery("SELECT COUNT(BOOK_ID) FROM BOOKING");
			int bookCount = rs3.getInt("COUNT(BOOK_ID)");

			PreparedStatement rs2 = LoginConn.prepareStatement(
					"INSERT INTO BOOKING(BOOK_ID,USER_ID,EMP_ID,DAY,START_TIME,END_TIME,ACTIVE) VALUES(?,?,?,?,?,?,1) ");
			PreparedStatement rs4 = LoginConn.prepareStatement("INSERT INTO SERVICE(BOOK_ID,BOOK_SER) VALUES(?,?) ");

			for (int i = 0; i < 7; i++) {
				// System.out.println("");
				for (int j = 1; j < 12; j++) {
					System.out.print(MenuMain.timetable[i][j] + " ");
					if (MenuMain.timetable[i][j] == 3) {
						// System.out.println("find");
						bookCount = bookCount + 1;
						rs2.setInt(1, bookCount);
						rs2.setString(2, temp2);
						rs2.setString(3, temp1);
						rs2.setInt(4, MenuMain.timetable[i][0]);
						// rs2.setInt(5, MenuMain.timetable[i][1]);
						// rs2.setInt(6, MenuMain.timetable[i][2]);
						rs2.setInt(5, 7 + j);
						rs2.setInt(6, 8 + j);
						rs4.setInt(1, bookCount);
						rs4.setString(2, NewBookingController.Service);
						rs2.addBatch();
						rs4.addBatch();
						// System.out.println("added to batch");

					}
				}
			}
			rs2.executeBatch();
			rs4.executeBatch();
			// System.out.println("new booking saved");
		}else{
			// System.out.println("booking save function on");
						ResultSet rs3 = st.executeQuery("SELECT COUNT(BOOK_ID) FROM BOOKING");
						int bookCount = rs3.getInt("COUNT(BOOK_ID)");

						PreparedStatement rs2 = LoginConn.prepareStatement(
								"INSERT INTO BOOKING(BOOK_ID,USER_ID,EMP_ID,DAY,START_TIME,END_TIME,ACTIVE) VALUES(?,?,?,?,?,?,1) ");
						PreparedStatement rs4 = LoginConn.prepareStatement("INSERT INTO SERVICE(BOOK_ID,BOOK_SER) VALUES(?,?) ");

						for (int i = 0; i < 7; i++) {
							// System.out.println("");
							for (int j = 1; j < 12; j++) {
								System.out.print(MenuMain.timetable[i][j] + " ");
								if (MenuMain.timetable[i][j] == 3) {
									// System.out.println("find");
									bookCount = bookCount + 1;
									rs2.setInt(1, bookCount);
									rs2.setString(2, temp2);
									rs2.setString(3, temp1);
									rs2.setInt(4, MenuMain.timetable[i][0]);
									// rs2.setInt(5, MenuMain.timetable[i][1]);
									// rs2.setInt(6, MenuMain.timetable[i][2]);
									rs2.setInt(5, 7 + j);
									rs2.setInt(6, 8 + j);
									rs4.setInt(1, bookCount);
									rs4.setString(2, CustomerMakeBookingController.sss);
									rs2.addBatch();
									rs4.addBatch();
									// System.out.println("added to batch");

								}
							}
						}
						rs2.executeBatch();
						rs4.executeBatch();
						// System.out.println("new booking saved");
		}
		Stage stage = (Stage) Save.getScene().getWindow();
		stage.close();
	}
    // click no to exit without save
	@FXML
	void NoSave(ActionEvent event) {
		Stage stage = (Stage) NoSave.getScene().getWindow();
		stage.close();
	}

}
