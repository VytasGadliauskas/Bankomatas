package com.bank.bancomatclient;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NoMoneyOnAccountController implements Initializable  {

    @FXML
    private Label labelInformation;

    @FXML
    void button_BackClick(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("SelectOperation.fxml"));
        Scene scene = new Scene(fxml);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelInformation.setText(Languages.getNO_MONEY_ON_ACCOUNT(CreditCard.getLanguage()));
    }
}