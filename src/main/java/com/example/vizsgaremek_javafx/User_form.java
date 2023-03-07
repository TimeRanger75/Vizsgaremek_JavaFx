package com.example.vizsgaremek_javafx;

public class User_form {


    private int id;
    private int weight;
    private int height;
    private int age;
    private String lifestyle;
    private String gender;
    private String diet_plan;
    private int weight_goal;
    private String look;
    private String water_consume;


    public User_form(int id, int weight, int height, int age, String lifestyle, String gender, String diet_plan, int weight_goal, String look, String water_consume) {
        this.id = id;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.lifestyle = lifestyle;
        this.gender = gender;
        this.diet_plan = diet_plan;
        this.weight_goal = weight_goal;
        this.look = look;
        this.water_consume = water_consume;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(String lifestyle) {
        this.lifestyle = lifestyle;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDiet_plan() {
        return diet_plan;
    }

    public void setDiet_plan(String diet_plan) {
        this.diet_plan = diet_plan;
    }

    public int getWeight_goal() {
        return weight_goal;
    }

    public void setWeight_goal(int weight_goal) {
        this.weight_goal = weight_goal;
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }

    public String getWater_consume() {
        return water_consume;
    }

    public void setWater_consume(String water_consume) {
        this.water_consume = water_consume;
    }
}
