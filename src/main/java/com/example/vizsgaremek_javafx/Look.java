package com.example.vizsgaremek_javafx;

public class Look {
    public static final String LOOK_URL="http://localhost:3000/calculator/body/search";
    private String look;
    private int count;

    public Look(String look, int count) {
        this.look = look;
        this.count = count;
    }

    public String getLook() {
        return look;
    }

    public void setLook(String look) {
        this.look = look;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
