package smartinventorytools;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SmartInventoryTools extends Application {

    public static Stage stage;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/FXMLDocument.fxml"));
        this.stage = stage;
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Welcome to Smart IT");
        stage.show();

    }

    @FXML
    public static void okButton(ActionEvent event) throws Exception {
        stage.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
