
package smartinventorytools;
import java.util.Objects;
import javafx.beans.property.*;


public class Employee {
    //Declare Employees Table Columns
    private final  SimpleIntegerProperty id;
    private final  SimpleStringProperty firstName;
    private final  SimpleStringProperty secondName;
    private final  SimpleStringProperty lastName;
    private final  SimpleStringProperty jobPosition;
    private final  SimpleStringProperty startDate;
    private final  SimpleStringProperty firedDate;
  
 
    //Constructor
    public Employee() {
        this.id = new SimpleIntegerProperty();
        this.firstName = new SimpleStringProperty();
        this.secondName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.jobPosition = new SimpleStringProperty();
        this.startDate = new SimpleStringProperty();
        this.firedDate = new SimpleStringProperty();
    }
 
    //id
    public int getId() {
        return id.get();
    }
 
    public void setId(int employeeId){
        this.id.set(employeeId);
    }
 
    public IntegerProperty employeeIdProperty(){
        return id;
    }
 
    //firstName
    public String getFirstName () {
        return firstName.get();
    }
 
    public void setFirstName(String firstName){
        this.firstName.set(firstName);
    }
 
    public StringProperty firstNameProperty() {
        return firstName;
    }
 
    //secondName
    public String getSecondName () {
        return secondName.get();
    }
 
    public void setSecondName(String secondName){
        this.secondName.set(secondName);
    }
 
    public StringProperty secondNameProperty() {
        return secondName;
    }
 
    //lastName
    public String getLastName () {
        return lastName.get();
    }
 
    public void setLastName (String lastName){
        this.lastName.set(lastName);
    }
 
    public StringProperty lastNameProperty() {
        return lastName;
    }
 
    //jobPosition
    public String getJobPosition () {
        return jobPosition.get();
    }
 
    public void setJobPosition (String jobPosition){
        this.jobPosition.set(jobPosition);
    }
 
    public StringProperty jobPositionProperty() {
        return jobPosition;
    }
 
    //startDate
    public String getStartDate () {
        return startDate.get();
    }
 
    public void setStartDate (String startDate){
        this.startDate.set(startDate);
    }
 
    public StringProperty startDateProperty() {
        return startDate;
    }
 
    //firedDate
    public String getFiredDate () {
        return firedDate.get();
    }
 
    public void setFiredDate (String firedDate){
        this.firedDate.set(firedDate);
    }
 
    public StringProperty firedDateProperty() {
        return firedDate;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", lastName=" + lastName + ", jobPosition=" + jobPosition + ", startDate=" + startDate + ", firedDate=" + firedDate + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.firstName);
        hash = 59 * hash + Objects.hashCode(this.secondName);
        hash = 59 * hash + Objects.hashCode(this.lastName);
        hash = 59 * hash + Objects.hashCode(this.jobPosition);
        hash = 59 * hash + Objects.hashCode(this.startDate);
        hash = 59 * hash + Objects.hashCode(this.firedDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.secondName, other.secondName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.jobPosition, other.jobPosition)) {
            return false;
        }
        if (!Objects.equals(this.startDate, other.startDate)) {
            return false;
        }
        if (!Objects.equals(this.firedDate, other.firedDate)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
