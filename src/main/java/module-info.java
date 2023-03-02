module com.example.vizsgaremek_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;
    requires unirest.java;
    requires unirest.object.mappers.gson;


    opens com.example.vizsgaremek_javafx to javafx.fxml, com.google.gson , unirest.java;
    exports com.example.vizsgaremek_javafx;
}