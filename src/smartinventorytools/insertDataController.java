/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartinventorytools;

import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

/**
 *
 * @author admin
 */
public class insertDataController implements Initializable {

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtSecondName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtJobPosition;

    @FXML
    private DatePicker txtStartDate;
    @FXML
    private DatePicker txtFiredDate;

    @FXML
    public void insertDataButton(ActionEvent event) throws SQLException, Exception {
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

            String insertEmployee = "INSERT INTO employee (firstName, secondName, lastName, jobPosition, startDate, firedDate) VALUES  ('" + txtFirstName.getText() + "',"
                    + "'" + txtSecondName.getText() + "', '" + txtLastName.getText() + "', '" + txtJobPosition.getText() + "', '" + txtStartDate.getEditor().getText() + "', '" + txtFiredDate.getEditor().getText() + "');";
            statement.executeUpdate(insertEmployee);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
                EmployeeController.stageAdd.close();
                /* mainPage.stage.close();
            new mainPage();*/

            }
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String pattern = "yyyy-MM-dd";

        txtStartDate.setPromptText(pattern.toLowerCase());

        txtStartDate.setConverter(new StringConverter<LocalDate>() {

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }

        });

        txtFiredDate.setPromptText(pattern.toLowerCase());

        txtFiredDate.setConverter(new StringConverter<LocalDate>() {

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }

        });

    }

}
