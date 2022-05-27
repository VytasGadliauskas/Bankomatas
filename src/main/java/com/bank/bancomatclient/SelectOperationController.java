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

public class SelectOperationController implements Initializable {

    public Label labelCheckAccount;
    public Label labelTakeMoney;

    @FXML
    void button_CancelClick(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("TakeCreditCard.fxml"));
        Scene scene = new Scene(fxml);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void button_CheckClick(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("ShowInformation.fxml"));
        Scene scene = new Scene(fxml);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void button_TakeMoneyClick(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("EnterMoneyCount.fxml"));
        Scene scene = new Scene(fxml);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelCheckAccount.setText(Languages.getCHECK_ACCOUNT(CreditCard.getLanguage()));
        labelTakeMoney.setText(Languages.getTAKE_MONEY(CreditCard.getLanguage()));
    }
}
