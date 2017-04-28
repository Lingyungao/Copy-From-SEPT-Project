package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginSystem2 {
	private static String pass = null;
	private static String user = null;	
	private static int userId;
	private static int permission;
	public static int returnId;
	private static Connection LoginConn = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	
	
	public static int login(String inputLogUser, String inputLogPass) throws Exception {


			// Start functions

			// Connection LoginConn = null;

			LoginConn = connection.connectDB(); // connect to the SQL

			st = LoginConn.createStatement(); // create statement of it

			rs = st.executeQuery("SELECT * FROM USERS where USERNAME = \'" + inputLogUser + "\'");
			// Query function 1(unsafe. easy to inject)
			while (rs.next()) {
				pass = rs.getString("PASSWORD");
				user = rs.getString("USERNAME");
				userId = rs.getInt("USER_ID");
				permission = rs.getInt("PERMISSION");

			}
			returnId = userId;

			// get username and password

			if (user.equals(inputLogUser) && pass.equals(inputLogPass)) {
				// compare with database. have to same both.
				if (permission == 1) {
					System.out.println("Login Succesful");
					MenuMain.userId = userId;
					MenuMain.premission = permission;
					return 2;
				} else if (permission == 2) {
					System.out.println("Login Succesful");
					MenuMain.userId = userId;
					MenuMain.premission = permission;
					return 3;
				} else {	
					System.out.println("Invalid Input!");
					return 1;
				}

			}else{
				System.out.println("The account is not exist or you do not register an account");
				return 1;
			}

		
	}
}
