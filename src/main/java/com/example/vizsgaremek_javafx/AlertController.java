package com.example.vizsgaremek_javafx;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public abstract class AlertController {
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
        alert.setTitle(header_text);
        alert.setHeaderText(header_text);
        alert.setContentText(content_text);
        return alert.showAndWait();
    }
}
