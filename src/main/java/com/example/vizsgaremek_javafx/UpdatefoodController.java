package com.example.vizsgaremek_javafx;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class UpdatefoodController extends Controller {
    @FXML
    private TextField nameField;

    @FXML
    private TextField fatField;
    @FXML
    private TextField calorieField;
    @FXML
    private TextField proteinField;
    @FXML
    private TextField carboField;
    @FXML
    private Button btnUpdate;

    private Food food;

    private String name;
    private double calorie;
    private double fat;
    private double carbo;
    private double protein;

    @FXML
    private void initialize(){
        proteinField.setText("0");
        carboField.setText("0");
        calorieField.setText("0");
        proteinField.setText("0");
    }

    public  void setFood(Food food){
        this.food=food;
        nameField.setText(this.food.getName());
        fatField.setText(Double.toString(this.food.getFat()));
        carboField.setText(Double.toString(this.food.getCarbohydrate()));
        proteinField.setText(Double.toString(this.food.getProtein()));
        calorieField.setText(Double.toString(this.food.getCalorie()));
    }

    @FXML
    public void updateClick(ActionEvent actionEvent) {
        name=nameField.getText().trim();
        try {
            calorie=Double.parseDouble(calorieField.getText());
            fat=Double.parseDouble(fatField.getText());
            carbo=Double.parseDouble(carboField.getText());
            protein=Double.parseDouble(proteinField.getText());
        }catch (NumberFormatException e){
            warning("Csak szám adható meg a név mezőn kívül!");
        }
        if (name.isEmpty()){
            warning("Név megadása kötelező");
            return;
        }
        this.food.setName(name);
        this.food.setCalorie(calorie);
        this.food.setCarbohydrate(carbo);
        this.food.setFat(fat);
        this.food.setProtein(protein);
        Gson converter=new Gson();
        String json= converter.toJson(this.food);
        try {
            String url  = Food.FOOD_URL+"/"+this.food.getId();
            Response response= RequestHandler.put(url, json);
            if (response.getResponseCode()==200){
                Stage stage=(Stage) this.btnUpdate.getScene().getWindow();
                stage.close();
            }else{
                error("Hiba történt a frissítés során");
            }
        }catch (IOException e){
            error("Nem lehetett kapcsolódni a szerverhez");
        }
    }
}
