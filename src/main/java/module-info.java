module com.example.vizsgaremek_javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;
    requires java.net.http;
    requires spring.security.crypto;


    opens com.example.vizsgaremek_javafx to javafx.fxml, com.google.gson ;
    exports com.example.vizsgaremek_javafx;
}