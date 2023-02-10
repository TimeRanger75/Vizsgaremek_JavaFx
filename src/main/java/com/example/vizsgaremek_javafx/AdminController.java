package com.example.vizsgaremek_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AdminController {
    @FXML
    private Button btnFelvetel;
    @FXML
    private GridPane userTable;
    @FXML
    private Button btnStat;
    @FXML
    private Button btnExit;

    @FXML
    public void clickStat(ActionEvent actionEvent) {
        System.out.println("asd");
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(App.class.getResource("stat.fxml"));
            Scene scene=new Scene(fxmlLoader.load(), 800, 600);
            Stage stat=new Stage();
            Stage stage = (Stage) this.btnExit.getScene().getWindow();
            stage.close();
            stat.setTitle("Statisztika");
            stat.setScene(scene);
            stat.show();
        } catch (IOException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba");
            alert.setContentText("Nem lehet elérni a táblát");
        }
    }

    @FXML
    public void clickFelvetel(ActionEvent actionEvent) {
        System.out.println("asd");
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(App.class.getResource("food.fxml"));
            Scene scene=new Scene(fxmlLoader.load(), 800, 600);
            Stage food=new Stage();
            Stage admin = (Stage) this.btnExit.getScene().getWindow();
            admin.close();
            food.setTitle("Étel felvétel");
            food.setScene(scene);
            food.show();
        } catch (IOException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba");
            alert.setContentText("Nem lehet elérni a táblát");
        }
    }

    @FXML
    public void clickExit(ActionEvent actionEvent) {
        Stage stage = (Stage) this.btnExit.getScene().getWindow();
        stage.close();
    }
}
