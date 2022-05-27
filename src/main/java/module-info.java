module com.bank.bancomatclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.bank.bancomatclient to javafx.fxml;
    exports com.bank.bancomatclient;
}