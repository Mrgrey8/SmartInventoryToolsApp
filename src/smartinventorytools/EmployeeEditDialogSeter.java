/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartinventorytools;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class EmployeeEditDialogSeter implements Initializable{
    
    private Stage dialogStage;
    private Employee employee; 
   

    @FXML
    private TextField firstNameField;
    @FXML
    private TextField secondNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField jobPositionField;
    @FXML
    private TextField startDateField;
    @FXML
    private TextField firedDateField;
    
 

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee2) {
        this.employee = employee2;
        
        firstNameField.setText(employee.getFirstName());
         secondNameField.setText(employee.getSecondName());
         lastNameField.setText(employee.getLastName());
          jobPositionField.setText(employee.getJobPosition());
          startDateField.setText(employee.getStartDate());
          firedDateField.setText(employee.getFiredDate());
  
    }
    
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         
    }
    
    @FXML
     public void updateDataButton(ActionEvent event) throws SQLException, Exception {
    
        String className = "com.mysql.jdbc.Driver";
        String nameDB = "admin_inventory";
        String url = "jdbc:mysql://127.0.0.1:3306/";
        String name = "root";
        String password = "njgh3DW";

        Connection connection = null;
        Statement statement = null;

        try {

            Class.forName(className);
            url += nameDB;
            connection = DriverManager.getConnection(url, name, password);
            statement = connection.createStatement();
  
              String updateEmployee = "UPDATE employee SET " +
                "firstNAME = '"+ firstNameField.getText() +"'," +
                "secondNAME = '"+ secondNameField.getText() +"'," +
                "lastNAME = '"+ lastNameField.getText() +"'," +
                "jobPosition = '" + jobPositionField.getText() + "'," +
                "startDate = '"+ startDateField.getText() +"'," +
                "firedDate = '"+ firedDateField.getText() +"'" +
                "WHERE user_id = " + getEmployee().getId()+ ";";
 
             statement.executeUpdate(updateEmployee);

             statement.close();
             EmployeeController.stageEditEmployee.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    
}
