package com.example.demo6;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class PropertyCont {


    @FXML
    private Button P_Subs_Button;
    @FXML
    private Pane propertypain;
    @FXML
    public void subproprtypage() throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("P_subscribe.fxml"));
        propertypain.getChildren().setAll(root);
    }
}
