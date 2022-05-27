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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InsertCardController implements Initializable {

    @FXML
    private Label labelInsertCreditCard;

    @FXML
    void buttonBack_OnClick(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("Start.fxml"));
        Scene scene = new Scene(fxml);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void buttonOK_OnClick(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("EnterPin.fxml"));
        Scene scene = new Scene(fxml);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelInsertCreditCard.setText(Languages.getINSERT_CREDIT_CARD(CreditCard.getLanguage()));
        System.out.println("session id "+CreditCard.getSessionId());
    }

}
