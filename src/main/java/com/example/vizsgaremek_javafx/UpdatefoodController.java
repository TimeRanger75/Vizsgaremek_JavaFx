package com.example.vizsgaremek_javafx;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;

public class UpdatefoodController extends AlertController{
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
    private Button btnUpdate;

    private Food food;

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

    public  void setFood(Food food){
        this.food=food;
        nameField.setText(this.food.getName());
        fatField.getValueFactory().setValue(this.food.getFat());
        carboField.getValueFactory().setValue(this.food.getCarbohydrate());
        proteinField.getValueFactory().setValue(this.food.getProtein());
        calorieField.getValueFactory().setValue(this.food.getCalorie());
    }

    @FXML
    public void updateClick(ActionEvent actionEvent) {
        String foodName=nameField.getText().trim();
        double fat=fatField.getValue();
        double calorie=calorieField.getValue();
        double carbo=carboField.getValue();
        double protein=proteinField.getValue();
        if (foodName.isEmpty()){
            warning("Név megadása kötelező");
            return;
        }
        this.food.setName(foodName);
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
