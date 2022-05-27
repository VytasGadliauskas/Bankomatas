package com.bank.bancomatclient;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.UUID;

public class StartController  implements Initializable {

    @FXML
    void buttonLangEN_OnClick(MouseEvent event) throws IOException {
        if("".equals(CreditCard.getSessionId())) {
            CreditCard.setSessionID(UUID.randomUUID().toString());
            CreditCard.setLanguage("EN");
        } else {
            CreditCard.Clear();
            CreditCard.setSessionID(UUID.randomUUID().toString());
            CreditCard.setLanguage("EN");
        }
        Parent fxml = FXMLLoader.load(getClass().getResource("InsertCard.fxml"));
        Scene scene = new Scene(fxml);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void buttonLangLT_OnClick(MouseEvent event) throws IOException {
        if("".equals(CreditCard.getCard().get("SESSIONID"))) {
            CreditCard.setSessionID(UUID.randomUUID().toString());
            CreditCard.setLanguage("LT");
        } else {
            CreditCard.Clear();
            CreditCard.setSessionID(UUID.randomUUID().toString());
            CreditCard.setLanguage("LT");
        }
        Parent fxml = FXMLLoader.load(getClass().getResource("InsertCard.fxml"));
        Scene scene = new Scene(fxml);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void buttonLangRU_OnClick(MouseEvent event) throws IOException {
        if("".equals(CreditCard.getCard().get("SESSIONID"))) {
            CreditCard.setSessionID(UUID.randomUUID().toString());
            CreditCard.setLanguage("RU");
        } else {
            CreditCard.Clear();
            CreditCard.setSessionID(UUID.randomUUID().toString());
            CreditCard.setLanguage("RU");
        }
        Parent fxml = FXMLLoader.load(getClass().getResource("InsertCard.fxml"));
        Scene scene = new Scene(fxml);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}