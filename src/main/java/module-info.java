module org.beta {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.beta to javafx.fxml;
    exports org.beta;
    exports org.beta.controller;
    opens org.beta.controller to javafx.fxml;
}