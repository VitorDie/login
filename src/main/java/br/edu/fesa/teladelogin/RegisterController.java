package br.edu.fesa.teladelogin;

import database.UserMySqlDB;
import database.dataModel.User;
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
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterController implements Initializable {
    UserMySqlDB database = new UserMySqlDB();

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
        registrationMessageLabel.setText("");
        confirmPasswordLabel.setText("");

        if (!isEmailValid(usernameTextField.getText())) {
            registrationMessageLabel.setText("Isso não é um email válido");
            return;
        }

        if(!isPasswordMedium(setPasswordField.getText())) {
            confirmPasswordLabel.setText("A senha deve ter Pelo menos 8 caracteres, uma Letra maiúscula e número");
            return;
        }

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

    private boolean isPasswordStrong(String password) {
        String strongPasswordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$\n";

        Pattern strongPasswordPattern = Pattern.compile(strongPasswordRegex);

        Matcher strongPasswordMatcher = strongPasswordPattern.matcher(password);

        return strongPasswordMatcher.matches();
    }

    private boolean isPasswordMedium(String password) {
        String mediumPasswordRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";

        Pattern mediumPasswordPattern = Pattern.compile(mediumPasswordRegex);

        Matcher mediumPasswordMatcher = mediumPasswordPattern.matcher(password);

        return mediumPasswordMatcher.matches();
    }

    private boolean isEmailValid(String email) {
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern emailPattern = Pattern.compile(regex);

        Matcher matcher = emailPattern.matcher(email);

        return matcher.matches();

    }

}