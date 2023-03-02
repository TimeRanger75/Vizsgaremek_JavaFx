module com.example.vizsgaremek_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;
    requires com.fasterxml.jackson.core;


    opens com.example.vizsgaremek_javafx to javafx.fxml, com.google.gson, com.fasterxml.jackson.core;
    exports com.example.vizsgaremek_javafx;
}