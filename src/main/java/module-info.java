module com.bank.bancomatclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;


    opens com.bank.bancomatclient to javafx.fxml;
    exports com.bank.bancomatclient;
}