package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class HealthCont {

    @FXML
    private Button H_Subs_Button;
    @FXML
    private Pane healthpane;
    @FXML
    public void subhealthpage() throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("H_subscribe.fxml"));
        healthpane.getChildren().setAll(root);
    }

}
