module com.codinggacor.piggybank {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.codinggacor.piggybank to javafx.fxml;
    exports com.codinggacor.piggybank;
}