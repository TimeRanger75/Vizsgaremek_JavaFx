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
import javafx.stage.Stage;

import java.io.IOException;

public class FoodController extends Controller {
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
    private Button btnUpdate;
    @FXML
    private TableColumn<Food, Number> id;


    @FXML
    private void initialize(){
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        calorie.setCellValueFactory(new PropertyValueFactory<>("calorie"));
        protein.setCellValueFactory(new PropertyValueFactory<>("protein"));
        fat.setCellValueFactory(new PropertyValueFactory<>("fat"));
        carbohydrate.setCellValueFactory(new PropertyValueFactory<>("carbohydrate"));
        Platform.runLater(()->{
            try {
                loadFoods();
            }catch (IOException e){
                error("Hiba történt a betöltés során", e.getMessage());
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

        SceneOpen("stat.fxml","Statisztika",this.btnExit);
    }

    @FXML
    public void clickExit(ActionEvent actionEvent) {
        Stage stage = (Stage) this.btnExit.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void clickUser(ActionEvent actionEvent) {

        SceneOpen("admin.fxml","Felhasználók", this.btnExit);

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
                    error("Hiba történt a kapcsolódás során");

                }
            });
            stage.show();
        }catch (IOException e){
            error("Hiba történt a betöltés során");
        }
    }

    @FXML
    public void clickUpdate(ActionEvent actionEvent) {
        Food selected= (Food) tableFoods.getSelectionModel().getSelectedItem();
        if (selected==null){
            Alert alert=new Alert(Alert.AlertType.WARNING);
            alert.setContentText("Válasszon ki egy ételt amit frissítene");
            alert.showAndWait();
            return;
        }try{
            FXMLLoader fxmlLoader=new FXMLLoader(App.class.getResource("updatefood.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 640, 480);
            UpdatefoodController controller=fxmlLoader.getController();
            controller.setFood(selected);
            Stage stage = new Stage();
            stage.setTitle(selected.getName()+" frissítése");
            stage.setScene(scene);
            stage.setOnHidden(event ->{
                try {
                    loadFoods();
                }catch (IOException e){
                    error("Nem lehet kapcsolódni a szerverhez");
                }
            });
            stage.show();
        }catch (IOException e){
            error("Hiba lépett fel a megnyitás során");
       }
    }
}
