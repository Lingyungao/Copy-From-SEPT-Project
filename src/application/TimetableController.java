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

//	int[][] timetable = new int[31][15];
	int[][] daystable = new int[100][13];
	
	String[][] btnIdSet = {
			            {"btn00","btn01","btn02","btn03","btn04","btn05","btn06","btn07","btn08","btn09","btn010"},
			            {"btn10","btn11","btn12","btn13","btn14","btn15","btn16","btn17","btn18","btn19","btn110"},
	                    {"btn20","btn21","btn22","btn23","btn24","btn25","btn26","btn27","btn28","btn29","btn210"},
	                    {"btn30","btn31","btn32","btn33","btn34","btn35","btn36","btn37","btn38","btn39","btn310"},
	                    {"btn40","btn41","btn42","btn43","btn44","btn45","btn46","btn47","btn48","btn49","btn410"},
	                    {"btn50","btn51","btn52","btn53","btn54","btn55","btn56","btn57","btn58","btn59","btn510"},
	                    {"btn60","btn61","btn62","btn63","btn64","btn65","btn66","btn67","btn68","btn69","btn610"}
                       };
	String weekdaysName;
	int dateCount;
	String first;
	String last;
	

	
//	public JFXButton setColor(JFXButton jfxbutton){
//		
//    	for(int i = 0; i <= 6;i++)
//    	{
//    		for(int j = 0; j <= 10; j++)
//    		{
//    			if(jfxbutton.getId().equals(btnIdSet[i][j]))
//    		    	{
//    				if(timetable[i][j+1]==0)
//    		    	{
//    		    		jfxbutton.setText("Unavalible");
//    		    		jfxbutton.setStyle("-fx-background-color:red");
////    		    		System.out.println(timetable[i][j+1] + " " + i + " " + j);
//    		    		
//    		    	}
//    		    	else if(timetable[i][j+1]==1)
//    		    	{
//    		    		timetable[i][j+1] = 1;
//    		    	    jfxbutton.setText("Avalible");
//    		    		jfxbutton.setStyle("-fx-background-color:lightgreen");
////    		    		System.out.println(timetable[i][j+1] + " " + i + " " + j);
//    		    	}
//    			}
//    		}
//    	}
//    	return jfxbutton;
//	}
//    	
		
	
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
    private void edit(ActionEvent event)  throws IOException{
    	JFXButton x =(JFXButton) event.getSource();
//    	if(MenuMain. premission == 2){
    	if(EmployeeMenuController.Selection==1){
    	for(int i = 0; i <= 6;i++)
    	{
    		for(int j = 0; j <= 10; j++)
    		{
    			if(x.getId().equals(btnIdSet[i][j]))
    			{
    		    	if(MenuMain.timetable[i][j+1]==1)
    		    	{
    		    		MenuMain.timetable[i][j+1] = 0;
    		    		x.setText("Unavalible");
    		    		x.setStyle("-fx-background-color:red");
    		    		System.out.println(MenuMain.timetable[i][j+1] + " " + i + " " + j);
    		    		
    		    	}
    		    	else if(MenuMain.timetable[i][j+1]==0)
    		    	{
    		    		MenuMain.timetable[i][j+1] = 1;
    		    	    x.setText("Avalible");
    		    		x.setStyle("-fx-background-color:lightgreen");
    		    		System.out.println(MenuMain.timetable[i][j+1] + " " + i + " " + j);
    		    	}
//    		    	else if(MenuMain.timetable[i][j+1]==1)
//    		    	{
//    		    		MenuMain.timetable[i][j+1] = 3;
//    		    	    x.setText("New book");
//    		    		x.setStyle("-fx-background-color:blue");
//    		    		System.out.println(MenuMain.timetable[i][j+1] + " " + i + " " + j);
//    		    	}
    			}
    		}
    	}
    	}
    	else if(EmployeeMenuController.Selection==0)
    	{
        	for(int i = 0; i <= 6;i++)
        	{
        		for(int j = 0; j <= 10; j++)
        		{
        			if(x.getId().equals(btnIdSet[i][j]))
        			{
        		    	if(MenuMain.timetable[i][j+1]==1)
        		    	{
        		    		MenuMain.timetable[i][j+1] = 3;
        		    		x.setText("new booking");
        		    		x.setStyle("-fx-background-color:yellow");
        		    		System.out.println(MenuMain.timetable[i][j+1] + " " + i + " " + j);
        		    		
        		    	}
        		    	else if(MenuMain.timetable[i][j+1]==3)
        		    	{
        		    		MenuMain.timetable[i][j+1] = 1;
        		    	    x.setText("AV");
        		    		x.setStyle("-fx-background-color:lightgreen");
        		    		System.out.println(MenuMain.timetable[i][j+1] + " " + i + " " + j);
        		    	}
//        		    	else if(MenuMain.timetable[i][j+1]==1)
//        		    	{
//        		    		MenuMain.timetable[i][j+1] = 3;
//        		    	    x.setText("New book");
//        		    		x.setStyle("-fx-background-color:blue");
//        		    		System.out.println(MenuMain.timetable[i][j+1] + " " + i + " " + j);
//        		    	}
        			}
        		}
        	}
    	}
//    	}
//    	else if(MenuMain. premission == 1)
//    	{
//    		for(int i =0; i <= 6;i++)
//    		{
//    		for(int j = 0; j <= 10; j++)
//    		{
//    			if(x.getId().equals(btnIdSet[i][j]))
//    			{
//    		    	if(MenuMain.timetable[i][j+1]==1)
//    		    	{
//    		    		MenuMain.timetable[i][j+1] = 3;
//    		    		x.setText("New booked");
//    		    		x.setStyle("-fx-background-color:blue");
//    		    		System.out.println(MenuMain.timetable[i][j+1] + " " + i + " " + j);
//    		    	}
//    		    	else if(MenuMain.timetable[i][j+1]==3)
//    		    	{
//    		    		MenuMain.timetable[i][j+1] = 1;
//    		    	    x.setText("Avalible");
//    		    		x.setStyle("-fx-background-color:lightgreen");
//    		    		System.out.println(MenuMain.timetable[i][j+1] + " " + i + " " + j);
//    		    	}
//    		    	}
//    			}
//    		}	
//    	}
    }
    
