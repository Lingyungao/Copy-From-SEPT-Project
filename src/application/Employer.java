package application;


import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Employer {

	private StringProperty firstName;
	private StringProperty lastName;
	private StringProperty phone;
	private IntegerProperty empId;
	
	public Employer(){
		this(null,null,null,0);
	}
	
	public Employer(String firstName,String lastName,String phone, int empId){
		this.firstName = new SimpleStringProperty(firstName);
		this.lastName = new SimpleStringProperty(lastName);
		
		this.phone = new SimpleStringProperty(phone);
		this.empId = new SimpleIntegerProperty(empId);
	}
	
	public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }
	
    public String getPhone(){
    	return phone.get();
    }
    
    public void setPhone(String phone){
    	this.phone.set(phone);
    	
    }
    
    public StringProperty phoneProperty(){
    	return phone;
    }
    
    public int getEmpId(){
    	return empId.get();
    }
    
    public void setEmpId(int empId){
    	this.empId.set(empId);
    	
    }
    
    public IntegerProperty empIdProperty(){
    	return empId;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
