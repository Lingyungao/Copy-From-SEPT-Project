package ViewCustomerTest;

import java.sql.Connection;
import java.sql.DriverManager;

public class connection {
	private static Connection myConn = null;

	public static Connection connectDB() {
		try {
			if (myConn == null) {

				Class.forName("org.sqlite.JDBC");
				myConn = DriverManager.getConnection("jdbc:sqlite:SEPT.sqlite");
				// start to connect
				System.out.println("Waiting for SQL response");
			}
			return myConn;
			// return connection status
		} catch (Exception exc) {
			System.out.println("Not connectted");
		}
		return null;
	}
}
