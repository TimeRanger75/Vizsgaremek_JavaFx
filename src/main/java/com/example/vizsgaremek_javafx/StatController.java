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

    private Look[] looks;
    private Gender[] genders;
    private Age ages;

    @FXML
    private StackedBarChart stcackedBarChart;
    @FXML
    private PieChart pieChart;

    @FXML
    private void initialize() throws IOException {
        loadForm();
        loadGender();
        loadAge();

        XYChart.Series series1=new XYChart.Series();
        XYChart.Series series2=new XYChart.Series();

        series1.setName("Nem");
        for (Gender gender : genders) {
            series1.getData().add(new XYChart.Data(gender.getGender(),gender.getCount()));
        }

        series2.setName("Kor");
        series2.getData().add(new XYChart.Data("25 évnél idősebbek", ages.getAbove_25()));
        series2.getData().add(new XYChart.Data("25 évnél fiatalabbak", ages.getBelow_25()));


        stcackedBarChart.getData().addAll(series1, series2);

        ObservableList<PieChart.Data> pieChartData=FXCollections.observableArrayList();
        for (Look look : looks) {
           pieChartData.add( new PieChart.Data(look.getLook(), look.getCount()));
        }
        pieChart.setData(pieChartData);
        pieChart.setTitle("Testalkat");
        pieChart.setClockwise(false);

    }

    private void loadForm()throws IOException{
        Response response=RequestHandler.get(BASE_URL+"/calculator/body/search");
        String content= response.getContent();
        Gson converter=new Gson();
        looks=converter.fromJson(content, Look[].class);

    }

    private void loadGender()throws IOException{
        Response response=RequestHandler.get(BASE_URL+"/calculator/gender/search");
        String content=response.getContent();
        Gson converter=new Gson();
        genders=converter.fromJson(content, Gender[].class);
    }

    private void loadAge() throws IOException{
        Response response=RequestHandler.get(BASE_URL+"/calculator/age/search");
        String content=response.getContent();
        Gson converter=new Gson();
        ages=converter.fromJson(content, Age.class);

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
