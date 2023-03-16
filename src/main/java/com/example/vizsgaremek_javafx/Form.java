package com.example.vizsgaremek_javafx;

public class Form {
    public static final String LOOK_URL="http://localhost:3000/calculator/body/search";
    public static final String AGE_URL="http://localhost:3000/calculator/body/search";
    public static final String GENDER_URL="http://localhost:3000/calculator/body/search";
    private String look;
    private int lookCount;
    private int age;
    private int ageCount;
    private String gender;
    private int genderCount;

    public Form(String look, int lookCount, int age, int ageCount, String gender, int genderCount) {
        this.look = look;
        this.lookCount = lookCount;
        this.age = age;
        this.ageCount = ageCount;
        this.gender = gender;
        this.genderCount = genderCount;
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }

    public int getLookCount() {
        return lookCount;
    }

    public void setLookCount(int lookCount) {
        this.lookCount = lookCount;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeCount() {
        return ageCount;
    }

    public void setAgeCount(int ageCount) {
        this.ageCount = ageCount;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getGenderCount() {
        return genderCount;
    }

    public void setGenderCount(int genderCount) {
        this.genderCount = genderCount;
    }
}
