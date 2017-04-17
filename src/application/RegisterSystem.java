package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterSystem {
	
	private static Connection LoginConn = null;
	private static ResultSet rs = null;
	private static Statement st = null;
	
	
	public void Register(String inputUser, String inputPass) throws SQLException {
		
			LoginConn = connection.connectDB();

			st = LoginConn.createStatement(); // create statement of it

			rs = st.executeQuery("SELECT COUNT(USER_ID) FROM USERS");

			int userCount = rs.getInt("COUNT(USER_ID)");

			int userCount2 = userCount + 1;
			// query type 2. more security than type 1. and more easy to write.
			PreparedStatement rs = LoginConn
					.prepareStatement("INSERT INTO USERS(USERNAME,PASSWORD,USER_ID,PERMISSION) VALUES(?,?,?,1)");
			rs.setString(1, inputUser);
			rs.setString(2, inputPass);
			rs.setInt(3, userCount2);
			// excuteQuery for query. excuteUpdate for editing the database
			rs.executeUpdate();

			PreparedStatement rs2 = LoginConn.prepareStatement(
			"INSERT INTO DETAILS(USER_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NO,ADDRESS) VALUES(?,?,?,?,?,?)");
			rs2.setInt(1, userCount2);
			rs2.setString(2, null);
			rs2.setString(3, null);
			rs2.setString(4, null);
			rs2.setString(5, null);
			rs2.setString(6, null);
			rs2.executeUpdate();

			System.out.println("finished");
	}
}
