module com.example.tzpizza {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tzpizza to javafx.fxml;
    exports com.example.tzpizza;
}