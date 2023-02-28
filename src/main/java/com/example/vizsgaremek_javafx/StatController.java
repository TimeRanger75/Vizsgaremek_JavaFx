package com.example.vizsgaremek_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StatController {
    @FXML
    private Button btnFelvetel;
    @FXML
    private GridPane userTable;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnUser;

    @FXML
    public void clickFelvetel(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(App.class.getResource("food.fxml"));
            Scene scene=new Scene(fxmlLoader.load(), 800, 600);
            Stage food=new Stage();
            Stage stat = (Stage) this.btnExit.getScene().getWindow();
            stat.close();
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

    @FXML
    public void clickUser(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(App.class.getResource("admin.fxml"));
            Scene scene=new Scene(fxmlLoader.load(), 800, 600);
            Stage user=new Stage();
            Stage stat = (Stage) this.btnExit.getScene().getWindow();
            stat.close();
            user.setTitle("Étel felvétel");
            user.setScene(scene);
            user.show();
        } catch (IOException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba");
            alert.setContentText("Nem lehet elérni a táblát");
        }

    }
}
