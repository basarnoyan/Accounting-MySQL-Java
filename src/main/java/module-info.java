module com.example.accounting {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;



    opens com.example.accounting to javafx.fxml;
    exports com.example.accounting;
}