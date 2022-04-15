module com.example.govna {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.govna to javafx.fxml;
    exports com.example.govna;
}