package com.example.vizsgaremek_javafx;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class StatController extends Controller {

    @FXML
    private Button btnFelvetel;
    @FXML
    private GridPane userTable;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnUser;

    private User[] users;
    @FXML
    private StackedBarChart stcackedBarChart;
    @FXML
    private PieChart pieChart;

    @FXML
    private void initialize() throws IOException {
        loadUsers();

        XYChart.Series series1=new XYChart.Series();
        XYChart.Series series2=new XYChart.Series();

        series1.setName("Nem");
        series1.getData().add(new XYChart.Data("Felhasználók", users.length));
        series1.getData().add(new XYChart.Data("asdasd", 8));

        series2.setName("asd");
        series2.getData().add(new XYChart.Data("asdasda",16));
        series2.getData().add(new XYChart.Data("dsadwdw",20));

        stcackedBarChart.getData().addAll(series1, series2);

        ObservableList<PieChart.Data> pieChartData= FXCollections.observableArrayList(
                new PieChart.Data("Felhasználók", users.length),
                new PieChart.Data("asd",10),
                new PieChart.Data("Foods", 7));
        pieChart.setData(pieChartData);
        pieChart.setTitle("asd");
        pieChart.setClockwise(false);

    }

    private void loadUsers()throws IOException {
        Response response=RequestHandler.get(User.USER_URL);
        String content=response.getContent();
        Gson converter=new Gson();
        users=converter.fromJson(content, User[].class);


    }

    @FXML
    public void clickFelvetel(ActionEvent actionEvent) {
        SceneOpen("food.fxml","Ételek", this.btnExit);
    }

    @FXML
    public void clickExit(ActionEvent actionEvent) {
        Stage stage = (Stage) this.btnExit.getScene().getWindow();
        stage.close();

    }

    @FXML
    public void clickUser(ActionEvent actionEvent) {
        SceneOpen("admin.fxml", "Felhasználók", this.btnExit);
    }
}
