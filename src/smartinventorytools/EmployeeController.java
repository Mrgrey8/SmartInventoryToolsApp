/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartinventorytools;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;



/**
 *
 * @author admin
 */
public class EmployeeController implements Initializable {
    
    int useId;
    public static Stage stageEdit;
    public static Stage stageAdd;

    @FXML
    private TableView<Employee> tableEmployee;

    @FXML
    private TableColumn<Employee, Integer> idColumn;

    @FXML
    private TableColumn<Employee, String> firstNameColumn;

    @FXML
    private TableColumn<Employee, String> secondNameColumn;

    @FXML
    private TableColumn<Employee, String> lastNameColumn;

    @FXML
    private TableColumn<Employee, String> jobPositionColumn;

    @FXML
    private TableColumn<Employee, String> startDateColumn;

    @FXML
    private TableColumn<Employee, String> firedDateColumn;

    private ObservableList<Employee> data;
    
    private ObservableList<Employee> dataEditView;
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            tableViewMethod();
           
        } catch (Exception ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Открывает окно добавления сотрудника.
    @FXML
    private void btnAddEmployee(ActionEvent event) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("view/addEmployee.fxml"));

        Scene scene = new Scene(root);
        stageAdd = new Stage();
        stageAdd.setScene(scene);
        stageAdd.setTitle("Новый сотрудник");
        stageAdd.show();
        

    }

    //Обновляет таблицу
    @FXML
    public void btnRefresh() throws Exception {

        tableViewMethod();   
        
    }
    
    //удаляет обьект
    @FXML
    public void btnDelete(){
        
          useId = tableEmployee.getSelectionModel().getSelectedItem().getId();
          
          int selectedIndex = tableEmployee.getSelectionModel().getSelectedIndex();
          
          tableEmployee.getItems().remove(selectedIndex);
          
        String className = "com.mysql.jdbc.Driver";
        String nameDataBase = "admin_inventory";
        String url = "jdbc:mysql://127.0.0.1:3306/";
        String name = "root";
        String password = "njgh3DW";
        com.mysql.jdbc.Connection connection;
           try {
            Class.forName(className);
            url = url + nameDataBase;
            connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, name, password);
            Statement statement = connection.createStatement();

            //stat.executeUpdate("drop table if exists user");
            String viewEmployee = "DELETE FROM employee WHERE user_id=" + useId + "";
            statement.executeUpdate(viewEmployee);
            
             } catch (Exception e) {

            e.printStackTrace();

            System.out.println("Delete Data Error");
        }
          
    }
    
    @FXML
    private void btnEdit(ActionEvent action) throws Exception{
        useId = tableEmployee.getSelectionModel().getSelectedItem().getId();
          
          int selectedIndex = tableEmployee.getSelectionModel().getSelectedIndex();
          
         System.out.println(tableEmployee.getItems().get(selectedIndex));
      
     Parent root = FXMLLoader.load(getClass().getResource("view/editEmployee.fxml"));

        Scene scene = new Scene(root);
        stageEdit = new Stage();
        stageEdit.setScene(scene);
        stageEdit.setTitle("Редактируйте сотрудника");
        stageEdit.show();
        
        
    }

    //Выводит таблицу на экран
    public void tableViewMethod() throws Exception {

        String className = "com.mysql.jdbc.Driver";
        String nameDataBase = "admin_inventory";
        String url = "jdbc:mysql://127.0.0.1:3306/";
        String name = "root";
        String password = "njgh3DW";
        com.mysql.jdbc.Connection connection;

        try {
            Class.forName(className);
            url = url + nameDataBase;
            connection = (com.mysql.jdbc.Connection) DriverManager.getConnection(url, name, password);
            Statement statement = connection.createStatement();

            //stat.executeUpdate("drop table if exists user");
            String viewEmployee = "SELECT * FROM employee";
            ResultSet resultSet = statement.executeQuery(viewEmployee);
            
        

            data = FXCollections.observableArrayList();

            while (resultSet.next()) {
                Employee employee = new Employee();

                employee.setId(Integer.parseInt(resultSet.getString("user_id")));
                employee.setFirstName(resultSet.getString("firstName"));
                employee.setSecondName(resultSet.getString("secondName"));
                employee.setLastName(resultSet.getString("lastName"));
                employee.setJobPosition(resultSet.getString("jobPosition"));
                employee.setStartDate(resultSet.getString("startDate"));
                employee.setFiredDate(resultSet.getString("firedDate"));

                data.add(employee);

            }

          /*  idColumn.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
            firstNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("firstName"));
            secondNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("secondName"));
            lastNameColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("lastName"));
            jobPositionColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("jobPosition"));
            startDateColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("startDate"));
            firedDateColumn.setCellValueFactory(new PropertyValueFactory<Employee, String>("firedDate"));*/
          
            idColumn.setCellValueFactory(cellData -> cellData.getValue().employeeIdProperty().asObject());
            firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
            secondNameColumn.setCellValueFactory(celldata -> celldata.getValue().secondNameProperty());
            lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
            jobPositionColumn.setCellValueFactory(cellData -> cellData.getValue().jobPositionProperty());
            startDateColumn.setCellValueFactory(cellData -> cellData.getValue().startDateProperty());
            firedDateColumn.setCellValueFactory(cellData -> cellData.getValue().firedDateProperty());

            tableEmployee.setItems(data);
            
            tableEmployee.getSelectionModel().selectedItemProperty().addListener((newValue)->{
            System.out.println("select: " + newValue.toString());
            });
            
            
            

        } catch (Exception e) {

            e.printStackTrace();

            System.out.println("Error on Building Data");
        }
        
    }
    
    
    
    

}
