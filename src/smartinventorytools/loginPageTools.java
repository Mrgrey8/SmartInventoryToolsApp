/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartinventorytools;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class loginPageTools {

    public static Stage stage1;

    public void loginPageTools() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/LoginPageFXML.fxml"));

        Scene scene1 = new Scene(root);
        stage1 = new Stage();
        stage1.setScene(scene1);
        stage1.setTitle("Please Log IN!");
        stage1.show();

    }

}