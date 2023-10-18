package zansfer;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


public class HomeController implements Initializable {
    
    Connection con;
    Statement stm;
    
    @FXML
    private TableView<Contact> ContactTable;
    @FXML
    private TextField IDTxt;
    @FXML
    private TextField NameTxt;
    @FXML
    private TextField EmailTxt;
    @FXML
    private TextField HomeTxt;
    @FXML
    private TextField PhoneTxt;
    @FXML
    private TextField MobileTxt;
    @FXML
    private TextField FavTxt;
    @FXML
    private TextField GroupTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDatabaseData();
    }    
    
    //Add Button
    @FXML
    private void AddAction(ActionEvent event) {
          String name = NameTxt.getText();
            String phone = PhoneTxt.getText();
            String mobile = MobileTxt.getText();
            String email = EmailTxt.getText();
            String address = HomeTxt.getText();
            String favourite = FavTxt.getText();
            String group = GroupTxt.getText();
            
            if (name.isEmpty() || phone.isEmpty() || mobile.isEmpty() || email.isEmpty() || address.isEmpty() ||
                    favourite.isEmpty() || group.isEmpty()) {
                // Display an error message here if any field is empty.
                showErrorAlert("Error", "Please fill in all the details.");
            } else if (!name.matches("^[a-zA-Z\\s]+$")) {
            showErrorAlert("Error", "Invalid name format. Please use only letters and spaces.");
            } else if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            showErrorAlert("Error", "Invalid email format. Please provide a valid email address.");
            } else if (!phone.matches("^[0-9]+$") || !mobile.matches("^[0-9]+$")) {
            showErrorAlert("Error", "Phone and Mobile numbers must contain only digits.");
            } else if (!isYesOrNo(favourite)) {
            showErrorAlert("Error", "Favourite must be 'Yes' or 'No'.");
            
            }else {
                
                // Attempt to insert data into the database
                String Url = "jdbc:mysql://localhost:3306/PhoneManagement";
                String User = "root";
                String Password = "joshua123";
                
                try (Connection connection = DriverManager.getConnection(Url, User, Password)) {
                    String query = "INSERT INTO add_contact (name, phone, mobile, email, address, favourite, group_name) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                        preparedStatement.setString(1, name);
                        preparedStatement.setString(2, phone);
                        preparedStatement.setString(3, mobile);
                        preparedStatement.setString(4, email);
                        preparedStatement.setString(5, address);
                        preparedStatement.setString(6, favourite);
                        preparedStatement.setString(7, group);
                        
                        int rowsAffected = preparedStatement.executeUpdate();
                        
                        if (rowsAffected == 1) {
                            // Data inserted successfully
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Success");
                            alert.setHeaderText(null);
                            alert.setContentText("Contact added successfully.");
                            alert.showAndWait();
                            
                        } else {
                            // Insertion failed
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Error");
                            alert.setHeaderText(null);
                            alert.setContentText("Failed to add contact. Please try again.");
                            alert.showAndWait();
                        }
                    }
                    
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }
    //Update Button
    @FXML
    private void UpdateAction(ActionEvent event) {
        
    }
    //DeleteButton
    @FXML
    private void DeleteAction(ActionEvent event) {
        
    }
    private void loadDatabaseData() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/PhoneManagement";
        String username = "root";
        String password = "joshua123";

        ObservableList<Contact> data = FXCollections.observableArrayList();

        try {
            Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM add_contact");

            while (resultSet.next()) {
                String IDColm = resultSet.getString("id");
                String NameColm = resultSet.getString("name");
                String PhoneColm = resultSet.getString("phone");
                String MobileColm = resultSet.getString("mobile");
                String EmailColm = resultSet.getString("email");
                String HomeColm = resultSet.getString("address");
                String FavColm = resultSet.getString("favourite");
                String GroupColm = resultSet.getString("group_name");
                
                

                data.add(new Contact(IDColm, NameColm, PhoneColm, MobileColm, EmailColm, HomeColm, FavColm, GroupColm));
            }

            ContactTable.setItems(data);
            ContactTable.refresh();

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void showErrorAlert(String title, String content) {
    Alert alert = new Alert(Alert.AlertType.ERROR);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(content);
    alert.showAndWait();
}
    private void showInfoAlert(String title, String content) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(content);
    alert.showAndWait();
}
    private boolean isYesOrNo(String input) {
    return input.equalsIgnoreCase("Yes") || input.equalsIgnoreCase("No");
}
}
