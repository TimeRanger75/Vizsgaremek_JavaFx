package com.example.vizsgaremek_javafx;

public class Admin {
    public static  final String ADMIN_URL="http://localhost:3000/admin";

    private String username;
    private String password;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
