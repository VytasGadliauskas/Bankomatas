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

public class NeedCheckController  implements Initializable {


    @FXML
    private Label labelNoCheque;

    @FXML
    private Label labelPrintCheque;

    @FXML
    void button_NoClick(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("TakeMoney.fxml"));
        Scene scene = new Scene(fxml);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void button_YesClick(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("TakeMoney.fxml"));
        Scene scene = new Scene(fxml);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelNoCheque.setText(Languages.getNO_CHECK(CreditCard.getLanguage()));
        labelPrintCheque.setText(Languages.getPRINT_CHECK(CreditCard.getLanguage()));
        System.out.println("session id "+CreditCard.getSessionId());
    }
}
