package com.example.vizsgaremek_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    @FXML
    private TextField textFieldName;
    @FXML
    private Button btnLogin;
    @FXML
    private TextField textFieldPass;

    @FXML
    public void loginClick(ActionEvent actionEvent) throws IOException {
        String adminName=textFieldName.getText().trim();
        String adminPass=textFieldPass.getText().trim();
        if (adminName.equals("Pelda admin") && adminPass.equals("asd123")){
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("admin.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 640, 480);
            Stage admin = new Stage();
            Stage stage = (Stage) this.btnLogin.getScene().getWindow();
            stage.close();
            admin.setTitle("Create person");
            admin.setScene(scene);
            admin.show();
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Hiba");
        }
    }
}
