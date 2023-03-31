package com.example.vizsgaremek_javafx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public abstract class Controller {
    protected void warning(String header_text){
        alert(Alert.AlertType.WARNING, "Figyelmeztetés", header_text, "");
    }

    protected void error(String headerText) {
        error(headerText, "");
    }

    protected void error(String headerText, String contentText) {
        alert(Alert.AlertType.ERROR, "Hiba", headerText, contentText);
    }

    protected Optional<ButtonType> alert(Alert.AlertType alertType, String title, String header_text, String content_text){
        Alert alert=new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header_text);
        alert.setContentText(content_text);
        return alert.showAndWait();
    }

    protected void SceneOpen(String fmxl, String title, Button btn){
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(App.class.getResource(fmxl));
            Scene scene=new Scene(fxmlLoader.load(),800, 600);
            Stage stage=new Stage();
            Stage opened = (Stage) btn.getScene().getWindow();
            opened.close();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
            error("Nem lehet elérni a táblát: "+ e.getMessage());
        }
    }


    protected void SceneOpen(String fmxl, String title, int width, int height){
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(App.class.getResource(fmxl));
            Scene scene=new Scene(fxmlLoader.load(),width, height);
            Stage stage=new Stage();
            //Stage opened = (Stage) btn.getScene().getWindow();
            //opened.close();
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
            error("Nem lehet elérni a táblát: "+ e.getMessage());
        }
    }

}
