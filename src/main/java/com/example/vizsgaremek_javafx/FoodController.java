package com.example.vizsgaremek_javafx;

import com.google.gson.Gson;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class FoodController {
    @FXML
    private Button btnStat;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnUser;
    @FXML
    private Button btnInsert;
    @FXML
    private TableColumn<Food, Double> protein;
    @FXML
    private TableColumn<Food,String> name;
    @FXML
    private TableColumn<Food, Double> calorie;
    @FXML
    private TableColumn<Food, Double> fat;
    @FXML
    private TableColumn<Food,Double> carbohydrate;
    @FXML
    private TableView tableFoods;


    @FXML
    private void initialize(){
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        calorie.setCellValueFactory(new PropertyValueFactory<>("calorie"));
        protein.setCellValueFactory(new PropertyValueFactory<>("protein"));
        fat.setCellValueFactory(new PropertyValueFactory<>("fat"));
        carbohydrate.setCellValueFactory(new PropertyValueFactory<>("carbohydrate"));
        Platform.runLater(()->{
            try {
                loadFoods();
            }catch (IOException e){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Hiba történt az adatok betöltése során");
                alert.setContentText(e.getMessage());
                Platform.exit();
            }
        });

    }

    private void loadFoods()throws IOException{
        Response response=RequestHandler.get(Food.FOOD_URL);
        String content=response.getContent();
        Gson converter=new Gson();
        Food[] foods=converter.fromJson(content, Food[].class);
        tableFoods.getItems().clear();
        for (Food food: foods){
            tableFoods.getItems().add(food);
        }
    }

    @FXML
    public void clickStat(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(App.class.getResource("stat.fxml"));
            Scene scene=new Scene(fxmlLoader.load(), 800, 600);
            Stage stat=new Stage();
            Stage food = (Stage) this.btnExit.getScene().getWindow();
            food.close();
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
    public void clickExit(ActionEvent actionEvent) {
        Stage stage = (Stage) this.btnExit.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void clickUser(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader=new FXMLLoader(App.class.getResource("admin.fxml"));
            Scene scene=new Scene(fxmlLoader.load(), 800, 600);
            Stage admin=new Stage();
            Stage food = (Stage) this.btnExit.getScene().getWindow();
            food.close();
            admin.setTitle("Felhasználók");
            admin.setScene(scene);
            admin.show();
        } catch (IOException e) {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hiba");
            alert.setContentText("Nem lehet elérni a táblát");
        }
    }

    @FXML
    public void clickInsert(ActionEvent actionEvent) {
        try {
            FXMLLoader fxmlLoader =new FXMLLoader(App.class.getResource("insertfood.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 640, 480);
            Stage stage = new Stage();
            stage.setTitle("Étel hozzáadása");
            stage.setScene(scene);
            stage.setOnCloseRequest(event ->{
                try {
                    loadFoods();
                }catch (IOException e){
                    Alert error=new Alert(Alert.AlertType.ERROR);
                    error.setHeaderText("Hiba történt a kapcsolódás során");
                    error.showAndWait();
                }
            });
            stage.show();
        }catch (IOException e){
            Alert error=new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("Hiba történt a betöltés során");
            error.showAndWait();
        }
    }
}
