package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class VehicleCont {


    @FXML
    public Button V_Subs_Button;
    @FXML
    private Pane vehiclepane;

    @FXML
    public void subVehiclepage() throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("V_subscribe.fxml"));
        vehiclepane.getChildren().setAll(root);
    }

}


