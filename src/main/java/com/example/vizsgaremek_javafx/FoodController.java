package com.example.vizsgaremek_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FoodController {
    @FXML
    private Button btnFelvetel;
    @FXML
    private GridPane userTable;
    @FXML
    private Button btnStat;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnUser;

    @FXML
    public void clickStat(ActionEvent actionEvent) {
    }

    @FXML
    public void clickFelvetel(ActionEvent actionEvent) {
    }

    @FXML
    public void clickExit(ActionEvent actionEvent) {
        Stage stage = (Stage) this.btnExit.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void clickUser(ActionEvent actionEvent) {

    }
}
