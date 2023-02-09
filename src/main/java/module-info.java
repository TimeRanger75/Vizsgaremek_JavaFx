module com.example.vizsgaremek_javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vizsgaremek_javafx to javafx.fxml;
    exports com.example.vizsgaremek_javafx;
}