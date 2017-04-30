package application;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class is working on list the employee detail when the customer make a
 * booking.
 *
 */
public class CustomerBookEmployer {

	private StringProperty firstName;
	private StringProperty lastName;
	private StringProperty phone;
	private IntegerProperty empId;

	// Create the employer structure.
	public CustomerBookEmployer() {
		this(null, null, null, 0);
	}

	/**
	 * Create the employer structure.
	 * 
	 * @param Employee
	 *            first name.
	 * @param Employee
	 *            last name.
	 * @param Employee
	 *            phone number.
	 * @param Employee
	 *            Id.
	 */
	public CustomerBookEmployer(String firstName, String lastName, String phone, int empId) {
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);

		this.phone = new SimpleStringProperty(phone);
		this.empId = new SimpleIntegerProperty(empId);
	}

	/**
	 * Get the employer structure.
	 */
	public String getFirstName() {
		return firstName.get();
	}

	/**
	 * Set the employer first name.
	 * 
	 * @param Employee
	 *            first name.
	 */
	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public StringProperty firstNameProperty() {
		return firstName;
	}

	/**
	 * Get the employer last name.
	 */
	public String getLastName() {
		return lastName.get();
	}

	/**
	 * Set the employer last name.
	 * 
	 * @param Employee
	 *            last name.
	 */
	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public StringProperty lastNameProperty() {
		return lastName;
	}

	/**
	 * Get the employer phone number.
	 */
	public String getPhone() {
		return phone.get();
	}

	/**
	 * Set the employer phone number.
	 */
	public void setPhone(String phone) {
		this.phone.set(phone);

	}

	public StringProperty phoneProperty() {
		return phone;
	}

	/**
	 * Get the employer id.
	 */
	public int getEmpId() {
		return empId.get();
	}

	/**
	 * Set the employer id.
	 */
	public void setEmpId(int empId) {
		this.empId.set(empId);

	}

	public IntegerProperty empIdProperty() {
		return empId;
	}

}