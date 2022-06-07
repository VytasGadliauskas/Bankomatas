package com.bank.bancomatclient;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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

public class TakeCreditCardController implements Initializable {
    Timeline timeline = new Timeline();
    @FXML
    public AnchorPane ap;
    @FXML
    private Label labelTakeCreditCard;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if ("NOT_FOUND".equals(CreditCard.getCardNumber())) {
            labelTakeCreditCard.setText(Languages.getTAKE_BAD_CARD(CreditCard.getLanguage()));
        } else {
            labelTakeCreditCard.setText(Languages.getTAKE_CARD(CreditCard.getLanguage()));
        }

        KeyFrame kf = new KeyFrame(Duration.seconds(0),
                event -> {
                    try {
                        String cardNumber = HardwareInterface.getCreditCardNumber();
                        if ("".equals(cardNumber)){
                            System.out.println("Kortele isimta");
                            CreditCard.setCardNumber(cardNumber);
                            timeline.stop();
                            Parent fxml = FXMLLoader.load(getClass().getResource("Start.fxml"));
                            Scene scene = new Scene(fxml);
                            Stage stage = (Stage) ap.getScene().getWindow();
                            stage.setScene(scene);
                            stage.show();
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
