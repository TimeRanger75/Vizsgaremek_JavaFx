package com.example.vizsgaremek_javafx;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import java.io.IOException;
import java.util.ResourceBundle;

public class InsertfoodController extends AlertController {
    @FXML
    private Button Feltölt;
    @FXML
    private Spinner<Double> fatField;
    @FXML
    private Spinner<Double> calorieField;
    @FXML
    private Spinner<Double> proteinField;
    @FXML
    private TextField nameField;
    @FXML
    private Spinner<Double> carboField;

    @FXML
    private void initialize(){
        SpinnerValueFactory.DoubleSpinnerValueFactory FatvalueFactory=new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 300, 50.0);
        fatField.setValueFactory(FatvalueFactory);

        SpinnerValueFactory.DoubleSpinnerValueFactory CarbovalueFactory=new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 300, 50.0);
        carboField.setValueFactory(CarbovalueFactory);

        SpinnerValueFactory.DoubleSpinnerValueFactory ProteinvalueFactory=new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 300, 50.0);
        proteinField.setValueFactory(ProteinvalueFactory);

        SpinnerValueFactory.DoubleSpinnerValueFactory CalorievalueFactory=new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, 300, 50.0);
        calorieField.setValueFactory(CalorievalueFactory);
    }

    @FXML
    public void submitClick(ActionEvent actionEvent) {
        String name=nameField.getText().trim();
        double calorie=calorieField.getValue();
        double fat=fatField.getValue();
        double carbo=carboField.getValue();
        double protein=proteinField.getValue();
        if (name.isEmpty()){
            warning("Név megadása kötelező");
            return;
        }
        Food newFood=new Food(name,0,calorie,protein,carbo,fat);
        Gson converter=new Gson();
        String json=converter.toJson(newFood);
        try{
            Response response=RequestHandler.post(Food.FOOD_URL, json);
            if (response.getResponseCode()==201){
                nameField.setText("");
                carboField.getValueFactory().setValue(50.0);
                calorieField.getValueFactory().setValue(50.0);
                fatField.getValueFactory().setValue(50.0);
                proteinField.getValueFactory().setValue(50.0);
            }
        }catch (IOException e){
            error("A szerverhez való kapcsolódás sikertelen", e.getMessage());
        }
    }
}
