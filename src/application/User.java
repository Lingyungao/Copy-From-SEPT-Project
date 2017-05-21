package application;

public class User {
	private String username;
	private String lastname;
	private String weekdaysName;

	private int ID;
	private String data;
	private int BookingID;
	private String empname;
	private int EmpID;
	private int StrTime;
	private String serviceName;

	public String defWeekdaysName(int data) { // Change 1~7 to Mon~Sun

		switch (data) {
		case 1: {
			this.weekdaysName = "Mon";
			break;
		}
		case 2: {
			this.weekdaysName = "Tue";
			break;
		}
		case 3: {
			this.weekdaysName = "Wed";
			break;
		}
		case 4: {
			this.weekdaysName = "Thu";
			break;
		}
		case 5: {
			this.weekdaysName = "Fri";
			break;
		}
		case 6: {
			this.weekdaysName = "Sat";
			break;
		}
		case 7: {
			this.weekdaysName = "Sun";
			break;
		}
		}
		return weekdaysName;

	}

	public String getWeekDaysName() {
		return weekdaysName;
	}

	public void setWeekdaysName(String weekdaysName) {
		this.weekdaysName = weekdaysName;
	}

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
	
	public String getUserService() {
		return serviceName;
	}

	public void setUserService(String serviceName) {
		this.serviceName = serviceName;
	}
}
