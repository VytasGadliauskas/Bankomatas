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

public class EnterMoneyCountController  implements Initializable {
    @FXML
    private Label labelbtnEnterMoneyValue;

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
    void button_CancelClick(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("TakeCreditCard.fxml"));
        Scene scene = new Scene(fxml);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void button_Money100Click(MouseEvent event) throws IOException {
        CreditCard.setCommandArg("100");
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

    @FXML
    void button_Money200Click(MouseEvent event) throws IOException {
        CreditCard.setCommandArg("200");
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

    @FXML
    void button_Money50Click(MouseEvent event) throws IOException {
        CreditCard.setCommandArg("50");
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

    @FXML
    void button_MoneyCustomClick(MouseEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(getClass().getResource("EnterMoneyValue.fxml"));
        Scene scene = new Scene(fxml);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelbtnEnterMoneyValue.setText(Languages.getENTER_VALUE(CreditCard.getLanguage()));
    }
}