package application;


import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class is working on the customer check booking.
 *
 * @author Harold Zang
 */
public class CustomerCheckBooking {

	private IntegerProperty bookId;
	private IntegerProperty empId;
	private StringProperty empName;
	private StringProperty bookDate;
	private StringProperty startTime;
	private StringProperty endTime;
	
	/**
	 * Define a booking structure.
	 *
	 */
	public CustomerCheckBooking(){
		this(0,0,null,null,null,null);
	}
	
	/**
	 * The booking detail structure which include all information which related book.
	 *
	 * @param bookid
	 * @param employee id
	 * @param employee name
	 * @param book date
	 * @param start time
	 * @param end time
	 */
	public CustomerCheckBooking(int bookId,int empId,String empName, String bookDate, String startTime, String endTime){
		this.bookId = new SimpleIntegerProperty(bookId);
		this.empId = new SimpleIntegerProperty(empId);
		this.empName = new SimpleStringProperty(empName);
		this.bookDate = new SimpleStringProperty(bookDate);
		this.startTime = new SimpleStringProperty(startTime);
		this.endTime = new SimpleStringProperty(endTime);
	}
	
	
	public int getBookId() {
        return bookId.get();
    }

    public void setBookId(int bookId) {
        this.bookId.set(bookId);
    }

    public IntegerProperty bookIdProperty() {
        return bookId;
    }

    public int getEmpId() {
        return empId.get();
    }

    public void setEmpId(int empId) {
        this.empId.set(empId);
    }

    public IntegerProperty empIdProperty() {
        return empId;
    }
	
    public String getEmpName(){
    	return empName.get();
    }
    
    public void setEmpName(String empName){
    	this.empName.set(empName);
    	
    }
    
    public StringProperty empNameProperty(){
    	return empName;
    }
    
    public String getBookDate(){
    	return bookDate.get();
    }
    
    public void setBookDate(String bookDate){
    	this.bookDate.set(bookDate);
    	
    }
    
    public StringProperty bookDateProperty(){
    	return bookDate;
    }
    //
    public String getStartTime(){
    	return startTime.get();
    }
    
    public void setStartTime(String startTime){
    	this.startTime.set(startTime);
    	
    }
    
    public StringProperty startTimeProperty(){
    	return startTime;
    }
    //
    public String getEndTime(){
    	return endTime.get();
    }
    
    public void setEndTime(String endTime){
    	this.endTime.set(endTime);
    	
    }
    
    public StringProperty endTimeProperty(){
    	return endTime;
    }
    
    
    
}