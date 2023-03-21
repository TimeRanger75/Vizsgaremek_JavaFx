package com.example.vizsgaremek_javafx;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    private TextField textFieldPass;

    private Admin[] admins;


    @FXML
    private void initialize() throws IOException{
        loadAdmin();
        System.out.println(admins);
        String salt=BCrypt.gensalt(10);
        System.out.println(salt);
        for (Admin admin :
                admins) {
            boolean pass = BCrypt.checkpw("Scorpion75", admin.getPassword());
            System.out.println(pass);
        }

    }

    @FXML
    public void loginClick(ActionEvent actionEvent) throws IOException {
        for (Admin admin: admins) {
            if (admin.getUsername().equals(textFieldName.getText().trim()) && BCrypt.checkpw(textFieldPass.getText().trim(), admin.getPassword())){
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("admin.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 800, 600);
                Stage adminStage = new Stage();
                Stage stage = (Stage) this.btnLogin.getScene().getWindow();
                stage.close();
                adminStage.setTitle("Create person");
                adminStage.setScene(scene);
                adminStage.show();
            }
        }

    }


    private void  loadAdmin()throws IOException{
        Response response=RequestHandler.get(Admin.ADMIN_URL);
        String content=response.getContent();
        Gson converter=new Gson();
        admins=converter.fromJson(content, Admin[].class);

    }

    /*private  String hashPassword(String password){
        try {
            MessageDigest md= MessageDigest.getInstance("SHA-256");
            byte[] hashedPasswordBytes=md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedPasswordBytes);
        }catch (NoSuchAlgorithmException e){
            error("Hiba", e.getMessage());
            return null;
        }
    }*/
}
