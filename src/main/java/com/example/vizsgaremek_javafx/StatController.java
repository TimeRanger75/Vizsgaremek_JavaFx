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

    private User_form[] users;
    @FXML
    private StackedBarChart stcackedBarChart;
    @FXML
    private PieChart pieChart;

    @FXML
    private void initialize() throws IOException {
        loadForm();

        /*int males=0;
        int females=0;
        int above_25=0;
        int below_25=0;
        int ectomorph=0;
        int endomorph=0;
        int mesomorph=0;
        for (User_form user :
                users) {
            switch (user.getGender()){
                case "Male":
                    males++;
                    break;
                case "Female":
                    females++;
                    break;
                default:break;
            }
            int signum= Integer.signum(user.getAge()-25);
            switch (signum){
                case -1:
                    below_25++;
                    break;
                case 0:
                    above_25++;
                    break;
                case 1:
                    above_25++;
                    break;
                default:break;
            }
            switch (user.getLook()){
                case "mesomorph":
                    mesomorph++;
                    break;
                case "endomorph":
                    endomorph++;
                    break;
                case "ectomorph":
                    ectomorph++;
                    break;
                default:break;
            }

        }

        XYChart.Series series1=new XYChart.Series();
        XYChart.Series series2=new XYChart.Series();

        series1.setName("Nem");
        series1.getData().add(new XYChart.Data("Férfi", males));
        series1.getData().add(new XYChart.Data("Nő", females));

        series2.setName("Kor");
        series2.getData().add(new XYChart.Data("25 évnél idősebb",above_25));
        series2.getData().add(new XYChart.Data("25 évnél fiatalabb",below_25));

        stcackedBarChart.getData().addAll(series1, series2);

        ObservableList<PieChart.Data> pieChartData= FXCollections.observableArrayList(
                new PieChart.Data("Nehezen hízó", ectomorph),
                new PieChart.Data("Normál",mesomorph),
                new PieChart.Data("Nehezen fogyó", endomorph));
        pieChart.setData(pieChartData);
        pieChart.setTitle("Testalkat");
        pieChart.setClockwise(false);
        */
    }

    private void loadForm()throws IOException{
        Response response=RequestHandler.get(User_form.Form_URL);
        String content= response.getContent();
        Gson converter=new Gson();
        users=converter.fromJson(content, User_form[].class);

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
