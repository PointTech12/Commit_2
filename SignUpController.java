package zansfer;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class SignUpController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField usernameTextField;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Enter New Username
    }    

    @FXML
    private void SignUpAction(ActionEvent event) {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

    String Url = "jdbc:mysql://localhost:3306/PhoneManagement";
    String DBUser = "root";
    String DBPassword = "joshua123";

    try (Connection connection = DriverManager.getConnection(Url, DBUser, DBPassword)) {
        String query = "INSERT INTO login (username, password) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            int rowsAffected = preparedStatement.executeUpdate(); // Use executeUpdate() for INSERT

            if (rowsAffected > 0) {
                Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } else {
                showError("Registration Failed", "Failed to insert data into the database.");
            }
        }
    } catch (SQLException e) {
        // Handle database connection or query errors
        e.printStackTrace();
        showError("Database Error", "An error occurred while accessing the database.");
    } catch (IOException e) {
        // Handle FXML loading errors
        e.printStackTrace();
        showError("FXML Loading Error", "An error occurred while loading the FXML file.");
    }
    }

    @FXML
    private void OpenLoginPg(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    private void showError(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
