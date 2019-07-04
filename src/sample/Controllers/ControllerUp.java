package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DB.DatabaseHandler;
import sample.Users;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerUp {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField userLogin;

    @FXML
    private Button regButton;

    @FXML
    private TextField userPassword;

    @FXML
    private Button backButton;

    @FXML
    void initialize() {

        regButton.setOnAction(event -> {
                    signUpUser();
                }
        );

        backButton.setOnAction(event -> {

            backButton.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();

            loader.setLocation(getClass().getResource("/sample/FXML/sample.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });
    }

    private void signUpUser() {
        DatabaseHandler dbHandler = new DatabaseHandler();
        String userName = userLogin.getText();
        String userPass = userPassword.getText();
        Users user =new Users(userName, userPass);
        dbHandler.signUpUser(user);


    }
}



