module org.beta {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.beta to javafx.fxml;
    exports org.beta;
}