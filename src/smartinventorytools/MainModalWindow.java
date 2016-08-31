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
import static smartinventorytools.MainModalWindow.stage;

/**
 *
 * @author admin
 */
public class MainModalWindow {

    public static Stage stage;

    public MainModalWindow() throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("view/MainModalWindow.fxml"));

        Scene scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Main Page");
        stage.show();
    }

}