//    @FXML
//    private void edit01(ActionEvent event)  throws IOException{
//    	if(timetable[0][1]==1)
//    	{
//    		timetable[0][1] = 0;
//    		btn01.setText("Unavalible");
//    		btn01.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[0][1]==0)
//    	{
//    		timetable[0][1] = 1;
//    		btn01.setText("Avalible");
//    		btn01.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit02(ActionEvent event)  throws IOException{
//    	if(timetable[0][2]==1)
//    	{
//    		timetable[0][2] = 0;
//    		btn02.setText("Unavalible");
//    		btn02.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[0][2]==0)
//    	{
//    		timetable[0][2] = 1;
//    		btn02.setText("Avalible");
//    		btn02.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit03(ActionEvent event)  throws IOException{
//    	if(timetable[0][3]==1)
//    	{
//    		timetable[0][3] = 0;
//    		btn03.setText("Unavalible");
//    		btn03.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[0][3]==0)
//    	{
//    		timetable[0][3] = 1;
//    		btn03.setText("Avalible");
//    		btn03.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//
//    @FXML
//    private void edit04(ActionEvent event)  throws IOException{
//    	if(timetable[0][4]==1)
//    	{
//    		timetable[0][4] = 0;
//    		btn04.setText("Unavalible");
//    		btn04.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[0][4]==0)
//    	{
//    		timetable[0][4] = 1;
//    		btn04.setText("Avalible");
//    		btn04.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit05(ActionEvent event)  throws IOException{
//    	if(timetable[0][5]==1)
//    	{
//    		timetable[0][5] = 0;
//    		btn05.setText("Unavalible");
//    		btn05.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[0][5]==0)
//    	{
//    		timetable[0][5] = 1;
//    		btn05.setText("Avalible");
//    		btn05.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit06(ActionEvent event)  throws IOException{
//    	if(timetable[0][6]==1)
//    	{
//    		timetable[0][6] = 0;
//    		btn06.setText("Unavalible");
//    		btn06.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[0][6]==0)
//    	{
//    		timetable[0][6] = 1;
//    		btn06.setText("Avalible");
//    		btn06.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    @FXML
//    private void edit07(ActionEvent event)  throws IOException{
//    	if(timetable[0][7]==1)
//    	{
//    		timetable[0][7] = 0;
//    		btn07.setText("Unavalible");
//    		btn07.setStyle("-fx-background-color:red");
//    			
//    	}
//    	else if(timetable[0][7]==0)
//    	{
//    		timetable[0][7] = 1;
//    		btn07.setText("Avalible");
//    		btn07.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit08(ActionEvent event)  throws IOException{
//    	if(timetable[0][8]==1)
//    	{
//    		timetable[0][8] = 0;
//    		btn08.setText("Unavalible");
//    		btn08.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[0][8]==0)
//    	{
//    		timetable[0][8] = 1;
//    		btn08.setText("Avalible");
//    		btn08.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit09(ActionEvent event)  throws IOException{
//    	if(timetable[0][9]==1)
//    	{
//    		timetable[0][9] = 0;
//    		btn09.setText("Unavalible");
//    		btn09.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[0][9]==0)
//    	{
//    		timetable[0][9] = 1;
//    		btn09.setText("Avalible");
//    		btn09.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    @FXML
//    private void edit010(ActionEvent event)  throws IOException{
//    	if(timetable[0][10]==1)
//    	{
//    		timetable[0][10] = 0;
//    		btn010.setText("Unavalible");
//    		btn010.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[0][10]==0)
//    	{
//    		timetable[0][10] = 1;
//    		btn010.setText("Avalible");
//    		btn010.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    @FXML
//    private void edit10(ActionEvent event)  throws IOException{
//    	if(timetable[1][0]==1)
//    	{
//    		timetable[1][1] = 0;
//    		btn10.setText("Unavalible");
//    		btn10.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[1][0]==0)
//    	{
//    		timetable[1][0] = 1;
//    		btn10.setText("Avalible");
//    		btn10.setStyle("-fx-background-color:lightgreen");
//    	}
//    	
//    	
//    }
//    
//    @FXML
//    private void edit11(ActionEvent event)  throws IOException{
//    
//    	if(timetable[1][1]==1)
//    	{
//    		timetable[1][1] = 0;
//    		btn11.setText("Unavalible");
//    		btn11.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[1][1]==0)
//    	{
//    		timetable[1][1] = 1;
//    		btn11.setText("Avalible");
//    		btn11.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit12(ActionEvent event)  throws IOException{
//    	if(timetable[1][2]==1)
//    	{
//    		timetable[1][2] = 0;
//    		btn12.setText("Unavalible");
//    		btn12.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[1][2]==0)
//    	{
//    		timetable[1][2] = 1;
//    		btn12.setText("Avalible");
//    		btn12.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit13(ActionEvent event)  throws IOException{
//    	if(timetable[1][3]==1)
//    	{
//    		timetable[1][3] = 0;
//    		btn13.setText("Unavalible");
//    		btn13.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[1][3]==0)
//    	{
//    		timetable[1][3] = 1;
//    		btn13.setText("Avalible");
//    		btn13.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit14(ActionEvent event)  throws IOException{
//    	if(timetable[1][4]==1)
//    	{
//    		timetable[1][4] = 0;
//    		btn14.setText("Unavalible");
//    		btn14.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[1][4]==0)
//    	{
//    		timetable[1][4] = 1;
//    		btn14.setText("Avalible");
//    		btn14.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit15(ActionEvent event)  throws IOException{
//    	if(timetable[1][5]==1)
//    	{
//    		timetable[1][5] = 0;
//    		btn15.setText("Unavalible");
//    		btn15.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[1][5]==0)
//    	{
//    		timetable[1][5] = 1;
//    		btn15.setText("Avalible");
//    		btn15.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit16(ActionEvent event)  throws IOException{
//    	if(timetable[1][6]==1)
//    	{
//    		timetable[1][6] = 0;
//    		btn16.setText("Unavalible");
//    		btn16.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[1][6]==0)
//    	{
//    		timetable[1][6] = 1;
//    		btn16.setText("Avalible");
//    		btn16.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit17(ActionEvent event)  throws IOException{
//    	if(timetable[1][7]==1)
//    	{
//    		timetable[1][7] = 0;
//    		btn17.setText("Unavalible");
//    		btn17.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[1][7]==0)
//    	{
//    		timetable[1][7] = 1;
//    		btn17.setText("Avalible");
//    		btn17.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit18(ActionEvent event)  throws IOException{
//    	if(timetable[1][8]==1)
//    	{
//    		timetable[1][8] = 0;
//    		btn18.setText("Unavalible");
//    		btn18.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[1][8]==0)
//    	{
//    		timetable[1][8] = 1;
//    		btn18.setText("Avalible");
//    		btn18.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit19(ActionEvent event)  throws IOException{
//    	if(timetable[1][9]==1)
//    	{
//    		timetable[1][9] = 0;
//    		btn19.setText("Unavalible");
//    		btn19.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[1][9]==0)
//    	{
//    		timetable[1][9] = 1;
//    		btn19.setText("Avalible");
//    		btn19.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit110(ActionEvent event)  throws IOException{
//    	if(timetable[1][10]==1)
//    	{
//    		timetable[1][10] = 0;
//    		btn110.setText("Unavalible");
//    		btn110.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[1][10]==0)
//    	{
//    		timetable[1][10] = 1;
//    		btn110.setText("Avalible");
//    		btn110.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//
//    @FXML
//    private void edit20(ActionEvent event)  throws IOException{
//    	if(timetable[2][0]==1)
//    	{
//    		timetable[2][0] = 0;
//    		btn20.setText("Unavalible");
//    		btn20.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[2][0]==0)
//    	{
//    		timetable[1][0] = 1;
//    		btn20.setText("Avalible");
//    		btn20.setStyle("-fx-background-color:lightgreen");
//    	}
//    	
//    	
//    }
//    
//    @FXML
//    private void edit21(ActionEvent event)  throws IOException{
//    
//    	if(timetable[2][1]==1)
//    	{
//    		timetable[2][1] = 0;
//    		btn21.setText("Unavalible");
//    		btn21.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[2][1]==0)
//    	{
//    		timetable[2][1] = 1;
//    		btn21.setText("Avalible");
//    		btn21.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit22(ActionEvent event)  throws IOException{
//    	JFXButton temp =(JFXButton) event.getSource();
//    	temp.getId();
//    	
//    	if(timetable[2][2]==1)
//    	{
//    		timetable[2][2] = 0;
//    		btn22.setText("Unavalible");
//    		btn22.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[2][2]==0)
//    	{
//    		timetable[2][2] = 1;
//    		btn22.setText("Avalible");
//    		btn22.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit23(ActionEvent event)  throws IOException{
//    	if(timetable[2][3]==1)
//    	{
//    		timetable[2][3] = 0;
//    		btn23.setText("Unavalible");
//    		btn23.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[2][3]==0)
//    	{
//    		timetable[2][3] = 1;
//    		btn23.setText("Avalible");
//    		btn23.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit24(ActionEvent event)  throws IOException{
//    	if(timetable[2][4]==1)
//    	{
//    		timetable[2][4] = 0;
//    		btn24.setText("Unavalible");
//    		btn24.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[2][4]==0)
//    	{
//    		timetable[2][4] = 1;
//    		btn24.setText("Avalible");
//    		btn24.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit25(ActionEvent event)  throws IOException{
//    	if(timetable[2][5]==1)
//    	{
//    		timetable[2][5] = 0;
//    		btn25.setText("Unavalible");
//    		btn25.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[2][5]==0)
//    	{
//    		timetable[2][5] = 1;
//    		btn25.setText("Avalible");
//    		btn25.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit26(ActionEvent event)  throws IOException{
//    	if(timetable[2][6]==1)
//    	{
//    		timetable[2][6] = 0;
//    		btn26.setText("Unavalible");
//    		btn26.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[2][6]==0)
//    	{
//    		timetable[2][6] = 1;
//    		btn26.setText("Avalible");
//    		btn26.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit27(ActionEvent event)  throws IOException{
//    	if(timetable[2][7]==1)
//    	{
//    		timetable[1][7] = 0;
//    		btn00.setText("Unavalible");
//    		btn00.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[1][7]==0)
//    	{
//    		timetable[1][7] = 1;
//    		btn00.setText("Avalible");
//    		btn00.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit18(ActionEvent event)  throws IOException{
//    	if(timetable[1][8]==1)
//    	{
//    		timetable[1][8] = 0;
//    		btn00.setText("Unavalible");
//    		btn00.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[1][8]==0)
//    	{
//    		timetable[1][8] = 1;
//    		btn00.setText("Avalible");
//    		btn00.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit19(ActionEvent event)  throws IOException{
//    	if(timetable[1][9]==1)
//    	{
//    		timetable[1][9] = 0;
//    		btn00.setText("Unavalible");
//    		btn00.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[1][9]==0)
//    	{
//    		timetable[1][9] = 1;
//    		btn00.setText("Avalible");
//    		btn00.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    @FXML
//    private void edit110(ActionEvent event)  throws IOException{
//    	if(timetable[1][10]==1)
//    	{
//    		timetable[1][10] = 0;
//    		btn00.setText("Unavalible");
//    		btn00.setStyle("-fx-background-color:red");
//    		
//    	}
//    	else if(timetable[1][10]==0)
//    	{
//    		timetable[1][10] = 1;
//    		btn00.setText("Avalible");
//    		btn00.setStyle("-fx-background-color:lightgreen");
//    	}
//    }
//    
//    
//    
//    

    @FXML
    void save(ActionEvent event) throws SQLException {
		
		Connection LoginConn = null;
		Statement st = null;
		
		LoginConn = connection.connectDB();                              // connect to the SQL
		st = LoginConn.createStatement();  
		
		for(int i =0;i<7;i++){
			for(int j =3;j<14;j++)
			{
				if(MenuMain.timetable[i][j]==3)      //to make new booking
				{
					MenuMain.timetable[i][j]=2;
				}
			}
		}
		
		
		
		
		PreparedStatement rs = LoginConn.prepareStatement(
				"UPDATE TIMETABLE SET  T0800=?, T0900=?, T1000=?, T1100=?, T1200=?, T1300=?, T1400=?, T1500=?, T1600=?, T1700=?, T1800=? "
				+ " WHERE WEEKDAYS=?"

				+ " AND EMP_UID=? ");
		
    	

		
		for (int i = 0; i < 7; i++) {
//			for(int j = 3; j < 14; j++)
//				{
//				if(MenuMain.timetable[i][j]==3) //to make new booking
//				{
//					MenuMain.timetable[i][j]=2;
//				}
//				rs.setInt(j-2, MenuMain.timetable[i][j]);
//				}
			
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
			
		    rs.setInt(12, MenuMain.timetable[i][0]);
			rs.setString(13, EmployeeMenuController.tempEmpId);
//			    rs.setInt(16, MenuMain.timetable[i][16]);
				rs.addBatch();
			}
		rs.executeBatch();
		System.out.println("save done.");
		
    	 if(EmployeeMenuController.Selection==0){
    		 System.out.println("booking save function on");
    		 ResultSet rs3 = st.executeQuery("SELECT COUNT(BOOK_ID) FROM BOOKING");
    		 int bookCount = rs3.getInt("COUNT(BOOK_ID)");
    		 
    		 PreparedStatement rs2 = LoginConn.prepareStatement("INSERT INTO BOOKING(BOOK_ID,USER_ID,EMP_ID,DAY,START_TIME,END_TIME,ACTIVE) VALUES(?,?,?,?,?,?,1) ");
    		 PreparedStatement rs4 = LoginConn.prepareStatement("INSERT INTO SERVICE(BOOK_ID,BOOK_SER) VALUES(?,?) ");

    		 
    		 for (int i = 0; i < 7; i++) {
    			 System.out.println("");
    			 for(int j=3; j < 15;j++){
    				 System.out.print(MenuMain.timetable[i][j] + " ");
    				 if(MenuMain.timetable[i][j] == 2){
    					 System.out.println("find");
    		    		 bookCount = bookCount + 1;
    					rs2.setInt(1, bookCount );
						rs2.setString(2, NewBookingController.userIdCheck);
						rs2.setString(3, EmployeeMenuController.tempEmpId);
						rs2.setInt(4, MenuMain.timetable[i][0]);
						//rs2.setInt(5, MenuMain.timetable[i][1]);
						//rs2.setInt(6, MenuMain.timetable[i][2]);
						rs2.setInt(5, MenuMain.timetable[i][j]);
						rs2.setInt(6, MenuMain.timetable[i][2] + 1);
						rs4.setInt(1, bookCount);
						rs4.setString(2, NewBookingController.tempService);
						rs2.addBatch();
						rs4.addBatch();
						System.out.println("added to batch");
    				 }
    			 }
    		 }
    		rs2.executeBatch();
    		rs4.executeBatch();
			System.out.println("new booking saved");

    	 }
			
		


    }
}
