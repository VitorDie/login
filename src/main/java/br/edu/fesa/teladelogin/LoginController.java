package br.edu.fesa.teladelogin;

import database.UserDB;
import database.UserMapDB;
import database.UserMySqlDB;
import database.dataModel.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    UserMySqlDB database = new UserMySqlDB();

    public LoginController() {
    }

    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView brandingImageView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField enterPasswordField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandingFile = new File("images/imagemLogin.jpg");
        Image brandingImage = new Image(brandingFile.toURI().toString());
        brandingImageView.setImage(brandingImage);
    }

    public void loginButtonOnAction(ActionEvent event) {
        if (!usernameTextField.getText().isBlank() && !enterPasswordField.getText().isBlank()) {
            validateLogin();
        } else {
            loginMessageLabel.setText("Please enter username and password");
        }
    }

    public void cancelButtonOnAction(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin() {
        String username = usernameTextField.getText();
        String password = enterPasswordField.getText();


        boolean status = false;
        ArrayList<User> lista = database.read();
        for (User user : lista){
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
               status = true;
               break;
            }
        }

        if (status)
            loginMessageLabel.setText("Congrats");
        else {
            //loginMessageLabel.setText("Invalid Login pleas try again");
            createAccountForm();
        }
    }

    public void createAccountForm() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));

            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(fxmlLoader.load(), 520, 478);
            registerStage.setScene(scene);
            registerStage.show();

        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}