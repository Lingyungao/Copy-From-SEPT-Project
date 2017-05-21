package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public static int businessID;
	
	public static int getBusId(String businessName) throws SQLException {
		int BusId;
		Connection LoginConn = connection.connectDB();
		Statement st = LoginConn.createStatement();
		ResultSet rs = st.executeQuery("select * from BUSINESS where BUS_NAME = \"" + businessName + "\";");
		BusId = rs.getInt("BUS_ID");
		return BusId;
	}
	
	public static int search(int UserId) throws SQLException
	{
		Connection LoginConn = connection.connectDB();
		Statement st = LoginConn.createStatement();
		ResultSet rs = st.executeQuery("select * from USERS_BUS where USER_ID = \"" + UserId + "\";");
		int tarBusId = rs.getInt("BUS_ID");
		return tarBusId;
	}

	public static int login(String inputLogUser, String inputLogPass,String businessName) throws Exception {
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
		
		if(permission == 4)
			return 4;
		if(businessName == null)
		{
			throw new Exception("Sorry, Please choose a business!");
		}
		
		int BusId = getBusId(businessName);
		
		businessID = BusId;

		int tarBusId = search(userId);
		// get username and password

		if (user.equals(inputLogUser) && pass.equals(inputLogPass) && BusId == tarBusId) {
			// compare with database. have to same both.

			if (permission == 1) {
				System.out.println("Login Succesful");
				MenuMain.userId = userId;
				MenuMain.premission = permission;
				MenuMain.userName = user;
				return 2;
			} else if (permission == 2) {
				System.out.println("Login Succesful");
				MenuMain.userId = userId;
				MenuMain.premission = permission;
				MenuMain.userName = user;
				return 3;
			} else {
				System.out.println("Invalid Input!");
				return 1;
			}

		} else {
			System.out.println("The account is not exist or you do not register an account");
			return 1;
		}

	}
}
