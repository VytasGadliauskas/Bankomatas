package com.bank.bancomatclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    public AnchorPane ap;

    int enteredBadPinCount = 0;

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
            CreditCard.setCardPin(textPin.getText().trim());
            NetworkClient networkClient = new NetworkClient();
            String response = networkClient.serverConnectResponce("CHECK_CARD_PIN");
            System.out.println(response);
            if ("CREDIT_CARD_PIN_OK".equals(response)) {
                Parent fxml = FXMLLoader.load(getClass().getResource("SelectOperation.fxml"));
                Scene scene = new Scene(fxml);
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.setScene(scene);
                stage.show();
            }
            else {
                enteredBadPinCount++;
                textPin.setText("");
                labelPin.setText(Languages.getBAD_PIN(CreditCard.getLanguage()));
                if (enteredBadPinCount >= 3){
                    showTakeOutForm();
                }
            }
        } else {
            labelPin.setText(Languages.getBAD_PIN(CreditCard.getLanguage()));
        }
    }

    private void showTakeOutForm() throws IOException {
        CreditCard.setCommand("3_TIMES_WRONG_PIN");
        NetworkClient networkClient = new NetworkClient();
        String response = networkClient.serverConnectResponce("\u001B[31m3_TIMES_WRONG_PIN\u001B[0m");
        Parent fxml = FXMLLoader.load(getClass().getResource("TakeCreditCard.fxml"));
        Scene scene = new Scene(fxml);
        Stage stage = (Stage) ap.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelPin.setText(Languages.getENTER_PIN(CreditCard.getLanguage()));
    }
}
