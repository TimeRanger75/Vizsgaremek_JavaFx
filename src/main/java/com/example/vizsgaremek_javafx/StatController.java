package com.example.vizsgaremek_javafx;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class StatController extends AlertController{

    @FXML
    private Button btnFelvetel;
    @FXML
    private GridPane userTable;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnUser;
    @FXML
    private BarChart barChart;

    private User[] users;

    @FXML
    private void initialize() throws IOException {
        loadUsers();
        final  String male="Férfi";
        final  String female="Nő";

        XYChart.Series series1=new XYChart.Series();
        series1.setName("Nem");
        series1.getData().add(new XYChart.Data("Felhasználók", users));


        barChart.getData().addAll(series1);
    }

    private void loadUsers()throws IOException {
        Response response=RequestHandler.get(User.USER_URL);
        String content=response.getContent();
        Gson converter=new Gson();
        users=converter.fromJson(content, User[].class);


    }

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
            error("Nem lehet elérni a táblát");
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
            error("Nem lehet elérni a táblát");
        }

    }
}
