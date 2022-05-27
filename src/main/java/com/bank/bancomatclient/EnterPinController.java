package com.bank.bancomatclient;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EnterPinController implements Initializable {

    @FXML
    private Label labelPin;

    @FXML
    private PasswordField textPin;

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
    void button_OnClick(MouseEvent event) throws IOException {
        if (textPin.getText().length() == 4) {
            CreditCard.setCardPin(textPin.getText());
            Parent fxml = FXMLLoader.load(getClass().getResource("SelectOperation.fxml"));
            Scene scene = new Scene(fxml);
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } else {
            Parent fxml = FXMLLoader.load(getClass().getResource("BadPin.fxml"));
            Scene scene = new Scene(fxml);
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelPin.setText(Languages.getENTER_PIN(CreditCard.getLanguage()));
        System.out.println("session id "+CreditCard.getSessionId());
    }
}
