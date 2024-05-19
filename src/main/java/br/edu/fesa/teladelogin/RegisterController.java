package br.edu.fesa.teladelogin;

import database.UserDB;
import database.UserMapDB;
import database.dataModel.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    UserMapDB database = UserMapDB.getInstance();

    @FXML
    private ImageView shieldImageView;
    @FXML
    private Button closeButton;
    @FXML
    private Label registrationMessageLabel;
    @FXML
    private Label confirmPasswordLabel;

    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField setPasswordField;
    @FXML
    private PasswordField confirmPasswordField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("images/imagemRegistro.jpg");
        Image image = new Image(file.toURI().toString());
        shieldImageView.setImage(image);
    }

    public void registerButtonOnAction(ActionEvent event) {
        if(setPasswordField.getText().equals(confirmPasswordField.getText())) {
            registerUser();
            registrationMessageLabel.setText("User has been registered successfully!");
        } else {
            confirmPasswordLabel.setText("Password does not match");
        }
    }

    public void closeButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
//        Platform.exit();
    }

    public void registerUser() {
        User user = new User(firstnameTextField.getText(), lastnameTextField.getText(),
                usernameTextField.getText(), setPasswordField.getText());
        database.create(database.getValidId(), user);
    }

}