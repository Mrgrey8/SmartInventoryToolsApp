package smartinventorytools;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;


public class LoginModalWindow implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }

    public void goToLoginPage(ActionEvent event) throws Exception {
        SmartInventoryTools.stage.close();
        loginPageTools login = new loginPageTools();
        login.loginPageTools();
        
    }

}
