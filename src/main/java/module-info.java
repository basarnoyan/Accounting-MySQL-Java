module com.example.accounting {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.accounting to javafx.fxml;
    exports com.example.accounting;
}