package sample.Controlers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DB.DatabaseHandler;
import sample.Users;
import sample.Animations.Shacke;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button authSignInButton;

    @FXML
    private Button loginSignUpButton;

    @FXML
    private TextField login_field;

    @FXML
    private PasswordField password_field;

    @FXML
    void initialize() {
        authSignInButton.setOnAction(actionEvent -> {
                    String loginText = login_field.getText().trim();
                    String loginPassword = password_field.getText().trim();
                    if (!loginText.equals("") && !loginPassword.equals("")) {
                        loginUser(loginText, loginPassword);
                    } else
                        System.out.println("error login & password is empty");
                }
        );
        loginSignUpButton.setOnAction(actionEvent -> {
                    loginSignUpButton.getScene().getWindow().hide();
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/sample/JavaFX/signup.fxml"));
                    try {
                        loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Parent root = loader.getRoot();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root));
                    stage.showAndWait();
                }
        );
    }

    private void loginUser(String loginText, String loginPassword) {

        DatabaseHandler dbHandler = new DatabaseHandler();
        Users user = new Users();
        user.setUserName(loginText);
        user.setUserPass(loginPassword);
        ResultSet result = dbHandler.getUser(user);
        int counter = 0;
        try {
            while (result.next()) {
                counter++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        if (counter >= 1) {
            openNewScene("/sample/JavaFX/app.fxml");
        } else {
            Shacke userLoginAnim = new Shacke(login_field);
            Shacke loginSignAnim = new Shacke(password_field);
            userLoginAnim.playAnim();
            loginSignAnim.playAnim();
        }

    }

    public void openNewScene(String window) {
        authSignInButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }

}
