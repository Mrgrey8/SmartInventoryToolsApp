
package smartinventorytools;

import com.mysql.jdbc.Connection;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class AdminController implements Initializable {

    private String loginAdmin;
    private String passwordAdmin;

    public AdminController() {
    }

    public void setLoginAdmin(String loginAdmin) {
        this.loginAdmin = loginAdmin;
    }

    public void setPasswordAdmin(String passwordAdmin) {
        this.passwordAdmin = passwordAdmin;
    }

    public String getLoginAdmin() {
        return loginAdmin;
    }

    public String getPasswordAdmin() {
        return passwordAdmin;
    }

    @FXML
    private Label lblmessage;

    @FXML
    private TextField txtLogin;

    @FXML
    private PasswordField txtpassword;

    //Логинимся и проверяем авторизацию
    @FXML
    private void btnlogin(ActionEvent event) throws Exception {

        String className = "com.mysql.jdbc.Driver";
        String nameDataBase = "admin_inventory";
        String url = "jdbc:mysql://127.0.0.1:3306/";
        String name = "root";
        String password = "njgh3DW";
        Connection connection;

        try {
            Class.forName(className);
            url = url + nameDataBase;
            connection = (Connection) DriverManager.getConnection(url, name, password);

            Statement statement = connection.createStatement();
            String sql = "Select login_admin, password_admin From admin_data where login_admin ='" + txtLogin.getText() + "';";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                passwordAdmin = resultSet.getString("password_admin");
                loginAdmin = resultSet.getString("login_admin");
            }

            if (loginAdmin.equals(txtLogin.getText()) && passwordAdmin.equals(txtpassword.getText())) {
                loginPageTools.stage1.close();
                new MainModalWindow();
            } else {
                lblmessage.setText("Error!");
            }
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
