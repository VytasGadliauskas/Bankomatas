package com.bank.bancomatclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InsertCardController implements Initializable  {
    Timeline timeline = new Timeline();

    @FXML
    public AnchorPane ap;
    @FXML
    private Label labelInsertCreditCard;

    @FXML
    void buttonBack_OnClick(MouseEvent event) throws IOException {
        timeline.stop();
        Parent fxml = FXMLLoader.load(getClass().getResource("Start.fxml"));
        Scene scene = new Scene(fxml);
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelInsertCreditCard.setText(Languages.getINSERT_CREDIT_CARD(CreditCard.getLanguage()));
        CreditCard.setHwID();
        KeyFrame kf = new KeyFrame(Duration.seconds(0),
                        event -> {
                            try {
                                System.out.println("laukia korteles ...");
                                String cardNumber = HardwareInterface.getCreditCardNumber();
                                if (!"".equals(cardNumber)){
                                    System.out.println("Kortele ideta");
                                    CreditCard.setCardNumber(cardNumber.trim());
                                    timeline.stop();
                                    NetworkClient networkClient = new NetworkClient();
                                    String response = networkClient.serverConnectResponce("CHECK_CARD_NUMBER");
                                    if ("CREDIT_CARD_OK".equals(response)){
                                        Parent fxml = FXMLLoader.load(getClass().getResource("EnterPin.fxml"));
                                        Scene scene = new Scene(fxml);
                                        Stage stage = (Stage) ap.getScene().getWindow();
                                        stage.setScene(scene);
                                        stage.show();
                                    }  else {
                                        CreditCard.setCardNumber("NOT_FOUND");
                                        Parent fxml = FXMLLoader.load(getClass().getResource("TakeCreditCard.fxml"));
                                        Scene scene = new Scene(fxml);
                                        Stage stage = (Stage) ap.getScene().getWindow();
                                        stage.setScene(scene);
                                        stage.show();
                                    }
                                }
                            } catch (FileNotFoundException e) {
                                throw new RuntimeException(e);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
        timeline.getKeyFrames().addAll(kf, new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(timeline.INDEFINITE);
        timeline.play();
    }
}
