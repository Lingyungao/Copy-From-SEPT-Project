package application;

/**
 * This class is working on the customer view booking. For get all details
 * (username, employee name etc.)
 *
 */
public class CustomerViewBooking {
	private String username;
	private String lastname;
	private int ID;
	private String data;
	private int BookingID;
	private String empname;
	private int EmpID;
	private int StrTime;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserSecName() {
		return lastname;
	}

	public void setUserSecName(String lastname) {
		this.lastname = lastname;
	}

	public int getID() {
		return ID;
	}

	public void setID(int i) {
		this.ID = i;
	}

	public String getData() {
		return data;
	}

	public void setData(String string) {
		this.data = string;
	}

	public int getBookID() {
		return BookingID;
	}

	public void setBookID(int BookingID) {
		this.BookingID = BookingID;
	}

	public String getEmpName() {
		return empname;
	}

	public void setEmpName(String empname) {
		this.empname = empname;
	}

	public int getEmpID() {
		return EmpID;
	}

	public void setEmpID(int EmpID) {
		this.EmpID = EmpID;
	}

	public int getStrTime() {
		return StrTime;
	}

	public void setStrTime(int StrTime) {
		this.StrTime = StrTime;
	}
}