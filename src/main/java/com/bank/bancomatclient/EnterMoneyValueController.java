package com.bank.bancomatclient;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EnterMoneyValueController  implements Initializable {

    @FXML
    private Label labelEnterValue;

    @FXML
    private TextField textValue;

    @FXML
    void button_BackClick(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("SelectOperation.fxml"));
        Scene scene = new Scene(fxml);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void button_OnClick(MouseEvent event) throws IOException {
        CreditCard.setCommandArg(textValue.getText());
        NetworkClient networkClient = new NetworkClient();
        String response = networkClient.serverConnectResponce("TAKE_MONEY");
        if ("DONE".equals(response)) {
            Parent fxml = FXMLLoader.load(getClass().getResource("NeedCheck.fxml"));
            Scene scene = new Scene(fxml);
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } else {
            Parent fxml = FXMLLoader.load(getClass().getResource("NoMoneyOnAccount"));
            Scene scene = new Scene(fxml);
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelEnterValue.setText(Languages.getENTER_VALUE(CreditCard.getLanguage()));
    }
}
