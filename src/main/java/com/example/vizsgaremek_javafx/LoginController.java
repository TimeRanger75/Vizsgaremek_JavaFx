package com.example.vizsgaremek_javafx;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.springframework.security.crypto.bcrypt.BCrypt;


import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

public class LoginController extends Controller{
    @FXML
    private TextField textFieldName;
    @FXML
    private Button btnLogin;
    @FXML
    private PasswordField textFieldPass;

    private Admin[] admins;


    @FXML
    private void initialize() throws IOException {
        loadAdmin();
    }

    @FXML
    public void loginClick(ActionEvent actionEvent){
        boolean log=false;
        for (Admin admin: admins) {
            if (admin.getUsername().equals(textFieldName.getText().trim()) && BCrypt.checkpw(textFieldPass.getText().trim(), admin.getPassword())){
               log=true;
            }
        }
        if (!log){
            warning("Hibás adatok");
        }else{
            SceneOpen("admin.fxml", "Felhasználók", this.btnLogin);
        }
    }

    private void  loadAdmin()throws IOException{
        Response response=RequestHandler.get(BASE_URL+"/admin");
        String content=response.getContent();
        Gson converter=new Gson();
        admins=converter.fromJson(content, Admin[].class);

    }
}
