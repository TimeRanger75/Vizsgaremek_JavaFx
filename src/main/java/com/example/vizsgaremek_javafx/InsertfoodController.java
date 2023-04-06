package com.example.vizsgaremek_javafx;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import java.io.IOException;

public class InsertfoodController extends Controller {
    @FXML
    private Button Feltölt;
    @FXML
    private TextField fatField;
    @FXML
    private TextField calorieField;
    @FXML
    private TextField proteinField;
    @FXML
    private TextField nameField;
    @FXML
    private TextField carboField;

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
        fatField.setText("0");
    }

    @FXML
    public void submitClick(ActionEvent actionEvent) {
        name=nameField.getText().trim();
        try {
            calorie=Double.parseDouble(calorieField.getText());
            fat=Double.parseDouble(fatField.getText());
            carbo=Double.parseDouble(carboField.getText());
            protein=Double.parseDouble(proteinField.getText());
        }catch (NumberFormatException e){
            warning("Csak szám adható meg a név mezőn kívül!");
            return;
        }
        if (name.isEmpty()){
            warning("Név megadása kötelező");
            return;
        }
        if (fat<=0 || calorie<=0 || carbo<=0 || protein<=0){
            warning("Nem lehet 0 vagy annál kisebb érték");
            return;
        }
        Food newFood=new Food(name,0,calorie,protein,carbo,fat);
        Gson converter=new Gson();
        String json=converter.toJson(newFood);
        try{
            Response response=RequestHandler.post(BASE_URL+"/food", json);
            if (response.getResponseCode()==201){
                nameField.setText("");
                carboField.setText("0");
                calorieField.setText("0");
                fatField.setText("0");
                proteinField.setText("0");
            }
        }catch (IOException e){
            error("A szerverhez való kapcsolódás sikertelen", e.getMessage());
        }
    }
}
