package zansfer;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
    try {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("PhoneBook");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    } catch (IOException e) {
        e.printStackTrace();
    } 
}
        
    public static void main(String[] args) {
        launch(args);
    }
    
}
