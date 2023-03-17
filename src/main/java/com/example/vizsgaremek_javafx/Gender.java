package com.example.vizsgaremek_javafx;

public class Gender {
    public static final String GENDER_URL="http://localhost:3000/calculator/gender/search";
    private String gender;
    private int count;

    public Gender(String gender, int count) {
        this.gender = gender;
        this.count = count;
    }

    public String getGender() {
        return gender;
    }

    public int getCount() {
        return count;
    }
}
